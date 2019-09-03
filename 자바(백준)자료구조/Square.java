package DataStructure;

import java.util.Scanner;

public class Square {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("숫자를 입력하시오");
        int a = sc.nextInt();
        for(int i = 0;i<a;i++){
            System.out.println();
            for(int j = 0;j<a;j++){
                System.out.print("*");
            }
        }
    }
}
