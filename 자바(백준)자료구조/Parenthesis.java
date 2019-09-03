//문자열에서 괄호만 따로 모아 변수로 만들고 거기서 여는 괄호가 들어가면 전부 스택에 넣다가 닫는괄호가 나오면 전부 pop한다
//아님 괄호만 따로 모아서 기존의 문제대로 돌려서 스택의 사이즈가 0이면 Ok
//tochararray함수 사용해보기!!
//buffered reader사용해보기
package DataStructure;

import java.util.Scanner;

public class Parenthesis {
    int top;
    String[] stack;
    int size;

    public Parenthesis(int length) {
        stack = new String[length];
        size = 0;
        top = -1;
    }

    public String peek() {
        return stack[top];
    }

    public void push(String item) {
        stack[++top] = item;
        size++;
    }

    public String pop() {
        size--;
        return stack[top--];
    }

    public int size() {
        return size;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String parent = sc.next();
        String[] test = parent.split(",");
        Parenthesis pc = new Parenthesis(test.length);
        for (int j = 0; j < test.length; j++) {
            if (test[j].equals("(")) {
                pc.push(test[j]);
            }else if(test[j].equals(")")){
                if(pc.peek().equals("(")){
                    pc.pop();
                }
            }
        }
        if (pc.size()==0){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }
    }
}