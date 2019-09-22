package DataStructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//마지막 경우의 수때문에 long형으로 바꿔야한다
public class Boj9507 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(bf.readLine());
        long[] dp  = new long[68];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        while(count-->0){
            int num = Integer.parseInt(bf.readLine());
                if(dp[num]==0){
                    for(int i = 4;i<=num;i++){
                        dp[i] = dp[i-1]+dp[i-2]+dp[i-3]+dp[i-4];
                    }
                }
            bw.write((dp[num]+"\n"));
            }

        bf.close();
        bw.flush();
        bw.close();
        }
    }


