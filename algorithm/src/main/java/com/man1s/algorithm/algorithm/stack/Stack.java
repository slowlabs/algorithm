package com.man1s.algorithm.algorithm.stack;

public class Stack {

    private Integer captital;

    private Integer position;

    private  Node head;

    public Stack(Integer captital) {
        this.captital = captital;
        this.position = 0 ;
    }
    public boolean add(Object value){
        if(captital==position){
            return false;
        }
        Node  node = new Node(null,value);
        if(head==null){
            head = node;
        }
        node.next=head;
        head = node;
        position++;
        return  true;
    }

    public Object pop(){
        if(position>0){
            Node item = head;
            head = head.next;
            position--;
            return  item;
        }
        return  null;
    }




    public  static  class Node{
        private  Node next;

        private  Object value;

        public Node(Node next, Object value) {
            this.next = next;
            this.value = value;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    public static void main(String[] args) {
        Stack stack  = new Stack(3);
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        stack.add(5);
        stack.add(6);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

}
