package com.study.xyl._18_GenericType;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ListSerializationExample {
    public static void main(String[] args) {
        // 创建一个ArrayList并添加一些字符串
        List<String> stringList = new ArrayList<>();
        stringList.add("String 1");
        stringList.add("String 2");

        // 序列化
        serializeList(stringList, "list.ser");

        // 反序列化
        List<String> deserializedList = deserializeList("list.ser");

        // 打印反序列化后的字符串列表内容
        for (String str : deserializedList) {
            System.out.println(str);
        }
    }

    // 序列化List<String>对象到文件
    private static void serializeList(List<String> list, String fileName) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(list);
            System.out.println("Serialization successful.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 从文件中反序列化List<String>对象
    private static List<String> deserializeList(String fileName) {
        List<String> deserializedList = new ArrayList<>();

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            deserializedList = (List<String>) in.readObject();
            System.out.println("Deserialization successful.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return deserializedList;
    }
}
