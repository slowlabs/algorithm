package com.man1s.algorithm.algorithm.sort;

public class SortOn {

    public static int [] coutingSort(int [] arr){
        int max =0;
        for (int i : arr) {
            if(i>max){
                max = i;
            }
        }
        int [] count  = new int [max+1];
        for (int i : arr) {
            int size = count[i];
            count[i] = size+1;
        }
        int pre = arr[0];
        for (int i = 1; i < count.length; i++) {
            int value  = count[i];
            count[i] = value+pre;
            pre = count[i];
        }
        int [] res  = new int[arr.length];
        for (int i : arr) {
            int positon = count[i];
            res[positon-1] = i;
            count[i] = positon-1;
        }
        return  res;

    }

    public static void main(String[] args) {
        int [] arr  =  {2,1,4,8,5,4,3};
        arr  = coutingSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }



}
