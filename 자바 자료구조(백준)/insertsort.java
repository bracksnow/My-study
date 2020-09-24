package DataStructure;

import java.util.Scanner;

public class insertsort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] array = new int[count];
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }
        for(int i = 1;i< array.length;i++){
            int k = i;
            for(int j = i-1;j>=0;j--){
                if(array[k]>array[j]){
                    swap(array, k, j);
                    k = j;
                }
            }
        }
        for(int i:array){
            System.out.println(i);
        }
    }

    public static void swap(int[] array, int a, int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
