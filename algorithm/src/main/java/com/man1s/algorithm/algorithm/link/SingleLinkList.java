package com.man1s.algorithm.algorithm.link;

/**
 * 1）单链表的插入、删除、查找操作；
 * 2）链表中存储的是int类型的数据；
 *
 */
public class SingleLinkList {

    private SingleNode first;

    private  SingleNode last;

    public boolean insert(int value){
        if(last==null){
            last = new SingleNode(null,value);
            first = new SingleNode(last,value);
        }else {
            SingleNode temp = new SingleNode(null,value);
            last.setNext(temp);
            last = temp;
        }
        return  true;
    }

    public boolean delete(int value){
        SingleNode pre = null;
        for (SingleNode node = first; node != null;node = node.next){
            if(node.getValue()==value){
                if(pre ==null){
                    first = node;
                }else {
                    pre.next = node.next;
                }
                return  true;
            }
        }
        return  false;
    }

    public SingleNode find(int value){
        for (SingleNode node = first; node != null;node = node.next){
            if(node.getValue()==value){
                return node;
            }
        }
        return null;
    }



    private class SingleNode{
        private  SingleNode next;
        private  int value;

        public SingleNode(SingleNode next, int value) {
            this.next = next;
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public SingleNode getNext() {
            return next;
        }

        public void setNext(SingleNode next) {
            this.next = next;
        }
    }


}
