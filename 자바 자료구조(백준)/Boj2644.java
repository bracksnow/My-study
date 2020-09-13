package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2644 {
    static int n;//사람의 수
    static int one, two;//첫번째 사람, 두번째 사람
    static int m;//관계의 수
    static int[][] map;
    static int[] checked;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());
        one = Integer.parseInt(st.nextToken());
        two = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(bf.readLine());
        map = new int[n+1][n+1];//배열인덱스 처리하기 위해 +1을 함
        checked = new int[n+1];//배열인덱스 처리하기 위해 +1을 함
        Arrays.fill(checked,0);
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
            int x = q.poll();
            for(int i = 1;i<map.length;i++){//+1을 해주고 인덱스0은 버린 것 주의하기!!
                if(map[x][i]==1 && checked[i]==0){
                    q.offer(i);
                    checked[i] = checked[x] + 1;
                }
            }
        }
        System.out.println(checked[two]==0?-1:checked[two]);//삼항연산자 사용, 최종적으로 two변수가 true가 아니면 -1출력
    }
}
