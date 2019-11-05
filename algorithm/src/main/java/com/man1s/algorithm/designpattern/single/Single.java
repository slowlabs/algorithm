package com.man1s.algorithm.designpattern.single;

public class Single {
    private Single() {
    }

    static class SingleInner{
        private static final Single single  = new Single();
    }

    public static Single getInstance(){
        return SingleInner.single;
    }
    public void test(){
        System.out.println("test");
    }


}
