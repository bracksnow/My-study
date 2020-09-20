package DataStructure;

import java.util.Scanner;

public class Boj2750_merge {
    static int[] array;
    static int count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        count = sc.nextInt();
        array = new int[count];
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt(); // 각 배열에 정수 저장
        }
        mergesort(array,0,array.length-1);
        for(int i:array){
            System.out.println(i);
        }
    }
    public static void mergesort(int[] array, int left, int right){
        if(left<right){
            int mid = (left+right)/2;
            mergesort(array, left, mid);
            mergesort(array, mid+1, right);
            merge(array, left, mid, right);
        }
    }
    public static void merge(int arr[], int l, int mid, int r){
        int i = l;
        int j = mid+1;
        int k = l;
        int[] temp = new int[array.length];
        while(i<=mid && j<=r){
            if(array[i]<array[j]){
                array[k++]=array[i];
            }else{
                array[k++]=array[j];
            }
        }
        while(i<=mid)
            temp[k++] = arr[i++];
        while(j<=r)
            temp[k++] = arr[j++];
    }
}

