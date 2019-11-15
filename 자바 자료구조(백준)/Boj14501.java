package DataStructure;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int num = Integer.parseInt(bf.readLine());
        int[] T = new int[num+2];
        int[] P = new int[num+2];
        int[] dp = new int[num+2];

        for(int i=1; i<=num; i++) {
            st = new StringTokenizer(bf.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=num; i>0; i--) {
            int day = i + T[i];
            if(day <= num+1)
                dp[i] = Math.max(P[i] + dp[day], dp[i+1]);
            else
                dp[i] = dp[i+1];
        }
        System.out.println(dp[1]);
    }
}



