package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj4963 {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = { 0, 0, 1, -1, 1, -1, 1, -1 };
    static int[] dy = { -1, 1, 0, 0, -1, 1, 1, -1 };//문제를 읽어보니 대각선도 고려해줘야함->상하좌우만 하는 것 X
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(true){
            st = new StringTokenizer(bf.readLine());
            int W = Integer.parseInt(st.nextToken());//너비
            int H = Integer.parseInt(st.nextToken());//높이
            if(W==0 && H==0){
                break;
            }else{
                map = new int[H][W];//세로 가로 기준
                for(int i = 0;i<H;i++){
                    st = new StringTokenizer(bf.readLine());
                    for(int j = 0;j<W;j++){//세로
                        map[i][j] = Integer.parseInt(st.nextToken());
                    }
                }
                visited = new boolean[H][W];
                int count = 0;
                for(int i = 0;i<H;i++){
                    for(int j = 0;j<W;j++){
                        if(map[i][j]==1 && !visited[i][j]){
                            DFS(i, j, W, H);//Y좌표, X좌표, 너비, 높이
                            count++;
                        }
                    }
                }
                System.out.println(count);
            }
        }
    }
    public static void DFS(int y, int x,int W, int H){
        visited[y][x] = true;
        for(int i = 0;i<8;i++){
            int nextX = dx[i]+x;
            int nextY = dy[i]+y;
            if(nextY>=0 && nextX>=0 && nextX<W && nextY<H && !visited[nextY][nextX] && map[nextY][nextX]==1){
                DFS(nextY, nextX, W, H);
            }
        }
    }
}
