package DataStructure;

import java.util.Scanner;

class Stack {

    int top;
    int[] stack;
    int size;

    public Stack(int length) {
        top = -1;
        stack = new int[length];
        size = 0;

    }

    public int peek() {
        return stack[top];
    }

    public void push(int value) {
        stack[++top] = value;
        System.out.println(stack[top] + " PUSH !");
        size++;
    }

    public int pop() {
        System.out.println(stack[top] + " POP !");
        size--;
        return stack[top--];

    }
    public int IsEmpty(){
        if(size==0) {
            return 1;
        }
        return -1;
    }
    public int size(){
     return size;
    }






    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("실행할 명령 횟수를 입력하시오");
        int count = sc.nextInt();
        Stack stack = new Stack(count);
        System.out.println("실행할 명령을 입력하시오");
        for(int i = 0;i<count;i++){
            String command = sc.next();
            String[] command_split = command.split("\\.");
            if(command_split[0].equals("push")){
                int result = Integer.parseInt(command_split[1]);
                stack.push(result);
            }else if(command_split[0].equals("peek")){
                System.out.println(stack.peek());
            }else if(command_split[0].equals("empty")){
                System.out.println(stack.IsEmpty());
            }else if (command_split[0].equals("pop")){
                System.out.println(stack.pop());
            }else if(command_split[0].equals("size")){
                System.out.println(stack.size());
            }
        }
    }
}
