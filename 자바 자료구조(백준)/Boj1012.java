package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1012 {
    static int[][] map;//배추밭
    static boolean[][] visited;//방문한 지점 확인을 위해 map을 하나 더 만듦
    static int[] dx = {-1,0,1,0};//좌상우하
    static int[] dy = {0,1,0,-1};
    static Queue<point> q;
    static int M;
    static int N;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=null;
        int T = Integer.parseInt(bf.readLine());//테스트 케이스
        while(T-->0){
            st = new StringTokenizer(bf.readLine());
            M = Integer.parseInt(st.nextToken());//배추밭의 가로 길이
            N = Integer.parseInt(st.nextToken());//배추밭의 세로 길이
            int K = Integer.parseInt(st.nextToken());//배추 개수이자 심어져 있는 위치
            map = new int[N][M];//[세로], [가로]
            visited = new boolean[N][M];
            q = new LinkedList<point>();//큐안에 좌표들을 넣을 수 있도록 한다
            answer = 0;
            while(K-- > 0) {
                st = new StringTokenizer(bf.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
                q.offer(new point(y,x));
            }
            while(!q.isEmpty()){
                point point = q.poll();
                if(!visited[point.y][point.x]){
                    DFS(point.y, point.x);
                    answer++;
                }
            }
        }
    }
    public static void DFS(int y, int x){
        visited[y][x] = true;
        for(int i = 0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=0 && ny>=0 && !visited[ny][nx] && map[ny][nx]==1 && nx<M && ny<N){
                DFS(ny, nx);
            }
        }

    }
    public static class point {//x, y좌표를 입력하기 쉽도록 point라는 클래스를 만듦
        int y;
        int x;

        public point(int Y, int X) {
            this.y = y;
            this.x = x;
        }
    }
}
