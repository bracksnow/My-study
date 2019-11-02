package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bf.readLine());
        while(num-->0){
            int lnh = Integer.parseInt(bf.readLine());
            long [][]dp = new long [2][lnh+1];//n번째 줄에서 i번째까지의 최고점수
            long[][] arr = new long[2][lnh+1];
            String[] sdata = bf.readLine().split("\\s");
            String[] sdata1 = bf.readLine().split("\\s");
            for(int i = 0;i<lnh;i++){
                arr[0][i+1] = Long.parseLong(sdata[i]);
                arr[1][i+1] = Long.parseLong(sdata1[i]);
            }

            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];
            for(int i = 2;i<=lnh;i++){
                dp[0][i] = Math.max(dp[1][i-1],dp[1][i-2])+arr[0][i];
                dp[1][i] = Math.max(dp[0][i-1],dp[0][i-2])+arr[1][i];
            }
            System.out.println(Math.max(dp[0][lnh],dp[1][lnh]));





        }
        bf.close();
    }
}
