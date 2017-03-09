package com.bin.kafkaSend;


import java.util.Properties;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

public class SenderTest {
    private Producer<String, String> producer;
    private String                   topic;
    private Properties               props = new Properties();
    private static String            zkConnect;

    public SenderTest(String topic) {

        topic = "test";
        zkConnect = "zk:2181";

        props.put("metadata.broker.list", "kafka:9092");// localhost:9092
        props.put("zk.connect", zkConnect);// host:2181

        props.put("serializer.class", "kafka.serializer.StringEncoder");
        // props.put("key.serializer.class", "kafka.serializer.StringEncoder");
        // props.put("compression.codec", "snappy");

        producer = new Producer<String, String>(new ProducerConfig(props));

        this.topic = topic;
    }

    public void send() {

        String key = "S" + String.valueOf(System.currentTimeMillis());

        String messageStr = "abc";

        producer.send(new KeyedMessage<String, String>(topic, key, messageStr));
        System.out.println(">>> sent ok");
    }

    public static void main(String[] argv) {
        final SenderTest main = new SenderTest("test");

        while (true) {
            try {
                Thread.sleep(1000 * 30);
                main.send();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
