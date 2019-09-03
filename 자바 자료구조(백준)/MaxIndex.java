package DataStructure;

import java.util.Scanner;

public class MaxIndex {
    static int Max(int[] a){
        int number = a[0];
        for(int i = 0;i<a.length;i++){
            if(number<a[i]){
                number = a[i];
            }
        }
        return number;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("사람 수를 입력하시오");
        int num = sc.nextInt();
        int[] height = new int[num];
        for(int i = 0;i<num;i++){
            System.out.println("키를 입력하시오");
            int b = sc.nextInt();
            height[i] = b;
        }
        System.out.printf("가장 큰 키는 %d입니다",Max(height));
    }
}
