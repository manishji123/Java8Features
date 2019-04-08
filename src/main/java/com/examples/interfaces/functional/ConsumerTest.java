package com.examples.interfaces.functional;

import java.util.function.Consumer;

public class ConsumerTest {
	 
    public static void main(String[] args) {
 
        System.out.println("E.g. #1 - Java8 Consumer Example\n");
 
        Consumer<String> consumer = ConsumerTest::printNames;
        consumer.accept("C++");
        consumer.accept("Java");
        consumer.accept("Python");
        consumer.accept("Ruby On Rails");
    }
 
    private static void printNames(String name) {       
        System.out.println(name);
    }
}
