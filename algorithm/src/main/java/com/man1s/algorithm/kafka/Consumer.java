package com.man1s.algorithm.kafka;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Consumer {
    public static final String brokerList = "172.23.4.203:9092";
    static Properties properties = new Properties();
    static {
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class.getName());
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, brokerList);
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);


    }



    public static void main(String[] args) {
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "test");
        KafkaConsumer<String, String> consumer =
                new KafkaConsumer<>(properties);
        consumer.subscribe(Collections.singleton("test"));
        consumer(consumer);
    }

    private static void  consumer( KafkaConsumer<String, String> consumer){
        try {
            while (true) {
                ConsumerRecords<String, String> poll = consumer.poll(Duration.ofSeconds(1L));
                for (ConsumerRecord<String, String> stringStringConsumerRecord : poll) {
                    System.err.println(stringStringConsumerRecord.value()+"=============================================");
                    System.err.println(stringStringConsumerRecord.value()+"=============================================");
                    System.err.println(stringStringConsumerRecord.value()+"=============================================");
                    System.err.println(stringStringConsumerRecord.value()+"=============================================");
                    System.err.println(stringStringConsumerRecord.value()+"=============================================");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
