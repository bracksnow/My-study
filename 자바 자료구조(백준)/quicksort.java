package DataStructure;

import java.util.Scanner;

public class quicksort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] array = new int[count];
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }

    }
    public static void quicksort(int[] array, int left, int right){
        int pivot = array[(left+right)/2];
        int pl = left;
        int pr = right;
        do{
            while(array[pl]<pivot)
                pl++;
            while(array[pr]>pivot)
                pr--;
            if(pl<=pr){
                swap(array,pl++,pr--);
            }
        }while(pl<=pr);
        if(left<pr){
            quicksort(array,left,pr);
        }
        if(pl<right){
            quicksort(array,pl,right);
        }

    }
    public static void swap(int[] array, int x, int y){
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
}
