package com.test;

/**
 * Created by sg0892437 on 10/5/2017.
 */
public class InAImpl implements InA, InAP {

    private String name = "nameDefault";
    private final String nameTest;
    public String surname = "surnameDefault";
    protected String question = "questionDefault";

    public InAImpl(String nameTest) {
        this.nameTest = nameTest;
    }

    @Override
    public void test() {
        System.out.println("WOW");

    }

    public void test2(String test) {
        System.out.println(test);

    }


    @Override
    public void a() {
        InA.super.a();
        InAP.super.a();
    }

}
