package DataStructure;

import java.util.Scanner;

public class sequence {
    int top;
    int[] stack;
    int size;

    public sequence(int length) {
        this.stack = new int[length];
        int size = 0;
        int top = -1;
    }

    public int peek() {
        return stack[top];
    }

    public void push(int value) {
        stack[++top] = value;
        size++;
    }

    public int pop() {
        size--;
        return stack[top--];

    }

    public int IsEmpty() {
        if (size == 0) {
            return 1;
        }
        return -1;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int max = 0;
        String[] pm = new String[20];
        sequence se = new sequence(num);
        while(num>0){
            se.push(num);
            pm[num] = "+";
            max = num;
            num = sc.nextInt();
            if(se.peek()==num){
                se.pop();

            }else if(max<0){
                System.out.println();


            }
        }
    }
}

