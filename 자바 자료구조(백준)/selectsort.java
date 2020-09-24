package DataStructure;

import java.util.Scanner;

public class selectsort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] array = new int[count];
        for(int i=0;i< array.length;i++){
            array[i] = sc.nextInt();
        }
        for(int i = 0;i< array.length;i++){
            int min = i;
            for(int j = i+1;j< array.length;j++){
                if(array[j]>array[min]){
                    min = j;
                }
            }
            if(array[i]>array[min]){//해당 인덱스로 변경해준다
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
    }
}
