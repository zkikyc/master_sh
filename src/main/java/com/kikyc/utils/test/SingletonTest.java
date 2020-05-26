package com.kikyc.utils.test;

public class SingletonTest {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getSingleton();
        System.out.println(singleton.i);
        System.out.println(singleton.k);
    }
}

class Singleton{
    public static int i;

    private static Singleton singleton = new Singleton();

    public static int k = 0;
    private Singleton() {
        i++;
        k++;
    }

    public static Singleton getSingleton() {
        return singleton;
    }
}
