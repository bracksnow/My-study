package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1010 {//조합으로 접근하면 쉽게 할 수 있다 x가 2이고 y가 4이면 4C2로 표현가능
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bf.readLine());
        while(count-->0){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int[][] dp = new int[31][31];
            for(int i=0;i<=30;i++){
                dp[i][0] = 1;
                dp[i][i] = 1;
                for(int j = 1;j<=i-1;j++){
                    dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
                }
            }
            System.out.println(dp[y][x]);
        }
    }
}
