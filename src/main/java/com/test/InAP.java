package com.test;

/**
 * Created by sg0892437 on 10/5/2017.
 */
public interface InAP {

    default void a() {
        System.out.println("InA");
    }

    void test();

}


