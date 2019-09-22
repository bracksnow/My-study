package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//초콜릿자르기
//2X2인 경우에는 3번이면 가능하다

public class Boj2163 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] dp = new int[n+1][m+1];
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=m;j++){
                if(i==1 && j==1){
                    dp[i][j]= 0;
                }else{
                    dp[i][j] = i*j-1;
                }

            }
        }
        System.out.println(dp[n][m]);
    }
}
