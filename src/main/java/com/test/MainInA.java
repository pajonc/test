package com.test;

import org.omg.PortableInterceptor.INACTIVE;

import java.lang.reflect.*;

/**
 * Created by sg0892437 on 10/5/2017.
 */
public class MainInA {

    public static void main(String[] args) {
        InAP inA = new InAImpl("Alicja");
        inA.test();

        Field[] fields = InAImpl.class.getFields();
        for(Field field : fields) {
            System.out.println("field: " + field.getName());
        }

        try {
            Field name = InAImpl.class.getDeclaredField("name");
            Field nameTest = InAImpl.class.getDeclaredField("nameTest");
            name.setAccessible(true);
            nameTest.setAccessible(true);
            try {
                System.out.println(name.get(inA));
                name.set(inA, "new Value");
                System.out.println(name.get(inA));
                System.out.println();
                System.out.println(nameTest.get(inA));
                nameTest.set(inA, "new Alicja");
                System.out.println(nameTest.get(inA));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        Method[] methods = InAImpl.class.getMethods();
        try {
            Method test = InAImpl.class.getMethod("test", null);
            try {
                test.invoke(inA,null);
                for (Method method : methods) {
                    Parameter[] parameters = method.getParameters();
                    if(parameters.length>0) {
                        Type parameterizedType = parameters[0].getParameterizedType();
                        System.out.println(method.getName() + " -> p type: "+(parameterizedType.getTypeName()));
                        if(parameterizedType.getTypeName().equals("java.lang.String")) {
                            System.out.println("TRUE");
                            method.invoke(inA,"zakrecony test");
                        }

                    }

                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
}
