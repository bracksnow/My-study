package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2631 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bf.readLine());
        int[] dp = new int[count];
        int[] line = new int [count];
        for(int i = 0;i<count;i++){
            line[i] = Integer.parseInt(bf.readLine());
        }
        dp[0] = 1;//J때문에 dp[0]=1로 함
        int max = 0;
        for(int i = 1;i<count;i++){
            dp[i] = 1;
            for(int j = 0;j<i;j++){
                if(line[i]>line[j] && dp[i]<dp[j]+1){
                    dp[i] = dp[j]+1;

                }
            }
            if(max<dp[i]){
                max = dp[i];
            }
        }
        System.out.println(count-max);
    }

}
