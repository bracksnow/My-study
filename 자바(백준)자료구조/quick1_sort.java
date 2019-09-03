package DataStructure;

import java.util.Scanner;

public class quick1_sort {
    public static void quick(int[] array, int left, int right){
        int pivot = array[(left+right)/2];
        int pl = left;
        int pr = right;
        while(pl<=pr){
            while(array[pl]<pivot){
                pl++;
            }
            while(array[pr]>pivot){
                pr--;
            }
            if(pl<=pr){
                swap(array,pl++,pr--);
            }
        }
        if(left<pr){
            quick(array,left,pr);
        }
        if(pl<right){
            quick(array,pl,right);
        }
    }
    public static void swap(int array[],int a, int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] number = new int[count];
        for(int i = 0;i<count;i++){
            number[i] = sc.nextInt();
        }
        quick(number,0,count-1);
        for(int SortedNumber:number){
            System.out.println(SortedNumber);
        }

    }
}
