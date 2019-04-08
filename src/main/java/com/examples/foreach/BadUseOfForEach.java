/**
 * 
 */
package com.examples.foreach;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

/**
 * @author manish goel
 *
 */
public class BadUseOfForEach {
	
	public static void main(String[] args) {
    	List<String> bigListOfStrings = new ArrayList<String>();
        LongStream.range(1l, 10000001l).forEach(i->bigListOfStrings.add("Counter no: "+ i));

        System.out.println(internalIteration_old(bigListOfStrings));
        System.out.println(internalIteration(bigListOfStrings));

        
        
	}
	
	static boolean found = false;
    private static boolean internalIteration_old(List<String> bigListOfStrings) {
        bigListOfStrings.parallelStream().forEach(
                (String s) -> { 
                    if(s.equals("Counter no: 1000000")){  //Have a breakpoint to look how many threads are spawned.
                        found = true;
                    }

                }
            );
        return found;       
    }
    
    
    private static boolean internalIteration(List<String> bigListOfStrings) {
        return bigListOfStrings.parallelStream().anyMatch(s->s.equals("Counter no: 1000000"));
    }

}
