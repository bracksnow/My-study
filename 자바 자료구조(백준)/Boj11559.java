package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//간선의 가중치가 없기 때문에 BFS로 구성한다
public class Boj11559 {
    static char[][] map;//뿌요뿌요 맵을 말한다
    static boolean[][] visited;//방문한 곳인지 확인
    static int[] dx= {-1,1,0,0};//x축의 이동을 말함
    static int[] dy = {0,0,-1,1};//y축의 이동을 말함
    //한 점을 기준으로 밑은 (0,-1), 위는 (0,1), 오른쪽은 (1,0), 왼쪽은 (-1,0)
    static int M = 6;//세로
    static int N = 12;//가로
    static List<point> list;//'.'이 아닌 부분을 저장한다
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        //입력받기
        map = new char[N][M];
        visited = new boolean[N][M];
        list = new ArrayList<point>();
        for(int i = 0;i<N;i++){
            String row = bf.readLine();
            for(int j = 0;j<M;j++){
                map[i][j] = row.charAt(j);
            }
        }
        solve();
        System.out.println(count);
    }
    public static void solve(){
        while(true){
            //방문한 곳인지 확인하는 visited를 false로 초기화
            boolean flag = true;
            for(int i = 0;i<N;i++){
                for(int j = 0;j<M;j++){
                    visited[i][j] = false;
                }
            }
            //방문하지 않은 곳이면서 map에서 .이 아닌 지점부터 BFS탐색에 들어간다
            for(int i = 0;i<N;i++){
                for(int j = 0;j<M;j++){
                    if(!visited[i][j] && map[i][j]!='.') {
                        BFS(i, j);
                    }
                    if(list.size()>=4){
                        flag = false;
                        for(point p :list){
                            map[p.x][p.y] = '.';
                        }
                    }
                    list.clear();
                    }
                }
            down();
            if(flag){
                break;
            }else{
                count+=1;
            }
        }
    }
    public static boolean isBoundary(int row, int col) {
        return (row >= 0 && row < N) && (col >= 0 && col < M);
    }
    public static void BFS(int row, int col){
        Queue<point> q = new LinkedList<point>();
        visited[row][col] = true;
        char text = map[row][col];
        q.offer(new point(row,col));
        list.add(new point(row, col));
        while(!q.isEmpty()){
            point p = q.poll();
            int r = p.x;
            int y = p.y;
            for(int i = 0;i<4;i++){
                int nr = p.x+dx[i];
                int ny = p.x+dx[i];
                if(isBoundary(nr, ny)&&!visited[nr][ny] && map[nr][ny] == text){
                    list.add(new point(nr, ny));
                    q.offer(new point(nr, ny));
                    visited[nr][ny] = true;
                }
            }
        }
    }
    public static void down(){
        //뿌요가 터지고 나서 위에 있는 것들이 중력에 따라 내려오는 메소드
        for (int i = 0; i < M; i++) {
            for (int j = N - 1; j > 0; j--) {
                if (map[j][i] == '.') {
                    for (int k = j - 1; k >= 0; k--) {
                        if (map[k][i] != '.') {
                            map[j][i] = map[k][i];
                            map[k][i] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }

    public static class point{//내부클래스
        int x;
        int y;

        public point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

