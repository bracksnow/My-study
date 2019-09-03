package DataStructure;

import java.util.Scanner;

public class bubble_sort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] number = new int[count];
        for(int i = 0;i<count;i++){
            number[i] = sc.nextInt();
        }
        bubble(number);
        for(int SortedNumber:number){
            System.out.println(SortedNumber);
        }
    }

    public static void bubble(int number[]) {
        int temp = 0;
        for(int i = 0;i<number.length;i++){
            for(int j = 0;j<number.length-1;j++ ){
                if(number[j]>number[j+1]){
                    temp  = number[j];
                    number[j] = number[j+1];
                    number[j+1] = temp;
                }
            }
        }
    }
}
