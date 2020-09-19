package DataStructure;

import java.util.Scanner;

public class Boj2750_insert {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int j;
        int[] array = new int[count];
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt(); // 각 배열에 정수 저장
        }
        for(int i = 1;i< array.length;i++){
            int temp = array[i];
            for(j = i-1;j>=0 && array[j]>temp;j--){
                array[j+1] = array[j];
            }
            array[j+1] = temp;
        }
        for(int index:array){
            System.out.println(index);
        }
    }
}
