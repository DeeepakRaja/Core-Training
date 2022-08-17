package com.operative.springbootdemo.entity;

public class Product {
    private int code;
    private String name;
    private String desc;
    private String manu;
    private double price;

    public Product(int code, String name, String desc, String manu, double price) {
        this.code = code;
        this.name = name;
        this.desc = desc;
        this.manu = manu;
        this.price = price;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getManu() {
        return manu;
    }

    public void setManu(String manu) {
        this.manu = manu;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
