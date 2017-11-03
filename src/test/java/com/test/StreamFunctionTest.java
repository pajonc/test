package com.test;

import org.junit.Test;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by SG0892437 on 10/2/2017.
 */
public class StreamFunctionTest {

    private List<String> names = new ArrayList<String>();

    {
        names.add("Stefan");
        names.add("Romuald");
        names.add("Stach");
        names.add("Renata");
        names.add("Krystyna");
        names.add("Adam");
    }

    private List<String> values = new ArrayList<String>();

    {
        values.add("7");
        values.add("11");
        values.add("22");
        values.add("12");
        values.add("13");
        values.add("5");
    }


    @Test
    public void testStreams() {
        System.out.format("All the names: %n");
        names.forEach(System.out::println);
        System.out.println("--------------------------------------");

        System.out.format("All the names sorted: %n");
        names.stream().sorted().forEach(System.out::println);
        System.out.println("--------------------------------------");

        Stream<String> selectedNames = StreamFunctions.getNames(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.startsWith("R");
            }
        }, this.names);

        System.out.format("Hits on starts with %s:%n","R");
        selectedNames.forEach(s -> System.out.println(s));
        System.out.println("--------------------------------------");

        Stream<String> selectedNames2 = this.names.stream().filter((p->p.endsWith("a"))).map(String::toUpperCase);

        System.out.format("Hits on ends with %s upper case:%n","a");
        selectedNames2.forEach(s -> System.out.println(s));

        System.out.println("--------------------------------------");

        Optional<String> selectedNames3 = this.names.stream().reduce((k1, k2)-> k1.concat(":").concat(k2));
        System.out.println(selectedNames3.get());

        Optional<String> selectedNames4 = this.names.stream().reduce(new BinaryOperator<String>() {
            @Override
            public String apply(String s, String s2) {
                return s+"-"+s2;
            }
        });

        System.out.println(selectedNames4.get());

        System.out.println("");

        Averager averageCollect = values.stream()
                .map(x -> Integer.valueOf(x))
                .collect(Averager::new, Averager::accept, Averager::combine);

        System.out.println("Average age of male members: " +
                averageCollect.average());

        System.out.println("");

        List<Integer> list = Arrays.asList(23, 43, 12, 25);
        IntSummaryStatistics stats = list.stream()
                .collect(Collectors.summarizingInt(i -> i + i));
        System.out.println("Sum:"+stats.getSum());



    }

    <T, A, B> ArrayList<T> makeArray(T t, A a, B b) {
        return new ArrayList<T>();
    }


}
