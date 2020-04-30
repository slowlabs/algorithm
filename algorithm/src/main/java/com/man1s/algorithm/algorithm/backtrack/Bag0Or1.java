package com.man1s.algorithm.algorithm.backtrack;

public class Bag0Or1 {

    public static void main(String[] args) {
        new Bag0Or1().fillBag(0,0,300);
        System.out.println(maxValue);
    }

    int [] bag  = {10,50,40,20,5,88,90,10,90,10};
    static int  maxValue = Integer.MIN_VALUE;

    private void fillBag(int no,int currentWeight,int bagCaptital){
        if(no == bag.length-1 ||currentWeight > bagCaptital){
            if(currentWeight>maxValue){
                maxValue = currentWeight;
            }
            return;
        }
        fillBag(no+1,currentWeight,bagCaptital);
        if(bagCaptital > currentWeight+bag[no+1]){
            fillBag(no+1,currentWeight+bag[no+1],bagCaptital);
        }




    }



}
