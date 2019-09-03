package DataStructure;

import java.util.Scanner;

public class Card {
    int front;
    int rear;
    int[] intArray;
    int size;

    public Card(int length){
        this.intArray =new int[length];
        front = 0;
        rear = 0;
        size = 0;

    }
    public void enqueue(int item){
        if(isfull()==true){
            System.out.println("Full");
        }
        else{
            rear = (rear+1)%intArray.length;
            intArray[rear] = item;
            size+=1;
        }

    }
    public int dequeue(){
        if(isempty()==true){
            return -1;
        }
        else{
            front = (front+1)%intArray.length;
            return intArray[front];
        }
    }
    public int size(){
        return size;
    }

    public boolean isempty(){
        if(front==rear){
            return true;
        }else{
            return false;
        }

    }
    public boolean isfull(){
        if((rear+1)%intArray.length==front){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Card card = new Card(num);
        for(int i = 0;i<num;i++){
            card.enqueue(i);
        }
        while(card.size()==1){
            int command = sc.nextInt();
            if(command==1){
                card.dequeue();
            }else{
                card.enqueue(card.dequeue());
            }
        }
        card.dequeue();
    }
}