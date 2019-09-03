package DataStructure;

import java.util.Scanner;

//백준 1158번 문제
public class joe {
    Node start = null;
    public class Node{
        int data;
        Node next;
        Node prev;
        public Node(int data){
            this.data = data;
            this.next = next;
            this.prev = prev;

        }
    }
    public void addNode(int data){
        Node node = new Node(data);
        Node current;
        if(start==null){
            start = node;
            current = start;
            current.next = start;
            start.prev = current;
            System.out.println(current.data);
        }else{
            current = start;
            while(current.next!=start){
                current = current.next;
            }
            current.next = node;
            node.prev = current;
            current = current.next;
            current.next = start;
            start.prev = current;
            System.out.println(current.data);
        }
    }
    public void deleteNode(int num) {
        Node current = start;
        while (current.next != current) {
            for(int i = 1;i<num;i++){
                current = current.next;
            }
            System.out.println(current.data);
            current.next.prev = current.prev;
            current.prev.next = current.next;
            current = current.next;
        }
        System.out.println(current.data);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int addNum = 7;
        int delete_num = 3;
        joe j = new joe();
        for(int i = 1;i<=addNum;i++){
            j.addNode(i);
        }
        j.deleteNode(3);

    }
}
