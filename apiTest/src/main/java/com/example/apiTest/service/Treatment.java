package com.example.apiTest.service;

import com.example.apiTest.description.Family;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class Treatment {
    public String result(String cn) throws IOException {
//        System.out.println(cn);
        StringReader reader = new StringReader(cn);
        ObjectMapper mapperIn = new ObjectMapper();

        Family family = mapperIn.readValue(reader, Family.class);

//        System.out.println(family.getName());
//        System.out.println(family.getAge());

        StringWriter writer = new StringWriter();

        //это объект Jackson, который выполняет сериализацию
        ObjectMapper mapperOut = new ObjectMapper();

        // сама сериализация: 1-куда, 2-что
        family.setAge((byte) (family.getAge()+1));

//        List<String> children = family.getChildren();
//        children.set(3,"sdc");
//        family.getChildren(family.setChildren(children));
        mapperOut.writeValue(writer, family);

//        System.out.println(family.getName());
//        System.out.println(family.getAge());
//        KafkaProducerService kafkaProducerService = new KafkaProducerService();
//        kafkaProducerService.sendOrder("1",family.toString());

        return family.toString();
    }
}
