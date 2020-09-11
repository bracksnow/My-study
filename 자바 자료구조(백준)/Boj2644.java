package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2644 {
    static int n;//사람의 수
    static int one, two;//첫번째 사람, 두번째 사람
    static int m;//관계의 수
    static int[][] map;
    static boolean[] visited;
    static int count=0;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());
        one = Integer.parseInt(st.nextToken());
        two = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(bf.readLine());
        map = new int[n+1][n+1];//배열인덱스 처리하기 위해 +1을 함
        visited = new boolean[n+1];//배열인덱스 처리하기 위해 +1을 함
        for(int i = 0;i<m;i++){
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] =map[b][a] = 1;//x,y가 바뀌는 경우 고려(이 부분이 가장 생각하기 힘들었음)
        }
        BFS(one);
    }
    public static void BFS(int start){
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(start);
        while(!q.isEmpty()){
            count++;
            int x = q.poll();
            //System.out.println(x);
            visited[x] = true;
            for(int i = 1;i<=m;i++){
                if(map[x][i]==1 && !visited[i]){
                    q.offer(i);
                    System.out.println(q.size());
                }
            }
        }
        System.out.println(visited[two]==false?-1:count-1);//삼항연산자 사용, 최종적으로 two변수가 true가 아니면 -1출력
    }
}
