package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("the first case: normal case with 4 threads");
        FindPrimeNumbersWithMultiThreading(1,100000000,4);

        System.out.println("the second case: increase the number of threads to 5 without change the search range ");
        FindPrimeNumbersWithMultiThreading(1,100000000,5);
        System.out.println("the second case: increase the number of threads to 10 without change the search range ");

        FindPrimeNumbersWithMultiThreading(1,100000000,10);
        System.out.println("the second case: increase the number of threads to 20 without change the search range ");

        FindPrimeNumbersWithMultiThreading(1,100000000,20);

//        System.out.println("the third case: change search range to 50000000 without increase the number of threads");
//        FindPrimeNumbersWithMultiThreading(0,50000000,4);
//        System.out.println("the third case: change search range to 20000000 without increase the number of threads");
//        FindPrimeNumbersWithMultiThreading(0,20000000,4);
//        System.out.println("the third case: change search range to 10000000 without increase the number of threads");
//        FindPrimeNumbersWithMultiThreading(0,10000000,4);
    }
    static public void FindPrimeNumbersWithMultiThreading(int a, int b , int threadNumbers){
        List<Thread> threads = new ArrayList<>();
        int subRange = ((b -a)+1)/threadNumbers;
        ArrayList<PrimeNumbersService> servers = new ArrayList<>();

        for (int i=0 ; i < threadNumbers; i++){
            int start = i*subRange + 1;
            int end = subRange*(i+1);
            PrimeNumbersService x = new PrimeNumbersService(start , end);
            Thread thread = new Thread(x);
            threads.add(thread);
            servers.add(x);
            thread.start();
        }

        long startTime = System.currentTimeMillis();
        for(int i = 0; i<threadNumbers; i++){
            try {
                threads.get(i).join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        List<Integer> allPrimeNumbers = new ArrayList<>();
        for ( PrimeNumbersService service : servers){
            allPrimeNumbers.addAll(service.getPrimeNumbers());
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Total prime numbers found: " + allPrimeNumbers.size());
        System.out.println("Execution time: " + (endTime - startTime) + " milliseconds");
    }
}