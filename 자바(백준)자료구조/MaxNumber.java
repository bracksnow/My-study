package DataStructure;

import java.util.Scanner;

public class MaxNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("숫자 3개를 입력하시오");
        System.out.println("첫번째 숫자를 입력하시오");
        int a = sc.nextInt();
        System.out.println("두번째 숫자를 입력하시오");
        int b = sc.nextInt();
        System.out.println("세번째 숫자를 입력하시오");
        int c = sc.nextInt();

        int max = a;
        if(b>c && max<b) {
            max = b;
        }
        else if(c>b && max<c){
            max = c;
            }
        System.out.println(max);
        }

    }

