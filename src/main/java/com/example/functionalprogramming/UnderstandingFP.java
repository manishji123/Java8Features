package com.example.functionalprogramming;

import java.util.function.BiFunction;

public class UnderstandingFP {

	public static void main(String[] args) {

		oldWayOfDoing();
		
		//FP with old java
		functionalApproach(new Operation() {
			@Override
			public int apply(int t, int u) {
				// TODO Auto-generated method stub
				return t+u;
			}
		});
		
		//FP with lambda expression
		functionalApproach((i, j) -> (i+j));
		
		//FP with lambda expression and java function interface
		functionalApproachWithJavaInteface((i, j) -> (i+j));
		
		//defining lambda expression as variables
		BiFunction<Integer, Integer, Integer> function= (i, j) -> (i+j);
		System.out.println(function.apply(5, 6));
		
		
	}
	
	private static void functionalApproachWithJavaInteface(BiFunction<Integer, Integer, Integer> function) {
		System.out.println(function.apply(2, 3));
	}

	
	
	private static void functionalApproach(Operation operation) {
		System.out.println(operation.apply(2, 3));
	}
	
	public static interface Operation{
		public int apply(int int1, int int2);
	}
	
	
	private static void oldWayOfDoing() {
		int i=2, j=3;
		System.out.println(sum(i, j));
	}
	
	public static int sum(int int1, int int2) {
		return int1+int2;
	}

}
