package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1600 {
    static int[][] map;
    static boolean[][][] visited;
    static int W;//가로
    static int H;//세로
    static int K;//나이트처럼 움직일 수 있는 경우의 수
    static int[] dx = {0,0,-1,1};//인접한 경우 상하좌우를 움직이는 경우
    static int[] dy = {-1,1,0,0};//인접한 경우 상하좌우를 움직이는 경우
    static int kdx[] = { 2, 2, -2, -2, 1, 1, -1, -1 };//나이트처럼 대각선을 움직이는 경우
    static int kdy[] = { 1, -1, 1, -1, 2, -2, 2, -2 };//나이트처럼 대각선을 움직이는 경우
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        visited = new boolean[H][W][31];

        for(int i = 0;i<H;i++){
            String input = bf.readLine();
            for(int j = 0;j<W;j++){
                map[i][j] = input.charAt(j);
            }
        }
        for(int i = 0;i<H;i++){
            for(int j = 0;j<W;j++){
                for(int k = 0;k<31;k++){
                    visited[i][j][k] = false;
                }
            }
        }
        visited[0][0][0]=true;
        BFS();
    }
    public static void BFS(){
        Queue<Node> q = new LinkedList<Node>();
        q.offer(new Node(0,0,K,0));
        while(!q.isEmpty()){
            Node N = q.poll();
            int mapX = N.x;
            int mapY = N.y;
            int mapZ = N.z;
            int cnt = N.cnt;
            if(mapX==W-1 && mapY==H-1){
                System.out.println(cnt);
                return;

            }
            if(mapX>=W||mapY>=H||mapX<0||mapY<0){
                continue;
            }
            if(map[mapY][mapX]==1){
                continue;
            }
            if(visited[mapY][mapX][mapZ]){
                continue;
            }
            visited[mapY][mapX][mapZ] = true;
            for(int i = 0;i<4;i++){
                int newX = dx[i]+mapX;
                int newY = dy[i]+mapY;
                q.offer(new Node(newX,newY,mapZ,cnt+1));
            }
            if(mapZ==0){
                continue;
            }
            for(int i = 0;i<8;i++) {
                int newX = kdx[i] + mapX;
                int newY = kdy[i] + mapY;
                q.offer(new Node(newX,newY,mapZ-1,cnt+1));
            }

        }
        System.out.println(-1);
        return;

    }

    public static class Node{
        int x;
        int y;
        int z;//K의 횟수가 얼마나 남아있는지 체크
        int cnt;//움직인 횟수를 확인한다

        public Node(int x, int y, int z, int cnt) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.cnt = cnt;
        }
    }
}
