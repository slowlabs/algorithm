package com.man1s.algorithm.algorithm.dichotomy;
@SuppressWarnings("all")
public class Test1 {


    public static void main(String[] args) {
        int [] arr  =  {2,2,3,3,3,6,7,7};
        System.out.println(getLastIndex(arr,0,arr.length-1,6));

    }


    public static int getFirstIndex(int [] arr,int start ,int end ,int num){
        while (true){
            if(start==end){
                return start;
            }
            int mid  = (start+end)/2;
            if(arr[mid]>=num){
                if(end==mid){
                    end = mid-1;
                }else {
                    end = mid;
                }
            }else{
                if(start==mid){
                    start = mid+1;
                }else {
                    start = mid;
                }
            }
        }

    }

    public static int getLastIndex(int [] arr,int start ,int end ,int num){
        while (true){
            if(start==end){
                return start;
            }
            int mid  = (start+end)/2;
            if(arr[mid]>num){
                if(end==mid){
                    end = mid-1;
                }else {
                    end = mid;
                }
            }else{
                if(start==mid){
                    start = mid+1;
                }else {
                    start = mid;
                }
            }
        }

    }
}
