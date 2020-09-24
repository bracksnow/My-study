package DataStructure;

import java.util.Scanner;

public class Boj2750_heap {
    static int[] array;
    static int count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        count = sc.nextInt();
        array = new int[count];
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt(); // 각 배열에 정수 저장
        }
        for(int i:array){
            System.out.println(i);
        }
    }
    public static void heapsort(int[] array){
        int sizeofheap = array.length-1;
        for(int i = sizeofheap;i>0;i--){
            swap(array,0,i);
            sizeofheap = sizeofheap-1;
            heapify(array, 0, sizeofheap);
        }
    }
    public static void buildheap(int[] array){
        for(int i = (array.length-1)/2;i>=0;i--){
            heapify(array, i, array.length-1);
        }
    }
    public static void heapify(int[] array, int i, int size){
        int left = i*2+1;
        int right = i*2+2;
        int max;
        if(left<=size && array[left]>array[i]){
            max = left;
        }else{
            max = i;
        }
        if(right<=size && array[right]>array[max]){
            max = right;
        }
        if(max!=i){
            swap(array, i, max);
            heapify(array, max, size);
        }
    }
    public static void swap(int[] array, int a, int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
