package com.sh.springbootdemo.bean;

import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class Import {
    private String one;
    private HashMap<String,String> h;

    @Override
    public String toString() {
        return "Import{" +
                "one='" + one + '\'' +
                '}';
    }

    public Import() {
    }

    public void setOne(String one) {
        this.one = one;
    }

    public String getOne() {
        return one;
    }

    public Import(String one) {
        this.one = one;
    }
}
