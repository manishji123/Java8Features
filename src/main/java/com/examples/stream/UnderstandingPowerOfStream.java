package com.examples.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class UnderstandingPowerOfStream {

	public static void main(String[] args) {
		List<Integer> integers= new ArrayList<Integer>();
		IntStream.range(1, 100).forEach(i->integers.add(i));
		
		System.out.println("oldWayOfDoing : " +  oldWayOfDoing(integers));
		
		System.out.println("newWayOfDoingWithOutStream : " +  newWayOfDoingWithOutStream(integers));

		System.out.println("newWayOfDoingWithStream : " +  newWayOfDoingWithStream(integers));

		
	}
	
	private static int oldWayOfDoing(List<Integer> integers) {
		int sumOfGt50Lt73= 0;
		for(int i : integers){
			if(i>50 && i<73) {
				sumOfGt50Lt73 +=i;
			}
		}
		
		return sumOfGt50Lt73;
	}
	
	static Integer sumOfGt50Lt73= 0;
	private static int newWayOfDoingWithOutStream(List<Integer> integers) {
		integers.forEach(i-> {
			if(i>50 && i<73) {
				sumOfGt50Lt73 +=i;
			}
		});
		
		return sumOfGt50Lt73;
	}
	
	
	private static int newWayOfDoingWithStream(List<Integer> integers) {
		return integers.stream().filter(i -> (i>50 && i<73)).mapToInt(i->i).sum();
	}
	
	

	
	
	

}
