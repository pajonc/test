package com.test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by Pawel Chrzanowski (SG0892437) on 9/8/2017.
 */
public class Test {


    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("obj1","val1");
        map.put("obj4","val4");
        map.put("obj2","val2");
        map.put("obj3","val3");

//        System.out.println(map.get("obj3"));

        int size = 1000;
        System.out.println("S: "+ (size>>1) );
        size = 20;
        System.out.println("S: "+ (size>>1) );

        List<String> ls = new LinkedList<String>();
        ls.add("a");
        ls.add("b");
        ls.add("c");
        ls.add("d");
        ls.add("e");

        System.out.println(ls.get(3));

        System.out.println(Integer.toBinaryString(121));
        System.out.println(Integer.toBinaryString(121 >> 1));
        System.out.println(Integer.toBinaryString(121 >>> 1));

        System.out.println("-----------------------------");
        System.out.println(Integer.toBinaryString(-121));
        System.out.println(Integer.toBinaryString(-121 >> 1));
        System.out.println(Integer.toBinaryString(-121 >>> 1));

        TreeSet<String> ts = new TreeSet<>();
        ts.add("c");
        ts.add("d");
        ts.add("a");
        ts.add("b");
        ts.add("f");
        ts.add("e");


    }
}
