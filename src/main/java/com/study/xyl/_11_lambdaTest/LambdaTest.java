package com.study.xyl._11_lambdaTest;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaTest {
    public void apply(Double num, Consumer<Double> consumer) {
        consumer.accept(num);
    }

    public static <T> T getObject(Supplier<T> s) {
        return s.get();
    }

    public String handler(String str, Function<String, String> fun) {
        return fun.apply(str);
    }

    public List<String> filter(List<String> ss, Predicate<String> p) {
        List<String> newSs = new ArrayList<>();
        for (String s : ss) {
            if (p.test(s)) {
                newSs.add(s);
            }
        }
        return newSs;
    }

    public static void main(String[] args) {
        LambdaTest object = getObject(LambdaTest::new);
        object.apply(1000.0, System.out::println);
        String newStr = object.handler("abc", (str) -> {
            return str.toUpperCase(Locale.ROOT);
        });
        AuthOrgEnum.valueOf("name");
        AuthOrgEnum[] values = AuthOrgEnum.values();

        System.out.println(newStr);
        List<String> list = Arrays.asList("ss", "s", "ads", "dsad", "dsa");
        List<String> filter = object.filter(list, (ss) -> ss.length() > 1);
        System.out.println(filter);
    }

    @Getter
    enum AuthOrgEnum {
        Z0001("100", "jeh"),
        Z0002("100001", "eeee");

        private final String code;
        private final String name;

        AuthOrgEnum(String code, String name) {
            this.code = code;
            this.name = name;
        }

    }
}

