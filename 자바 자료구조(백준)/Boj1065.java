package DataStructure;

import java.util.Scanner;

public class Boj1065 {
    static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        for(int i  = 1;i<=number;i++){
            if(i<100){
                count++;
            }else if(i>=100 && i<1000){
                int one = i%10;
                int two = (i / 10) % 10;
                int three = (i / 100) % 10;
                if(one-two==two-three){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
