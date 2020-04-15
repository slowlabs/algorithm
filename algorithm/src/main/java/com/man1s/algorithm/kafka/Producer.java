package com.man1s.algorithm.kafka;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.KafkaAdminClient;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Producer {
    public static final String brokerList = "172.23.4.203:9092";
    static  Properties properties = new Properties();
    static {
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
              StringSerializer.class.getName());
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, brokerList);
        properties.put(ProducerConfig.COMPRESSION_TYPE_CONFIG,"gzip");
    }


    private static  String  VALUE;
    static {
        int i  = 0;
        StringBuilder sb = new StringBuilder();
        while (i<Short.MAX_VALUE*2){
            sb.append(i++);
        }
        VALUE = sb.toString();
    }


    public static void main(String[] args) {
            product("test");
    }

    public static void product(String topicName){
        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);
        try {
            for (int i = 0; i <5000000 ; i++) {
                ProducerRecord<String, String> record =
                        new ProducerRecord<>(topicName, VALUE+i);
                producer.send(record);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            producer.close();
        }
    }
}
