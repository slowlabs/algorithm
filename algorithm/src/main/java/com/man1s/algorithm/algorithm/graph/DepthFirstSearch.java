package com.man1s.algorithm.algorithm.graph;

import com.man1s.algorithm.algorithm.graph.data.GraphData;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class DepthFirstSearch {

    public static void main(String[] args) {
        GraphData data = GraphData.genneralGraphData();
        depthRoute(data,1,5);
    }

    private static void depthRoute(GraphData graphData, int start, int end) {
        Integer pre []  = new Integer[graphData.getNodeNum()];
        Integer [] exit = new  Integer[graphData.getNodeNum()];
        LinkedList<Integer>[] data = graphData.getData();
        scanToNull(exit,pre,data,start,end);
        printRoute(start,end,pre);

    }

    private static void printRoute(int start,int end, Integer[] pre) {
        if(start == end){
            System.out.println(start);
            return;
       }
        printRoute(start,pre[end],pre);
        System.out.println(end);
    }

    private static void scanToNull(Integer[] exit, Integer[] pre, LinkedList<Integer>[] data, int start, int end) {
        if(exit[start]!=null||start ==end){
            return;
        }
        LinkedList<Integer> datum = data[start];
        for (Integer integer : datum) {
            pre[integer] = start;
            exit[start] = 1;
            scanToNull(exit,pre,data,integer,end);
        }


    }

}
