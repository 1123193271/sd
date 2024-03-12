package com.study.xyl._18_GenericType;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Example {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        List<String> listString = new ArrayList<>();
        List<Integer> listInteger = new ArrayList<>();
        list.add(1);
        try {
            list.getClass().getMethod("add", Object.class).invoke(list, 'c');
            listString.getClass().getMethod("add", Object.class).invoke(listString, "c");
            listInteger.getClass().getMethod("add", Object.class).invoke(listInteger, "c");

        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        System.out.println("list size: " + list.size());
        System.out.println(list);
        System.out.println(list.get(1));
        Object i = list.get(1);
        Integer io = null;
        if (i instanceof Character) {
            io = (int) (Character) i;
            Character u = (Character) i;
            io = (int) (char) i;
        }
        byte b = io.byteValue();
        System.out.println(b);

        System.out.println(io);
        System.out.println("listString size: " + listString.size());
        System.out.println("listInteger size: " + listInteger.size());

    }
}
