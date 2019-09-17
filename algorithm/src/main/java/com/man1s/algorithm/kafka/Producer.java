package com.man1s.algorithm.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class Producer {
    public static final String brokerList = "172.23.4.203:9092";
    public static  Integer value = 0;
    static  Properties properties = new Properties();
    static {
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                new StringSerializer().getClass().getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
              new StringSerializer().getClass().getName());
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, brokerList);
    }




    public static void main(String[] args) {


        for (int i = 0; i <100 ; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    product("topic-demo");
                }
            }).start();


        }
    }

    public static void product(String topicName){
        KafkaProducer<String, String> producer =
                new KafkaProducer<>(properties);
        ProducerRecord<String, String> record =
                new ProducerRecord<>(topicName, Thread.currentThread().getName()+"   hello"+value++);
        try {
            while (true){
                producer.send(record).get();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
