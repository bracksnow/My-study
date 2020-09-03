package DataStructure;

import java.util.Scanner;

public class Boj2750 { ;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] array = new int[count];
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt(); // 각 배열에 정수 저장
        }
        for(int i = 0;i< array.length;i++){
            for(int j = 0;j< array.length-1;j++){
                if(array[j]>array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        for(int i = 0;i< array.length;i++){
            System.out.println(array[i]);
        }

    }
}
