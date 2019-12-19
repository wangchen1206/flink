package com.cc;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.sink.SinkFunction;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaProducer;
import org.apache.flink.util.Collector;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author cc
 */
public class App {
    public static void main(String[] args) throws Exception {
        flinkDemo2();
    }

    /**
     * kafka source
     */
    public static void flinkDemo0() throws Exception {
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.enableCheckpointing(1000);

        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", KafkaConfig.serverAddress);
        properties.setProperty("zookeeper.connect", KafkaConfig.zookeeperAddress);
        properties.setProperty("group.id", KafkaConfig.group);

        // 数据来源
        DataStream<String> stream = env
                .addSource(new FlinkKafkaConsumer<>("topic5", new SimpleStringSchema(), properties));


        // 数据处理 将收到的数据进行window ，filter 处理
        SingleOutputStreamOperator<Tuple2<String, Integer>> sum = stream.map(new MapFunction<String, Tuple2<String, Integer>>() {
            @Override
            public Tuple2<String, Integer> map(String value) throws Exception {
                return new Tuple2<>(value, 1);
            }
        })
                .keyBy(0)
                .timeWindow(Time.minutes(1))
                .sum(1);
        // 将数据打印到控制台
//        sum.print();

        SingleOutputStreamOperator<String> map = sum.map(a -> a.f0).filter(new FilterFunction<String>() {
            @Override
            public boolean filter(String value) throws Exception {
                Foo foo = JSONObject.parseObject(value, Foo.class);
                return foo.getName().equals("send1");
            }
        });
        FlinkKafkaProducer<String> myProducer = new FlinkKafkaProducer<String>(
                "localhost:9092",            // broker list
                "my-topic",                  // target topic
                new SimpleStringSchema());   // serialization schema
        myProducer.setWriteTimestampToKafka(true);
//        map.addSink(myProducer);
        map.addSink(new SinkFunction<String>() {
            @Override
            public void invoke(String value, Context context) throws Exception {
                Foo foo = JSONObject.parseObject(value, Foo.class);
                if (foo.getName().equals("send4")) {
                    return;
                }
                System.out.println("value is --- : " + foo.getName());
            }
        });
        map.print();
        // 这一行代码一定要实现，否则程序不执行
        env.execute("Board data from Kafka!");
    }


    /**
     * flink sink
     */
    public static void flinkDemo2() throws Exception {
        String ip = System.getProperty("redis.ip");
        String port = System.getProperty("redis.port");
        String exp = System.getProperty("redis.expiration");
        RedisUtil redisUtil = new RedisUtil(ip, Integer.valueOf(port));
        int expiration = Integer.valueOf(exp);
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.enableCheckpointing(1000);

        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", KafkaConfig.serverAddress);
        properties.setProperty("zookeeper.connect", KafkaConfig.zookeeperAddress);
        properties.setProperty("group.id", KafkaConfig.group);
//        properties.setProperty("enable.auto.commit", "true");
//        properties.setProperty("session.timeout.ms", "2000");
//        properties.setProperty("auto.commit.interval.ms", "10000");

        FlinkKafkaConsumer<String> consumer = new FlinkKafkaConsumer<String>("topic6", new SimpleStringSchema(), properties);
        //Flink从topic中最新的数据开始消费
        consumer.setStartFromLatest();
        // 数据来源
        DataStream<String> stream = env.addSource(consumer);
        //filter cartridge < 10
        SingleOutputStreamOperator<String> filter = stream.filter(new FilterFunction<String>() {
            @Override
            public boolean filter(String value) throws Exception {
                System.out.println(value);
                boolean flag = false;
                JSONObject boardObject = JSONObject.parseObject(value).getJSONObject("board");
                JSONObject printerObject = (JSONObject) (boardObject.getJSONArray("printers").get(0));
                JSONArray cartridgeObjects = printerObject.getJSONArray("cartridges");
                for (Object cartridgeObject : cartridgeObjects) {
                    if (((JSONObject) cartridgeObject).getInteger("level") < 10) {
                        flag = true;
                        break;
                    }
                }
                return flag;
            }
        });

        //数据处理，存储redis
        filter.addSink(new SinkFunction<String>() {
            @Override
            public void invoke(String value, Context context) throws Exception {
                System.out.println(value);

                try {
                    JSONObject boardObject = JSONObject.parseObject(value).getJSONObject("board");
                    JSONObject printerObject = (JSONObject) (boardObject.getJSONArray("printers").get(0));
                    JSONArray cartridgeObjects = printerObject.getJSONArray("cartridges");
                    String platformCode = JSONObject.parseObject(value).getString("platformCode");
                    String printerUuid = printerObject.getString("uuid");
                    String boardUuid = boardObject.getString("uuid");
                    if (redisUtil.get(printerUuid) != null && redisUtil.get(printerUuid).equals("low")) {
                        System.out.println(printerUuid + "  ---- the email has been to send ");
                    } else {
                        redisUtil.set(printerUuid, "low", expiration);
                        System.out.println(printerUuid + "  ---- start send email");
                    }
//                    System.out.println("printerUuid is --- : " + printerUuid + "and the cartridge level is " + ((JSONObject) cartridgeObjects.get(0)).getInteger("level"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

//        filter.print();
        // 这一行代码一定要实现，否则程序不执行
        env.execute("Board data from Kafka!");
    }


    public static void flinkDemo1() throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStreamSource<String> streamSource = env.fromElements("aa bb cc dd aa");
        SingleOutputStreamOperator<Tuple2<String, Integer>> sum = streamSource.map(new MapFunction<String, List<Tuple2<String, Integer>>>() {
            @Override
            public List<Tuple2<String, Integer>> map(String s) throws Exception {
                List<Tuple2<String, Integer>> list = new ArrayList<>();
                for (String s1 : s.split(" ")) {
                    Tuple2<String, Integer> tuple2 = null;
                    if (s1.equals("aa")) {
                        tuple2 = new Tuple2<>(s1, 3);
                    } else {
                        tuple2 = new Tuple2<>(s1, 1);
                    }
                    list.add(tuple2);
                }
                return list;
            }
        }).flatMap(new FlatMapFunction<List<Tuple2<String, Integer>>, Tuple2<String, Integer>>() {
            @Override
            public void flatMap(List<Tuple2<String, Integer>> tuple2s, Collector<Tuple2<String, Integer>> collector) throws Exception {
                for (Tuple2<String, Integer> tuple2 : tuple2s) {
                    collector.collect(tuple2);
                }
            }
        })
                .keyBy(0)
                .sum(1)
                .keyBy(0)
                .max(1);
        sum.print();
        env.execute();
    }

    public static class Splitter implements FlatMapFunction<String, Tuple2<String, Integer>> {

        @Override
        public void flatMap(String value, Collector<Tuple2<String, Integer>> out) throws Exception {
            for (String word : value.split(" ")) {
                out.collect(new Tuple2<String, Integer>(word, 1));
            }
        }
    }
}
