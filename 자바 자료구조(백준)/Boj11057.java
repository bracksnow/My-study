package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj11057 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf  = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bf.readLine());
        int dp[][] = new int[num+1][11];

        for(int i = 0;i<=num;i++){
            dp[i][0] = 0;
        }
        for(int i = 1;i<=10;i++){
            dp[0][i] = 0;
            dp[1][i] = 1;
        }
        for(int i = 1;i<=num;i++){
            for(int j = 1;j<=10;j++){
                dp[i][j] += dp[i-1][j]+dp[i][j-1];
            }
        }
        System.out.println(dp[num][10]%10007);
    }
}
