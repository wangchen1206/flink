package com.flink.flinksource;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Author: cc
 * @Date: 2019/10/31 19:25
 */
@Component
public class KafkaSourceTask {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Scheduled(initialDelay = 5000, fixedDelay = 20000)
    public void send1() {


        String boardMsg = "{\n" +
                "    \"randomId\": \"0bf60a7d-10a2-4a72-a6ed-12e3593e37d9\",\n" +
                "    \"board\": {\n" +
                "        \"setupUrl\": \"\",\n" +
                "        \"macAddress\": \"02:92:79:13:0a:7d\",\n" +
                "        \"printers\": [\n" +
                "            {\n" +
                "                \"serialNumber\": \"VNC3D00704\",\n" +
                "                \"cartridges\": [\n" +
                "                    {\n" +
                "                        \"serialNumber\": \"234951578\",\n" +
                "                        \"level\": \"7\",\n" +
                "                        \"familyName\": \"Black toner supply\",\n" +
                "                        \"pagesUsed\": 1,\n" +
                "                        \"productNumber\": \"CF231A\",\n" +
                "                        \"state\": \"ok\",\n" +
                "                        \"consumableType\": \"toner\",\n" +
                "                        \"estimatedPagesRemaining\": 20\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"color\": false,\n" +
                "                \"nickName\": \"Box Mock Printer1\",\n" +
                "                \"ipv4Address\": \"\",\n" +
                "                \"trays\": [\n" +
                "                    {\n" +
                "                        \"size\": \"any\",\n" +
                "                        \"duplex\": true,\n" +
                "                        \"trayIndex\": 1,\n" +
                "                        \"type\": \"auto\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"counter\": {\n" +
                "                    \"jamEvents\": 14,\n" +
                "                    \"totalImpressions\": 3772,\n" +
                "                    \"copyImpressions\": 482,\n" +
                "                    \"duplexSheets\": 693\n" +
                "                },\n" +
                "                \"productNumber\": \"G3Q76A\",\n" +
                "                \"uuid\": \"printer111111\",\n" +
                "                \"sid\": 1,\n" +
                "                \"upTime\": 1425591870,\n" +
                "                \"scanner\": {\n" +
                "                    \"jamEvents\": 0,\n" +
                "                    \"adfImages\": 0,\n" +
                "                    \"flatbedImages\": 0\n" +
                "                },\n" +
                "                \"isUsbConnected\": true,\n" +
                "                \"model\": \"HP LaserJet Ultra MFP M230sdn Mock1\",\n" +
                "                \"status\": \"ready\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"hwversion\": \"1.0.0\",\n" +
                "        \"latitude\": 0,\n" +
                "        \"ipv4Address\": \"192.168.202.129\",\n" +
                "        \"supportUrl\": \"\",\n" +
                "        \"model\": \"m0.1\",\n" +
                "        \"pid\": \"18783\",\n" +
                "        \"firmware\": \"0.1\",\n" +
                "        \"uuid\": \"board111111\",\n" +
                "        \"longitude\": 0\n" +
                "    },\n" +
                "    \"command\": \"board\"\n" +
                "}";

//        User user = JSON.parseObject(boardMsg, User.class);

        String message = LocalDateTime.now() + " --- this is a kafka source4  ";
        this.kafkaTemplate.send("topic6", JSON.parseObject(boardMsg));
    }

    @Scheduled(initialDelay = 10000, fixedDelay = 20000)
    public void send2() {
        String boardMsg = "{'randomId':'0bf60a7d-10a2-4a72-a6ed-12e3593e37d9','board':{'setupUrl':'','macAddress':'02:92:79:13:0a:7d','printers':[{'serialNumber':'VNC3D00704','cartridges':[{'serialNumber':'234951572','level':'7','familyName':'Black toner supply','pagesUsed':1,'productNumber':'CF231B','state':'ok','consumableType':'toner','estimatedPagesRemaining':20}],'color':false,'nickName':'Box Mock Printer1','ipv4Address':'','trays':[{'size':'any','duplex':true,'trayIndex':1,'type':'auto'}],'counter':{'jamEvents':14,'totalImpressions':3772,'copyImpressions':482,'duplexSheets':693},'productNumber':'G3Q76C','uuid':'printer222222','sid':1,'upTime':1425591870,'scanner':{'jamEvents':0,'adfImages':0,'flatbedImages':0},'isUsbConnected':true,'model':'HP LaserJet Ultra MFP M230sdn Mock1','status':'ready'}],'hwversion':'1.0.0','latitude':0.0,'ipv4Address':'192.168.202.129','supportUrl':'','model':'m0.1','pid':'18783','firmware':'0.1','uuid':'board222222','longitude':0.0},'command':'board','platformCode':'veryprint'}";
        System.out.println("------------------------- second");
        String message = "this is a kafka source4  ";
        this.kafkaTemplate.send("topic6", JSON.parseObject(boardMsg));
    }

    @Scheduled(initialDelay = 15000, fixedDelay = 20000)
    public void send3() {
        String boardMsg = "{'randomId':'0bf60a7d-10a2-4a72-a6ed-12e3593e37d9','board':{'setupUrl':'','macAddress':'02:92:79:13:0a:7d','printers':[{'serialNumber':'VNC3D00704','cartridges':[{'serialNumber':'234951573','level':'7','familyName':'Black toner supply','pagesUsed':1,'productNumber':'CF231C','state':'ok','consumableType':'toner','estimatedPagesRemaining':20}],'color':false,'nickName':'Box Mock Printer1','ipv4Address':'','trays':[{'size':'any','duplex':true,'trayIndex':1,'type':'auto'}],'counter':{'jamEvents':14,'totalImpressions':3772,'copyImpressions':482,'duplexSheets':693},'productNumber':'G3Q76B','uuid':'printer333333','sid':1,'upTime':1425591870,'scanner':{'jamEvents':0,'adfImages':0,'flatbedImages':0},'isUsbConnected':true,'model':'HP LaserJet Ultra MFP M230sdn Mock1','status':'ready'}],'hwversion':'1.0.0','latitude':0.0,'ipv4Address':'192.168.202.129','supportUrl':'','model':'m0.1','pid':'18783','firmware':'0.1','uuid':'board333333','longitude':0.0},'command':'board','platformCode':'veryprint'}";
        System.out.println("------------------------- third");
        String message = "this is a kafka source4  ";
        this.kafkaTemplate.send("topic6", JSON.parseObject(boardMsg));
    }

    @Scheduled(initialDelay = 20000, fixedDelay = 20000)
    public void send4() {
        String boardMsg = "{'randomId':'0bf60a7d-10a2-4a72-a6ed-12e3593e37d9','board':{'setupUrl':'','macAddress':'02:92:79:13:0a:7d','printers':[{'serialNumber':'VNC3D00704','cartridges':[{'serialNumber':'234951574','level':'90','familyName':'Black toner supply','pagesUsed':1,'productNumber':'CF231D','state':'ok','consumableType':'toner','estimatedPagesRemaining':20}],'color':false,'nickName':'Box Mock Printer1','ipv4Address':'','trays':[{'size':'any','duplex':true,'trayIndex':1,'type':'auto'}],'counter':{'jamEvents':14,'totalImpressions':3772,'copyImpressions':482,'duplexSheets':693},'productNumber':'G3Q76A','uuid':'printer444444','sid':1,'upTime':1425591870,'scanner':{'jamEvents':0,'adfImages':0,'flatbedImages':0},'isUsbConnected':true,'model':'HP LaserJet Ultra MFP M230sdn Mock1','status':'ready'}],'hwversion':'1.0.0','latitude':0.0,'ipv4Address':'192.168.202.129','supportUrl':'','model':'m0.1','pid':'18783','firmware':'0.1','uuid':'board444444','longitude':0.0},'command':'board','platformCode':'veryprint'}";
        System.out.println("------------------------- forth");
        String message = "this is a kafka source4  ";
        this.kafkaTemplate.send("topic6", JSON.parseObject(boardMsg));
    }

}
