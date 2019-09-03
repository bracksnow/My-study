package DataStructure;

import java.util.Scanner;

public class insert_sort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] number = new int[count];
        for(int i = 0;i<count;i++){
            number[i] = sc.nextInt();
        }
        insert(number);
        for(int SortedNumber:number){
            System.out.println(SortedNumber);
        }
    }

    public static void insert(int number[]) {
        int temp = 0;
        for(int i = 1;i<number.length;i++){
            for(int j = i;j>0;j--){
                if(number[j-1]>number[j]){
                    temp  = number[j-1];
                    number[j-1] = number[j];
                    number[j] = temp;
                }
            }
        }
    }
}
