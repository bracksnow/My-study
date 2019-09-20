package DataStructure;

//점화식을 구해야한다
//일단 끝자리-1이 0이면 인접비트에 영향을 주지 않는다
//끝자리가 1이면 인접비트에 영향을 준다
//dp[i][j][0],da[i][j][1]로 나누어 계산을 해줘야한다
//점화식 이해 불가


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2698 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[][][] bit = new int[101][101][2];
        bit[1][0][0] = 1;
        bit[1][0][1] = 1;
        for(int i = 2;i<=100;i++){
            for(int j = 0;j<i;j++){
                bit[i][j][0] = bit[i-1][j][0] + bit[i-1][j][0];
                if(j==0){
                    bit[i][j][1] += bit[i-1][j][1] + bit[i-1][j][1];
                }else{
                    bit[i][j][1] += bit[i-1][j][1] + bit[i-1][j-1][1];
                }
            }
        }
        while(count-->0){
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println();
            System.out.println(bit[a][b][0]+bit[a][b][1]);
        }
    }

}
