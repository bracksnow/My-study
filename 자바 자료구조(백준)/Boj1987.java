package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1987 {
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0}; // 상하 좌우;
    static int[] dx = {0, 0, -1, 1};
    static int R;
    static int C;
    static int max_step=1;
    static int step=1;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(bf.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(bf.readLine());
        map = new int[R][C];
        visited = new boolean[R][C];
        for(int i = 0;i<R;i++){
            String str = bf.readLine();
            for(int j = 0;j<C;j++){
                map[i][j] = str.charAt(j)-'A';//숫자로 변환
            }
        }
        DFS(0,0);
        System.out.println(max_step);
    }
    public static void DFS(int y, int x){
        visited[y][x] = true;
        for(int i = 0;i<4;i++){
            int nextx = dx[i]+x;
            int nexty = dy[i]+y;
            if(nextx>=0 && nexty>=0 && nextx< R && nexty<C){
                if(!visited[nexty][nextx]){
                    step++;
                    max_step = Math.max(max_step,step);
                    DFS(nexty, nexty);
                }
                else{
                    continue;
                }
            }else{
                continue;
            }
        }
        step--;
        visited[y][x] = false;

    }
}
