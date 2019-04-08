package com.examples.foreach;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ForEachExample {

    public static void main(final String... args) {
        List<Integer> integerList = new ArrayList<>();

       /* for (int index = 0; index < 10; index++) {
            integerList.add(index);
        }*/
        IntStream.range(0, 10).forEach(i -> integerList.add(i));
        integerList.forEach(System.out::println);
    }
}
