package DataStructure;

import java.util.Scanner;

public class select_sort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] number = new int[count];
        for(int i = 0;i<count;i++){
            number[i] = sc.nextInt();
        }
        select(number);
        for(int SortedNumber:number){
            System.out.println(SortedNumber);
        }
    }

    public static void select(int number[]) {
        int indexMin, temp;
        for (int i = 0; i < number.length - 1; i++) {
            indexMin = i;
            for (int j = i + 1; j < number.length; j++) {
                if (number[j] < number[indexMin]) {
                    indexMin = j;
                }
            }
            temp = number[indexMin];
            number[indexMin] = number[i];
            number[i] = temp;
        }
    }
    }