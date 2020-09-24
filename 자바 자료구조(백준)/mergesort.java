package DataStructure;

import java.util.Scanner;

public class mergesort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] array = new int[count];
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
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
    public static void merge(int[] array, int left, int mid, int right){
        int i = left;
        int j = mid+1;
        int k = i;
        int[] temp = new int[array.length];
        while(i<=mid && j<=right){
            if(array[i]<array[j]){
                temp[k++] = array[i++];
            }else{
                temp[k++] = array[j++];
            }
        }
        while(i<=mid){
            temp[k++] = array[i++];
        }
        while(j<=right){
            temp[k++] = array[j++];
        }
        for(int index = left;index<k;index++){
            array[index] = temp[index];
        }
    }
}
