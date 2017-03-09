package com.bin.kafkaSend;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.message.MessageAndMetadata;
import kafka.serializer.StringDecoder;

public class CollectorTest {
    private String            topic   = "test";
    private static String     zkConnect;            // localhost:2181
    private static String     groupId = "group2";

    private ConsumerConnector consumer;

    public CollectorTest(String topic) {

//        zkConnect = host + ":2181";
        this.topic = topic;
    }

    private ConsumerConfig createConsumerConfig() {
        Properties props = new Properties();
        // props.put("zookeeper.connect", zkConnect);

        zkConnect = "zk:2181";

        props.put("zookeeper.connect", zkConnect); //add
        props.put("zookeeper.connectiontimeout.ms", 10000);

        props.put("group.id", groupId);
        props.put("auto.offset.reset", "smallest");

        return new ConsumerConfig(props);

    }


    public void recv() {
        consumer = kafka.consumer.Consumer.createJavaConsumerConnector(createConsumerConfig());

        Map<String, Integer> topicMap = new HashMap<String, Integer>();
        topicMap.put(topic, new Integer(1));
        Map<String, List<KafkaStream<String, String>>> streamMap = consumer.createMessageStreams(topicMap, new StringDecoder(null), new StringDecoder(null));

        KafkaStream<String, String> stream = streamMap.get(topic).get(0);

        ConsumerIterator<String, String> it = stream.iterator();
        while (it.hasNext()) {
            MessageAndMetadata<String, String> mm = it.next();
            System.out.println("<<< Got new message");
            System.out.println("<<< key:" + mm.key());
            System.out.println("<<< m: " + mm.message());

        }
    }

    public static void main(String[] argv) {

        CollectorTest collector = new CollectorTest("test");
        collector.recv();

    }

}
