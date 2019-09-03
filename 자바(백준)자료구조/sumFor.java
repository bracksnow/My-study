package DataStructure;

import java.util.Scanner;

public class sumFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("숫자를 입력하시오");
        int a = sc.nextInt();
        int sum = 0;
        for(int i = 0;i<=a;i++){
            sum+=i;
        }
        System.out.println(sum);

    }
}
