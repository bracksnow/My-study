package DataStructure;

import java.util.Scanner;
//선택정렬

public class Boj2750_select {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] array = new int[count];
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt(); // 각 배열에 정수 저장
        }
        for(int i = 0; i< array.length;i++){
            int min = i;
            for(int j = i+1;j< array.length;j++){
                if(array[j]<array[min]){
                    min = j;
                }
            }
            if(array[i]>array[min]){
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
        for(int i = 0;i<array.length;i++){
            System.out.println(array[i]);
        }
    }
}
