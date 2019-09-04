package DataStructure;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
//백준 17298번 스택 오큰수
//A의 오른쪽에 있으면서 A보다 크면서 가장 왼쪽에 있는 값을 찾고 그런 값이 없는 경우에는 -1를 출력한다.
public class rightBiggestNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack stack = new Stack();
        int count = sc.nextInt();
        String[] problem = new String[count];
        problem = sc.next().split("\\s");
        int[] num = new int[count];
        int i;

        for(i = 0;i<count;i++){
            num[i] = Integer.parseInt(problem[i]);
            stack.push(num[i]);
        }
        for(i = 0;i<count;i++){
            stack.search(i+1);
        }


    }
}


