package com.examples.interfaces.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class SupplierTest {
	 
    public static void main(String[] args) {
 
        System.out.println("E.g. #2 - Java8 Supplier Example\n");
 
        List<String> names = new ArrayList<String>();
        names.add("Harry");
        names.add("Daniel");
        names.add("Lucifer");       
        names.add("April O' Neil");
 
        names.stream().forEach((item)-> {
            printNames(()-> item);
        });
    }
 
    private static void printNames(Supplier<String> supplier) {
        System.out.println(supplier.get());
    }
}