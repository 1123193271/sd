package com.study.xyl._19_ConsumerAndProducer;

import lombok.Data;

@Data
public class Product {
    private int pid;
    private String name;

    public Product(int pid, String name) {
        this.pid = pid;
        this.name = name;
    }
}
