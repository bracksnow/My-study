package DataStructure;

import java.util.Scanner;

public class Factorial {
    static int factorial(int n){
        if(n>1){
            return n*factorial(n-1);
        }
        else{
            return 1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("숫자를 입력하시오");
        int num = sc.nextInt();
        System.out.println(factorial(num));
    }
}
