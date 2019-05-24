package com.man1s.algorithm.algorithm.sort;

public class SortO2 {

    public static  void bubbleSort(int [] arr){
        for (int j = 0; j < arr.length; j++) {
            for (int i = 0; i < arr.length-j-1; i++) {
                if(arr[i]>arr[i+1]){
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
        }

    }

    public  static  void bubbleEnhanceSort(int [] arr){
        for (int i = 0; i < arr.length; i++) {
            boolean finish   = true;
            for (int j = 0; j < arr.length-i-1; j++) {
                if(arr[j]>arr[j+1]){
                    arr[j] = arr[j+1]+arr[j];
                    arr[j+1] = arr[j]-arr[j+1];
                    arr[j] = arr[j]-arr[j+1];
                    finish = false;
                }
            }
            if(finish){
                break;
            }
        }
    }


    public  static  void selectionSort(int [] arr){
        for (int j = 0; j < arr.length; j++) {
            int index  =j ;
            for (int i = j+1; i < arr.length; i++) {
                if(arr[index]>arr[i]){
                   index = i;
                }
            }
            int temp = arr[index];
            arr[index] = arr[j];
            arr[j] = temp;

        }

    }



    public  static  void insertSort(int [] arr){
        for (int i = 1; i < arr.length; i++) {
            int item = arr[i];
            for (int j = 0; j < i; j++) {
                if(item<arr[j]){
                    int temp  = arr[j];
                    arr[j] = item ;
                    arr[i] = temp;
                    item  = temp;
                }
            }
        }
    }

    public static void insertionSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i - 1;
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = value;
        }
    }





    public static void main(String[] args) {
        int [] arr  =  {2,1,4,8,5,4,3};
//        bubbleSort(arr);
//        insertSort(arr);
//        insertionSort(arr,arr.length);
//        selectionSort(arr);
        bubbleEnhanceSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

}
