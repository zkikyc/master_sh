package com.sh.springbootdemo.bean;

public class Goods {
    private String id;
    private String name;
    private String price;
    private String type_id;
    private int repertory;

    public Goods() {
    }

    public Goods(String id, String name, String price, String type_id, int repertory) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type_id = type_id;
        this.repertory = repertory;
    }

    public int getRepertory() {
        return repertory;
    }

    public void setRepertory(int repertory) {
        this.repertory = repertory;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getType_id() {
        return type_id;
    }

    public void setType_id(String type_id) {
        this.type_id = type_id;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", type_id='" + type_id + '\'' +
                ", repertory=" + repertory +
                '}';
    }
}
