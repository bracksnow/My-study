package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj3184 {
    static int R;//가로
    static int C;//세로
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static int twolf = 0;//늑대 총합
    static int tsheep = 0;//양 총합


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        visited = new boolean[R][C];
        for(int i = 0;i<R;i++){
            for(int j = 0; j<C;j++){
                visited[i][j] = false;
            }
        }
        for(int i = 0;i<R;i++){
            String command = bf.readLine();
            for(int j = 0;j<C;j++){
                map[i][j] = command.charAt(j);
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!visited[i][j] && map[i][j] != '#' ) {
                    BFS(i,j);
                    //BFS탐색 시작
                }
            }
        }

        System.out.println(tsheep+" "+twolf);


    }
    public static void BFS(int x, int y){
        Queue<Node> q = new LinkedList<Node>();
        q.offer(new Node(x,y));
        visited[x][y] = true;
        int wolf = 0;
        int sheep = 0;
        //처음 시작하는 부분이 양인지 늑대인지 확인한다
        if(map[x][y]=='v'){
            wolf++;
        }
        else if(map[x][y]=='o'){
            sheep++;
        }
        while(!q.isEmpty()){
            Node node = q.poll();
            for(int j = 0;j<4;j++){
                int sx = node.x+dx[j];
                int sy = node.y+dy[j];
                if(sx<0 || sy<0 || sx>=R || sy>=C) {
                    continue;
                }
                if(visited[sx][sy]){
                    continue;
                }
                if(map[sx][sy]=='#'){
                    continue;
                }
                if(map[sx][sy]=='v'){
                    wolf++;
                }
                else if(map[sx][sy]=='o'){
                    sheep++;
                }
                visited[sx][sy] = true;
                q.add(new Node(sx,sy));
                }
        }
        if(wolf>=sheep){
            twolf+=wolf;
        }else{
            tsheep+=sheep;
        }

    }

    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
