package com.study.xyl._10_serializationExample;

import java.io.*;

class MyClass implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private int age;

    public MyClass(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class SerializationExample {
    public static byte[] serializeObjectToBytes(Object obj) throws IOException {
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                 ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)) {

            objectOutputStream.writeObject(obj);
            return byteArrayOutputStream.toByteArray();
        }
    }

    public static Object deserializeBytesToObject(byte[] serializedBytes) throws IOException, ClassNotFoundException {
        try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(serializedBytes);
             ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream)) {

            return objectInputStream.readObject();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // 创建一个示例对象
        MyClass originalObject = new MyClass("John Doe", 30);

        // 将对象序列化为字节数组
        byte[] serializedBytes = serializeObjectToBytes(originalObject);

        // 将字节数组反序列化为对象
        MyClass deserializedObject = (MyClass) deserializeBytesToObject(serializedBytes);

        // 打印原始对象和反序列化后的对象
        System.out.println("Original Object: " + originalObject);
        System.out.println("Deserialized Object: " + deserializedObject);
    }
}
