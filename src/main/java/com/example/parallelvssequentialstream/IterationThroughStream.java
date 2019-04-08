/**
 * 
 */
package com.example.parallelvssequentialstream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/*
 * Performance test over internal(parallel/sequential) and external iterations.
 * https://docs.oracle.com/javase/tutorial/collections/streams/parallelism.html
 * 
 * 
 * Parallel computing involves dividing a problem into subproblems, 
 * solving those problems simultaneously (in parallel, with each subproblem running in a separate thread),
 *  and then combining the results of the solutions to the subproblems. Java SE provides the fork/join framework, 
 *  which enables you to more easily implement parallel computing in your applications. However, with this framework, 
 *  you must specify how the problems are subdivided (partitioned). 
 *  With aggregate operations, the Java runtime performs this partitioning and combining of solutions for you.
 * 
 * Limit the parallelism that the ForkJoinPool offers you. You can do it yourself by supplying the -Djava.util.concurrent.ForkJoinPool.common.parallelism=1,
 *  so that the pool size is limited to one and no gain from parallelization
 *  
 *  @see ForkJoinPool
 *  https://docs.oracle.com/javase/tutorial/essential/concurrency/forkjoin.html
 *  
 *  ForkJoinPool, that pool creates a fixed number of threads (default: number of cores) and 
 *  will never create more threads (unless the application indicates a need for those by using managedBlock).
 *   *  http://stackoverflow.com/questions/10797568/what-determines-the-number-of-threads-a-java-forkjoinpool-creates
 *  
 */
public class IterationThroughStream {
    private static boolean found = false;
    private static List<Integer> smallListOfNumbers = null;
    
    public static void main(String[] args) throws InterruptedException {
        // TEST_1
    	testForBigNumberofSimpleTask();

        System.out.println();
        System.out.println("-----------------------");
        System.out.println();

        
        // TEST_2
        testForSmallNumberofComplexTask();

    }
    
    
    public static void testForSmallNumberofComplexTask() {
        final List<Integer> smallListOfNumbers = new ArrayList<Integer>();

    	System.out.println("Test Start for complex tasks and smallListOfNumbers");
        IntStream.range(1, 11).forEach(i->smallListOfNumbers.add(i));

        long startExternalIteration1 = System.currentTimeMillis();
        seqStreamOnSleep(smallListOfNumbers);
        long endExternalIteration1 = System.currentTimeMillis();
        System.out.println("Time taken by seqStreamOnSleep is :" + (endExternalIteration1 - startExternalIteration1));

        long startInternalIteration1 = System.currentTimeMillis();
        parallelStreamOnSleep(smallListOfNumbers);
        long endInternalIteration1 = System.currentTimeMillis();
        System.out.println("Time taken by parallelStreamOnSleep is :" + (endInternalIteration1 - startInternalIteration1));
    }
    
    
    public static void testForBigNumberofSimpleTask() {
    	System.out.println("Test Start for simple tasks and bigListOfStrings");

    	List<String> bigListOfStrings = new ArrayList<String>();
        LongStream.range(1l, 10000001l).forEach(i->bigListOfStrings.add("Counter no: "+ i));
        
        
        long startSeqStream = System.currentTimeMillis();
        found= bigListOfStrings.stream().anyMatch(s->s.equals("Counter no: 1000000"));
        long endSeqStream = System.currentTimeMillis();
        System.out.println("Time taken by seqStream is :" + 
        		(endSeqStream - startSeqStream) + " , and the result found: "+ found);

        
        long startParallelStream = System.currentTimeMillis();
        found= bigListOfStrings.parallelStream().anyMatch(s->s.equals("Counter no: 1000000"));
        long endParallelStream = System.currentTimeMillis();
        System.out.println("Time taken by parallel Stream is :" + 
        		(endParallelStream - startParallelStream) + " , and the result found: "+ found);
        
        
        System.out.println("Test end for simple tasks and bigListOfStrings");
    }
    
    

    private static boolean seqStreamOnSleep(List<Integer> smallListOfNumbers) {
        for(Integer s : smallListOfNumbers) {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    private static boolean parallelStreamOnSleep(List<Integer> smallListOfNumbers) {
        smallListOfNumbers.parallelStream().forEach( //Removing parallelStream() will behave as single threaded (sequential access).
                (Integer s) -> {
                    try {
                        Thread.sleep(100); //Have a breakpoint to look how many threads are spawned.
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            );
        return true;       
    }

}
