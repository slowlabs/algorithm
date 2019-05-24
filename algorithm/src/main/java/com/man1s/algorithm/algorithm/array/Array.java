package com.man1s.algorithm.algorithm.array;

/**
 * 1) 数组的插入、删除、按照下标随机访问操作；
 * 2）数组中的数据是int类型的；
 */
public class Array {
    private  int [] data;

    private  int captition;

    private  int position;


    public Array(int size) {
        this.data = new int[size];
        captition = size;
        position = 0;
    }

    public boolean insert(int index ,int item){
        if(index>=data.length){
            return  false;
        }
        data[index] = item;
        return  true;
    }

    public boolean delete(int item){
        for (int i = item+1; i < data.length; i++) {
            data[i] = data[i];
        }
        return false;
    }

    public  int index(int index){
        if(index>= data.length){
            return  -1;
        }
        return  data[index];
    }
}
