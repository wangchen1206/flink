package com.cc;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

import java.io.Serializable;
import java.util.*;


/**
 * @author wachen
 */
public class RedisUtil implements Serializable {
    private String ip ;
    private Integer port ;

    public RedisUtil(String ip,Integer port) {
        this.ip = ip;
        this.port = port;
    }

    //获取连接
    public Jedis connection() throws Exception {

        Jedis jedis = new Jedis(ip, port);
        return jedis;
    }


    /**
     * 为string添加元素
     *
     * @param key
     * @param value
     * @throws Exception
     */
    public void set(String key, String value) throws Exception {
        Jedis jedis = connection();
        jedis.set(key, value);

    }

    /**
     * 设置key,过期时间 ，秒
     *
     * @param key
     * @param value
     * @param expiration
     * @throws Exception
     */
    public void set(String key, String value, int expiration) throws Exception {
        SetParams setParams = new SetParams();

        Jedis jedis = connection();
        jedis.set(key, value);
        jedis.expire(key, expiration);

    }

    /**
     * 获取string
     *
     * @param key
     * @return
     * @throws Exception
     */
    public String get(String key) throws Exception {
        Jedis jedis = connection();
        return jedis.get(key);
    }


    /**
     * 追加string
     */
    public void append(String key, String value) throws Exception {
        Jedis jedis = connection();
        jedis.append(key, value);
    }

    /**
     * 添加set
     *
     * @param key
     * @param value
     * @throws Exception
     */
    public void sadd(String key, Set<String> value) throws Exception {
        Jedis jedis = connection();
        for (String str : value) {
            jedis.sadd(key, str);
        }
    }

    /**
     * set删除指定元素
     *
     * @param key
     * @param value
     * @throws Exception
     */
    public void srem(String key, Set<String> value) throws Exception {
        Jedis jedis = connection();
        Iterator<String> it = value.iterator();
        while (it.hasNext()) {
            String str = it.next();
            jedis.srem(key, str);
        }
    }

    /**
     * 获取key对应的value总数
     *
     * @param key
     * @return
     * @throws Exception
     */
    public Long scard(String key) throws Exception {
        Jedis jedis = connection();
        return jedis.scard(key);
    }

    /**
     * 获取key对应的所有value
     *
     * @param key
     * @return
     * @throws Exception
     */
    public Set<String> smembers(String key) throws Exception {
        Jedis jedis = connection();
        return jedis.smembers(key);
    }

    /**
     * 判断set是否存在
     *
     * @param key
     * @param value
     * @return
     * @throws Exception
     */
    public boolean sismember(String key, String value) throws Exception {
        Jedis jedis = connection();
        return jedis.sismember(key, value);
    }

    /**
     * 随机获取数据
     *
     * @param key
     * @return
     * @throws Exception
     */
    public String srandmember(String key) throws Exception {
        Jedis jedis = connection();
        return jedis.srandmember(key);
    }


    /**
     * 向list添加元素
     *
     * @param key
     * @param list
     * @throws Exception
     */
    public void lpush(String key, List<String> list) throws Exception {
        Jedis jedis = connection();
        for (String s : list) {
            jedis.lpush(key, s);
        }
    }

    /**
     * 获取list
     *
     * @param key
     * @param start
     * @param end
     * @return
     * @throws Exception
     */
    public List<String> lrange(String key, Integer start, Integer end)
            throws Exception {
        Jedis jedis = connection();
        return jedis.lrange(key, start, end);
    }

    /**
     * 删除任意类型的key
     *
     * @param key
     * @throws Exception
     */
    public void del(String key) throws Exception {
        Jedis jedis = connection();
        jedis.del(key);
    }

    /**
     * 设置map
     *
     * @param key
     * @param map
     * @throws Exception
     */
    public void hmset(String key, Map<String, String> map) throws Exception {
        Jedis jedis = connection();
        jedis.hmset(key, map);
    }

    /**
     * 获取map的key的个数
     *
     * @param key
     * @return
     * @throws Exception
     */
    public Long hlen(String key) throws Exception {
        Jedis jedis = connection();
        return jedis.hlen(key);
    }

    /**
     * 获取map中所有key
     *
     * @param key
     * @return
     * @throws Exception
     */
    public Set<String> hkeys(String key) throws Exception {
        Jedis jedis = connection();
        return jedis.hkeys(key);
    }

    /**
     * 获取map中所有value
     *
     * @param key
     * @return
     * @throws Exception
     */
    public List<String> hvals(String key) throws Exception {
        Jedis jedis = connection();
        return jedis.hvals(key);
    }

    /**
     * 获取map中的指定key的value
     *
     * @param key
     * @param params
     * @return
     * @throws Exception
     */
    public List<String> hmget(String key, String... params)
            throws Exception {
        Jedis jedis = connection();
        if (null == params || params.length == 0) {
            throw new RuntimeException(this.getClass().getSimpleName() + "::"
                    + new Exception().getStackTrace()[0].getMethodName() + "参数不能为空");
        }
        return jedis.hmget(key, params);
    }

    /**
     * 获取map所有的key和value
     *
     * @param key
     * @return
     * @throws Exception
     */
    public Map<String, String> hgetAll(String key)
            throws Exception {
        Jedis jedis = connection();
        return jedis.hgetAll(key);
    }

    /**
     * 删除指定key的map
     *
     * @param key
     * @param params
     * @throws Exception
     */
    public void hdel(String key, String... params) throws Exception {
        Jedis jedis = connection();
        if (null == params || params.length == 0) {
            throw new RuntimeException(this.getClass().getSimpleName() + "::"
                    + new Exception().getStackTrace()[0].getMethodName() + "参数不能为空");
        }
        jedis.hdel(key, params);
    }

}