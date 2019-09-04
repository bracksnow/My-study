package DataStructure;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

//백준 17298번 스택 오큰수
//A의 오른쪽에 있으면서 A보다 크면서 가장 왼쪽에 있는 값을 찾고 그런 값이 없는 경우에는 -1를 출력한다.
//BufferdReader를 Scanner보다 빠르게 입력가능하다
public class rightBiggestNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        Stack stack = new Stack();
        int[] result = new int[num];
        Arrays.fill(result,-1);
        int[] a = new int[num];
        int i;
        for(i = 0;i<num;i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        for(i= 0; i<num; i++){
            int j = i;
            if(stack.empty()==true){
                stack.push(a[i]);
            }else{
                while(stack.empty()!=true && (int)stack.peek()<a[i]){
                    stack.pop();
                    stack.push(a[i]);
                    result[j-1] = a[i];
                }
            }
            if((int)stack.peek()>a[i]){
                stack.push(a[i]);

            }
        }
        for(int x:result){
            System.out.println(x);
        }
    }
}








