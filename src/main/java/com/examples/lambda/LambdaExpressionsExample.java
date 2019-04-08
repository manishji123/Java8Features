package com.examples.lambda;

import java.util.Arrays;
import java.util.function.Predicate;

public class LambdaExpressionsExample {

    public static void main(String... args) {
        withCustomInterface();
        withRunnable();
    }

    private static void withCustomInterface() {
        int[] nums = {-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5};
        
        Predicate<Integer> predicate= i->i>0;
        
        //lambda
        System.out.println(Arrays.stream(nums).filter(i-> predicate.test(i)).sum());

        //method reference
        System.out.println(Arrays.stream(nums).filter(predicate::test).sum());

    }


    

    private static void withRunnable() {
        // Old Runnable
        final Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable one");
            }
        };
        // Lambda Runnable
        final Runnable runnable2 = () -> System.out.println("Runnable two");

        runnable1.run();
        runnable2.run();
    }
    
    
}
