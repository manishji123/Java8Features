package com.examples.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UnderstandingPowerOfStream1 {

	public static void main(String[] args) {
		List<Integer> integers= new ArrayList<Integer>();
		IntStream.range(1, 100).forEach(i->integers.add(i));
		
		System.out.println("oldWayOfDoing : " +  oldWayOfDoing(integers));
		
		System.out.println("newWayOfDoingWithOutStream : " +  newWayOfDoingWithOutStream(integers));

		System.out.println("newWayOfDoingWithStream : " +  newWayOfDoingWithStream(integers));
		
	}
	
	private static List<Integer> oldWayOfDoing(List<Integer> integers) {
		List<Integer> newIntegers= new ArrayList<Integer>();
		for(int i : integers){
			if(i>50 && i<73) {
				newIntegers.add(i);
			}
		}
		return newIntegers;
	}
	
	private static List<Integer> newWayOfDoingWithOutStream(List<Integer> integers) {
		List<Integer> newIntegers= new ArrayList<Integer>();
		integers.forEach(i-> {
			if(i>50 && i<73) {
				newIntegers.add(i);
			}
		});
		
		return newIntegers;
	}
	
	
	private static List<Integer> newWayOfDoingWithStream(List<Integer> integers) {
		return integers.stream().filter(i -> (i>50 && i<73)).collect(Collectors.toList());
	}
	
	

	
	
	

}
