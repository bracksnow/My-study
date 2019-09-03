package DataStructure;

import java.util.Scanner;
import java.util.Arrays;

public class rightBiggestNumber {
    int top;
    int[] stack;
    int size;

    public rightBiggestNumber(int length) {
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
        int count = sc.nextInt();
        rightBiggestNumber bn = new rightBiggestNumber(count);
        String num = sc.next();
        String[] result = num.split(",");
        int[] intarray = new int[result.length];
        int[] answer = new int[result.length];





        for(int i = 0;i<result.length;i++){
            intarray[i] = Integer.parseInt(result[i]);
            bn.push(intarray[i]);
        }
        for(int j = bn.size()-1;j<=1;j--){
            int[] temp = new int[j];
            for(int x = 0;x<j;x++){
                temp[x] = bn.pop();
            }

            for(int n = 0;n<temp.length;n++){
                if(temp[n]>bn.peek()){
                    int[] middle = new int[temp.length];
                    middle[n] = temp[n];
                    answer[n] = middle[0];

                }
            }
        }
    }

}
