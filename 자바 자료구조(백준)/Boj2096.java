package DataStructure;
//백준 내려가기
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2096 {
    static int number;
    static int[][] game;
    static int dp[][];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        number = Integer.parseInt(bf.readLine());
        game = new int[number][3];
        dp = new int[number][3];
        StringTokenizer st;
        for(int i = 0;i<number;i++){
            st = new StringTokenizer(bf.readLine());
            game[i][0] = Integer.parseInt(st.nextToken());
            game[i][1] = Integer.parseInt(st.nextToken());
            game[i][2] = Integer.parseInt(st.nextToken());
        }
        dp[0][0] = game[0][0];
        dp[0][1] = game[0][1];
        dp[0][2] = game[0][2];
        for(int i = 1;i<number;i++){
            //dp기준으로 위에서 아래로 내리면 인덱스 범위가 벗어난다.
            //때문에 game기준으로 아래에서 위로 접근해야한다.
            dp[i][0] = game[i][0]+Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = game[i][1]+Math.max(Math.max(dp[i-1][0],dp[i-1][1]), dp[i-1][2]);
            dp[i][2] = game[i][2]+Math.max(dp[i-1][1],dp[i-1][2]);
        }
        int max = Math.max(dp[number-1][0], Math.max(dp[number-1][1], dp[number-1][2]));
        for(int i = 1 ; i < number ; i++){
            dp[i][0]=game[i][0]+Math.min(dp[i-1][0], dp[i-1][1]);
            dp[i][1]=game[i][1]+Math.min(dp[i-1][0], Math.min(dp[i-1][1], dp[i-1][2]));
            dp[i][2]=game[i][2]+Math.min(dp[i-1][1], dp[i-1][2]);
        }
        int min = Math.min(dp[number-1][0], Math.min(dp[number-1][1], dp[number-1][2]));
        System.out.println(max+" "+min);
    }
}
