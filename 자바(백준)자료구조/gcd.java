package DataStructure;

import java.util.Scanner;

public class gcd {
    static int gcd(int n,int m){
        if(m==0){
            return n;
        }
        else{
            return gcd(m,n%m);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("숫자를 입력해주세요");int num1 = sc.nextInt();
        System.out.println("숫자를 입력해주세요");int num2 = sc.nextInt();

        System.out.println(gcd(num1,num2));
    }
}
