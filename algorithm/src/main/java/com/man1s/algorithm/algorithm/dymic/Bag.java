package com.man1s.algorithm.algorithm.dymic;

public class Bag {

    private int maxW = Integer.MIN_VALUE;
    private int[] weight = {2,2,4,6,3};
    private int n = 5;
    private int w = 9;

    public void f(int i, int cw) {
        if (cw == w || i == n) {
            if (cw > maxW){
                maxW = cw;
            }
         return;
        }
        f(i+1, cw);
        if (cw + weight[i] <= w) {
            f(i+1,cw + weight[i]);
        }
    }

    public static void main(String[] args) {
        int[] weight = {2,2,4,6,3,3};
        int n = 6;
        int w = 20;
        System.out.println(knapsack(weight,n,w+1));
        System.out.println(knapsack(weight,w+1));
    }


    public static int knapsack(int[] weight, int n, int w){
        boolean ex [][] = new boolean[n][w];
        int max = 0;
        for (int i = 0; i < n; i++) {
            int value = weight[i];
            ex[i][value]=true;
            if(value>max){
                max= value;
            }
            for (int j = 0; j < w; j++) {
                int pre = i-1;
                boolean b = false;
                if(pre>=0){
                    b = ex[pre][j];
                    if(b&&j>max){
                        max= j;
                    }
                }
                if(b){
                    ex[i][j] = b;
                    if(value+j<w){
                        ex[i][value+j] = b;
                        if(value+j>max){
                            max= value+j;
                        }
                    }
                }
            }
        }
        return max;
    }


    public static int knapsack(int[] weight, int w){
        int size = weight.length;
        boolean [] ex = new boolean[w];
        int max = 0;
        for (int i = 0; i < size; i++) {
            int value = weight[i];
            if(value>w){
                continue;
            }
            for (int j = w-1; j >-1; j--) {
                boolean b = ex[j];
                if(b){
                   int temp = value+j;
                   if(temp<w){
                        ex[temp] = true;
                        if(temp>max){
                           max=temp;
                        }
                   }


                }
            }
            if(value<w){
                ex[value] = true;
                if(value>max){
                    max=value;
                }
            }
        }

        return max;

    }



}
