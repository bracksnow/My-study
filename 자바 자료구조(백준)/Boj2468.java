package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj2468 {
    static int[][] map;
    static boolean visited[][];
    static int[] dx = {-1,0,1,0};//X좌표
    static int[] dy = {0,1,0,-1};//Y좌표
    static int max = -1;
    static int count = 1;
    static int N;
    static PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());//최대값을 뽑기 위해 우선순위 큐를 사용
    //오름차순으로 적용하고 싶으면 Collections.reverseOrder()를 사용한다
    public static void main(String[] args) throws IOException {
        BufferedReader bf  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(bf.readLine());//행과 열의 길이
        map = new int[N][N];
        for(int i = 0;i<N;i++){
            st = new StringTokenizer(bf.readLine());
            for(int j = 0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(max<map[i][j]){
                    max = map[i][j];//최대값을 찾아 그 이하인 수까지를 전부 돌아 최대값을 찾도록 함
                }
            }
        }
        for(int m = 1;m<=max;m++){
            visited = new boolean[N][N];
            for(int i = 0;i<N;i++){
                for(int j = 0;j<N;j++){
                    if(!visited[i][j] && map[i][j]>m){
                        DFS(i,j,m);
                        count++;
                        pq.add(count);
                    }
                }
            }
            count = 0;
        }
        System.out.println(pq.poll());
        bf.close();
    }
    public static void DFS(int i, int j, int h){
        visited[i][j] = true;
        for(int t = 0;t<4;t++){
            int nextx = dx[t]+i;
            int nexty = dy[t]+j;
            if(nextx>=0 && nexty>=0 && nextx<N && nexty<N){//조건문을 한번에 적용하는 것보다는 if문을 중복으로 사용하는 것이 자원을 아끼는데는 좋음
                if(!visited[nextx][nexty] && map[nextx][nexty]>h){
                    DFS(nextx, nexty, h);
                }
            }
        }
    }
}
