package com.man1s.algorithm.algorithm.leetcode;


import java.util.regex.Pattern;

class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome("A man, a plan, a canal: Panama"));
    }
    private  static  final  Pattern pattern  = Pattern.compile("[a-zA-Z0-9]");

    public boolean isPalindrome(String s) {
        if(null==s){
            return false;
        }else if(s.length()==0){
            return true;
        }

        int start = 0 ;
        int end = s.length()-1;

       while (start<end){
           String startC = s.substring(start, start+1);
           if(!startC.matches("[a-zA-Z0-9]")){
               start++;
               continue;
           }
           String endC = s.substring(end, end+1);
           if(!endC.matches("[a-zA-Z0-9]")){
               end--;
               continue;
           }
           if(!startC.equalsIgnoreCase(endC)){
             return false;
           }
        start++;
           end--;
       }
        return true;
    }

}