package com.man1s.algorithm.algorithm.graph.data;

import lombok.Data;

import java.util.LinkedList;

@Data
public class GraphData {

    private LinkedList<Integer> []  data;

    private int nodeNum;

    public GraphData(int nodeNum) {
        this.nodeNum = nodeNum;
        data =  new LinkedList[nodeNum];
        for (int i = 0; i < nodeNum; i++) {
            data[i] = new LinkedList<>();
        }
    }


    public boolean addRelation(int relation,int index){
        if(relation >= nodeNum || index >= nodeNum){
            return false;
        }
        data[relation].add(index);
        data[index].add(relation);
        return true;
    }

    public static GraphData genneralGraphData(){
        GraphData data = new GraphData(9);
        data.addRelation(1,2);
        data.addRelation(1,3);
        data.addRelation(2,3);
        data.addRelation(2,4);
        data.addRelation(3,4);
        data.addRelation(4,7);
        data.addRelation(3,6);
        data.addRelation(3,5);
        data.addRelation(3,8);

        return data;
    }



}
