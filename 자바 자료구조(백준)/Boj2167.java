package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2167 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int[][] square = new int[301][301];
        for(int i =1;i<=row;i++){
            st = new StringTokenizer(bf.readLine());
            for (int j = 1; j <= col; j++) {
                int num = Integer.parseInt(st.nextToken());
                square[i][j] = num;
            }
        }
        int t = Integer.parseInt(bf.readLine());
        while (t--> 0) {
            st = new StringTokenizer(bf.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int answer = 0;

            for (int a = i; a <=x; a++) {
                for (int b = j; b<=y; b++) {
                    answer+=square[a][b];
                }
            }
            System.out.println(answer);

        }
    }
}
