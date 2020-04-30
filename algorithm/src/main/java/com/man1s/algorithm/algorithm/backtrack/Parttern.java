package com.man1s.algorithm.algorithm.backtrack;

public class Parttern {

    private String parttern;

    private int slen;

    private boolean match;

    public void match(String str){
        rmacth(0,0,str.length(),str);
    }

    private void rmacth(int partternStart,int  strStart,int strLength,String str){
        if(partternStart==parttern.length()){
            if(strStart == strLength){
                match = true;
            }
            return;
        }
        if(strStart == strLength){
            return;
        }

        char charAt = parttern.charAt(partternStart);
        if(charAt == '*'){
            for (int i = 0; i <strLength -strStart  ; i++) {
                rmacth(partternStart+1,strStart+i,strLength,str);
            }
        }else if(charAt == '?'){
            rmacth(partternStart+1,strStart,strLength,str);
            rmacth(partternStart+1,strStart+1,strLength,str);
        }else if(charAt == str.charAt(strStart)){
            rmacth(partternStart+1,strStart+1,strLength,str);
        }


    }

    public static void main(String[] args) {

    }


}
