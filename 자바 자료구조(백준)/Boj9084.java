package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*2
1 2
1000
*/

public class Boj9084 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int text_count = Integer.parseInt(bf.readLine());//케이스 수

        while(text_count-->0){
            int coin_count = Integer.parseInt(bf.readLine());//동전 가지 수
            int[] coin  = new int[coin_count];
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int i = 0;i<coin_count;i++){//동전을 int형으로 받아오기
                coin[i] = Integer.parseInt(st.nextToken());
            }

            int pay = Integer.parseInt(bf.readLine());//금액
            int[] dp = new int[pay+1];
            dp[0] = 1;
            for(int i = 0;i<coin_count;i++){//dp안에 동전으로 만들어 지는 경우의 수를 전부 저장한다
                for(int j = coin[i];j<=pay;j++){
                    dp[j]  += dp[j-coin[i]];
                }
            }
            System.out.println(dp[pay]);
        }

    }
}
//10원을 1원과 2원으로 표시를 할 경우 1원만 사용하는 경우 + 1원과 2원을 사용하는 경우이다