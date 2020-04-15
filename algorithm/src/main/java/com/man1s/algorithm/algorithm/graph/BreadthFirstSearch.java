package com.man1s.algorithm.algorithm.graph;

import com.man1s.algorithm.algorithm.graph.data.GraphData;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class BreadthFirstSearch {

    public static void main(String[] args) {
        GraphData data = GraphData.genneralGraphData();
        shortestRoute(data,1,1);
    }

    private static void shortestRoute(GraphData graphData, int start, int end) {
        LinkedList<Integer>[] data = graphData.getData();
        Integer [] pre = new Integer[graphData.getNodeNum()];
        Integer [] visited = new Integer [graphData.getNodeNum()];
        Queue<Integer> queues = new LinkedBlockingDeque<>();
        queues.add(start);
        while (queues.size()>0){
            Integer num = ((LinkedBlockingDeque<Integer>) queues).pop();
            LinkedList<Integer> dataNum = data[num];
            for (Integer integer : dataNum) {
                if(visited[integer] !=null){
                    continue;
                }
                pre[integer] = num;
                visited[integer] = 1;
                if(integer == end){
                    printRoute(pre,start,end );
                    return;
                }
                queues.add(integer);
            }
        }
    }

    private static void printRoute( Integer [] pre,int start,int end) {
        if(end == start){
            System.out.println(start);
            return;
        }
        printRoute(pre,start,pre[end]);
        System.out.println(end);


    }





}
