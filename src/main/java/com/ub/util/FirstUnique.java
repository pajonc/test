package com.ub.util;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Created on 10/31/2017.
 */
public class FirstUnique {


    public String first(List<String> input) {
        String result = null;
        Map<String, Integer> items = new LinkedHashMap<>();
        for (String inp : input) {
            if (items.get(inp) != null) {
                int value = items.get(inp) + 1;
                items.put(inp, value);
            } else {
                items.put(inp, 1);
            }
        }

        items.entrySet().stream().filter(new Predicate<Map.Entry<String, Integer>>() {
            @Override
            public boolean test(Map.Entry<String, Integer> stringIntegerEntry) {
                return stringIntegerEntry.getValue() > 1;
            }
        });

        Optional<Map.Entry<String, Integer>> first = items.entrySet().stream().filter(entry -> entry.getValue() > 1).findFirst();
        result = (String) first.get().getKey();

        return result;
    }

}
