package com.man1s.algorithm.algorithm.bytedance;

public class DictionaryOrder {

    /**
     * a,b （a<b） 求 0-a 中字典序第b的树
     */
    public static Integer getDic(Integer a,Integer b){
        int quotient = b/ 11;
        int mod = b%11;
        if(mod==1){
            return quotient+1;
        }
        return  (quotient+1)*10+mod-2;
    }

    public static void main(String[] args) {
        System.out.println(getDic(12,11));
    }
}
