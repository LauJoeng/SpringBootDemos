package com.yang.bean;

import java.io.Serializable;

public class Book implements Serializable {
    private String name;
    private String auther;

    public Book(String name, String auther) {
        this.name = name;
        this.auther = auther;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", auther='" + auther + '\'' +
                '}';
    }
}
