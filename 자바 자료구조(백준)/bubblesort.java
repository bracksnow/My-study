package DataStructure;

import java.util.Scanner;

public class bubblesort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] array = new int[count];
        for(int i=0;i< array.length;i++){
            array[i] = sc.nextInt();
        }
        for(int i = 0;i< array.length-1;i++){
            for(int j = 0;j< array.length-1-i;j++){
                if(array[j]>array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        for(int i:array){
            System.out.println(i);
        }
    }
}
