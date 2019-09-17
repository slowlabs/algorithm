package com.man1s.algorithm.algorithm.sort;

public class SortO2 {

    private static void swtich(int [] arr,int index,int repIndex){
        arr[index] = arr[index]+arr[repIndex];
        arr[repIndex]= arr[index]-arr[repIndex];
        arr[index]= arr[index]-arr[repIndex];
    }

    public static  void bubbleSort(int [] arr){
        for (int i = 0; i < arr.length; i++) {
            boolean finish = true;
            for (int j = 0; j < arr.length-i-1; j++) {
                if(arr[j]>arr[j+1]){
                    swtich(arr,j,j+1);
                    finish = false;
                }
            }
            if(finish){
                break;
            }
        }

    }
    public  static  void selectionSort(int [] arr){
        for (int i = 0; i < arr.length; i++) {
            int maxIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[maxIndex]>arr[j]){
                    maxIndex = j;
                }
            }
            if(maxIndex!=i){
                swtich(arr,i,maxIndex);
            }
        }

    }




    public  static  void insertSort(int [] arr){
        for (int i = 1; i < arr.length; i++) {
            int temp  = i;
            for (int j = i-1; j >=0; j--) {
                if(arr[temp]<arr[j]){
                    swtich(arr,temp,j);
                    temp = j;
                }
            }
        }
    }



    public static void main(String[] args) {
        int [] arr  =  {2,1,4,8,5,4,3};
//        bubbleSort(arr);
//        insertSort(arr);
        selectionSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

}
