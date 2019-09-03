package DataStructure;

import java.util.Scanner;

public class SugarDelievery_2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int kg = sc.nextInt();
        int num = 0;
        while(kg>2){
            if(kg>=10){
                kg = kg-5;
                num++;
            }else{
                kg = kg-3;
                num++;
            }
        }
        if(kg<=2 && kg>0){
            System.out.println(-1);
        }else{
            System.out.println(num);
        }

    }
}
