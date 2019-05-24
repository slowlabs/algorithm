package com.man1s.algorithm.algorithm.sort;

import com.man1s.algorithm.algorithm.array.Array;
import com.sun.deploy.util.ArrayUtil;

import java.util.Arrays;

public class SortOlogn {
    public static void mapReduceSort(int [] arr,int start ,int end){

    }


    public static void quickSort(int [] arr,int start ,int end){
        int mid  = (start+end)/2;
        int midValue = arr[mid];
        for (int i = mid-1;i<=start;i--){
            if(arr[i]>midValue){

            }
        }


    }


    public static void main(String[] args) {
        int [] arr  =  {2,1,4,8,5,4,3};
        mapReduceSort(arr,0,arr.length-1);
        for (int i : arr) {
            System.out.println(i);
        }
    }

}
