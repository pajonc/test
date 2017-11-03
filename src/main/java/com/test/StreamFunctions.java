package com.test;

import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by SG0892437 on 10/2/2017.
 */
public class StreamFunctions {


    static Stream<String> getNames(Predicate<String> predicate, Collection<String> names) {
        return names.stream().filter(predicate);
    }


}
