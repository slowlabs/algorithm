package com.man1s.algorithm.algorithm.sort;

import java.util.HashSet;
import java.util.Set;

public class SortOlogn {


    public static void mapReduceSort(int [] arr,int start ,int end){
        int size = end-start;
        int mid = (end+start)/2;
        if(size>1){
            mapReduceSort(arr,start,mid);
            mapReduceSort(arr,mid,end);
        }else if(size==0){
            return;
        }
        int [] temp  = new int[size];
        int tempIndex = 0;
        int endIndex = mid;
        for (int i = start; i < mid; i++) {
            if(arr[i]<arr[endIndex]){
                temp[tempIndex++] = arr[i];
            }else if(endIndex<=end){
                temp[tempIndex++] = arr[endIndex++];
            }
        }
        tempIndex = 0;
        for (int i = start; i <=end; i++) {
            arr[i] = temp[tempIndex];
        }

    }


    private static void swtich(int [] arr,int index,int repIndex){
        arr[index] = arr[index]+arr[repIndex];
        arr[repIndex]= arr[index]-arr[repIndex];
        arr[index]= arr[index]-arr[repIndex];
    }
    private static void swtich1(int [] arr,int index,int repIndex){
        int  temp  = arr[index];
        arr[index] = arr[repIndex];
        arr[repIndex] = temp;
    }

    public static void quickSort(int [] arr,int start ,int end){
        int index  =start;
        boolean hasNext = false;
        for (int i = start; i <= end; i++) {
            if(arr[i]<arr[index]){
                swtich1(arr,i,index);
                swtich1(arr,i,index+1);
                index = index+1;
                hasNext = true;
            }
        }
        if(index>1&&hasNext){
            quickSort(arr,0,index-1);
        }
        if(index<arr.length-2&&hasNext){
            quickSort(arr,index+1,end);
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
