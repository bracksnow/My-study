package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1958 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] sen1 = new String[100];
        String[] sen2 = new String[100];
        String[] sen3 = new String[100];
        sen1 = bf.readLine().split("");
        sen2 = bf.readLine().split("");
        sen3 = bf.readLine().split("");
        int[][][]dp = new int[102][102][102];
        for(int i = 1;i<=sen1.length;i++){
            for(int j = 1;j<=sen2.length;j++){
                for(int k = 1;k<=sen3.length;k++){
                    if(sen1[i-1].equals(sen2[j-1])&& sen2[j-1].equals(sen3[k-1])&& sen1[i-1].equals(sen3[k-1])){
                        dp[i][j][k] = dp[i-1][j-1][k-1] + 1;
                    }
                    else{
                        dp[i][j][k] = Math.max(Math.max(dp[i-1][j][k],dp[i][j-1][k]), dp[i][j][k-1]);
                    }
                }
            }
        }
        System.out.println(dp[sen1.length][sen2.length][sen3.length]);
    }
}
