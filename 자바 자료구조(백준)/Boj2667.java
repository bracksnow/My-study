package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj2667 {
    static int[][] map;
    static boolean[][] visited;
    static int N;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int apart = 0;
    static int[] aparts = new int[25*25];


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String str = bf.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(str.substring(j, j + 1));
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    BFS(i, j);
                    apart++;
                }
            }
        }
    }
    public static void BFS(int x, int y){
        Queue<Node> q = new LinkedList<Node>();
        q.add(new Node(x,y));
        visited[x][y] = true;
        aparts[apart]++;
        while(!q.isEmpty()){
            Node node = q.poll();
            for(int i = 0;i<4;i++){
                int nextx = x+dx[i];
                int nexty = y+dy[i];
                if(nextx>=0 && nextx<N && nexty>=0 && nexty<N && !visited[nextx][nexty]&& map[nextx][nexty]==1){
                    visited[nextx][nexty] = true;
                    q.add(new Node(nextx, nexty));
                    aparts[apart]++;
                }
            }
        }
    }
    public static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}