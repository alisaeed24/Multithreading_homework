package org.example;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumbersService implements Runnable{
    private int Start;
    private int End;
    private List<Integer> PrimeNumbers;

    public PrimeNumbersService(int start, int end) {
        this.Start = start;
        this.End = end;
        this.PrimeNumbers = new ArrayList<>();
    }
    public  PrimeNumbersService(){
        Start = 0;
        End = 0;
        this.PrimeNumbers = new ArrayList<>();
    }
    public List<Integer> findPrimeNumbers(){
        for (int i = this.Start ; i<this.End ; i++ ){
            if(isPrimeNumber(i)){
                this.PrimeNumbers.add(i);
            }
        }
        return this.PrimeNumbers;
    }
    public List<Integer> getPrimeNumbers() {
        return PrimeNumbers;
    }
    public boolean isPrimeNumber(int number){
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
    @Override
    public void run() {
        findPrimeNumbers();
    }
}
