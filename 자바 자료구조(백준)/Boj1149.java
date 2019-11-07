package DataStructure;

import java.util.Scanner;

public class Boj1149 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int house = sc.nextInt();
        int[][] array = new int [house][3];
        int[][] dp = new int[house][3];
        for(int i = 0;i<house;i++) {
            for (int j = 0; j < 3; j++) {
                array[i][j] = sc.nextInt();
            }
        }
        dp[0][0] = array[0][0];
        dp[0][1] = array[0][1];
        dp[0][2] = array[0][2];
        for(int j=1; j<house; j++) {
            dp[j][0] = Math.min(dp[j-1][1], dp[j-1][2]) + array[j][0];
            dp[j][1] = Math.min(dp[j-1][0], dp[j-1][2]) + array[j][1];
            dp[j][2] = Math.min(dp[j-1][0], dp[j-1][1]) + array[j][2];
        }
        System.out.println(Math.min(Math.min(dp[house - 1][0], dp[house - 1][1]), dp[house - 1][2]));
    }
}
