package com.man1s.algorithm.kafka;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Collection;
import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Consumer {
    public static final String brokerList = "172.23.4.203:9092";
    static Properties properties = new Properties();
    static {
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                new StringDeserializer().getClass().getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                new StringDeserializer().getClass().getName());
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, brokerList);

    }



    public static void main(String[] args) {
        final  ThreadInt value = new ThreadInt();
        ThreadFactory factory  = new ThreadFactoryBuilder().build();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10, 1000, TimeUnit.DAYS,
                new LinkedBlockingDeque<>(), factory);
        for (int i = 0; i < 10; i++) {
            value.setValue(i);
            threadPoolExecutor.execute(()->
                    consumer("topic-demo",value)
            );
        }
    }

    private static void  consumer(String topicName,ThreadInt value){
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "租1"+value.getValue());
        KafkaConsumer<String, String> consumer =
                new KafkaConsumer<>(properties);
        consumer.subscribe(Collections.singleton("topic-demo"));
        try {
            while (true){
                System.err.println(Thread.currentThread().getName());
                ConsumerRecords<String, String> poll = consumer.poll(Duration.ZERO);
                for (ConsumerRecord<String, String> stringStringConsumerRecord : poll) {
                    System.out.println("key:"+stringStringConsumerRecord.key());
                    System.out.println("value:"+stringStringConsumerRecord.value());
                    System.out.println("patition:"+stringStringConsumerRecord.partition());
                    System.out.println("offset:"+stringStringConsumerRecord.offset());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static class ThreadInt{
        int value = 0;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
