package com.man1s.algorithm.algorithm.leetcode;



class Solution {

    public static void main(String[] args) {
        System.out.println(del("aabbddccf"));
    }

    public static char del(String a){
        char[] chars = a.toCharArray();
        int ans = chars[0];
        for (int i = 1; i < chars.length; i++) {
            ans = ans ^ chars[i];
        }
        return (char) ans;
    }




}