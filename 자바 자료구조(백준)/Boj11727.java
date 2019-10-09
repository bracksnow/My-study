package DataStructure;

import java.util.Scanner;

public class Boj11727 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] dp = new int[num+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2;i<=num;i++){
            dp[i] = dp[i-1]+(dp[i-2]*2);
            dp[i]%=10007;
        }
        System.out.println(dp[num]);
    }
}
