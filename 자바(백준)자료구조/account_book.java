package DataStructure;

import java.util.Scanner;

public class account_book {
    int top;
    int[] stack;
    int size;

    public account_book(int length) {
        stack = new int[length];
        size = 0;
        top = -1;
    }

    public int peek() {
        return stack[top];
    }

    public void push(int item) {
        stack[++top] = item;
        size++;
    }

    public int pop() {
        size--;
        return stack[top--];

    }
    public int size(){
        return size;
    }
    public int sum(){
        int num = 0;
        for(int j = 0;j <size;j++){
            num += stack[j];
        }return num;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("숫자를 입력하시오");
        int num = sc.nextInt();
        account_book ab = new account_book(num);
        for(int i = 0;i<num;i++){
            int money = sc.nextInt();
            ab.push(money);
            if(money==0){
                ab.pop();
            }
        }
        System.out.println(ab.sum());
    }
}
