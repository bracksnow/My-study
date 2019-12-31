package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj1260 {
    static int N;
    static int M;
    static int V;
    static int[][] graph;
    static boolean[] visited;
    public static int fv, sv;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] command = new String[3];//정점, 간선, 번호
        command = bf.readLine().split(" ");
        N = Integer.parseInt(command[0]);//정점
        M  = Integer.parseInt(command[1]);//간선
        V = Integer.parseInt(command[2]);//탐색을 시작할 곳
        graph = new int [N+1][N+1];//그래프
        visited = new boolean[N+1];//방문한 곳 확인
        for(int i=1 ; i<=M ; i++) {
            String vertex[] = new String[N+1];
            vertex = bf.readLine().split(" ");
            fv = Integer.parseInt(vertex[0]);//첫번째 정점
            sv = Integer.parseInt(vertex[1]);//두번째 정점
            graph[fv][sv] = graph[sv][fv] = 1; }
        DFS(V);
        for(int i=1 ; i<=N ; i++){
            visited[i] = false;
        }
        System.out.println();
        BFS(V);
    }
    public static void DFS(int v){
        System.out.print(v+" ");
        visited[v] = true;
        for(int i = 1; i<=N;i++){
            if(graph[v][i] == 1 && visited[i] == false) {
                DFS(i);
            }
        }
    }
    public static void BFS(int v){
        Queue<Integer> queue = new LinkedList<Integer>();
        int out;
        queue.offer(v);//넣는 것을 말함
        visited[V] = true; System.out.print(V + " ");
        while(!queue.isEmpty()){
            out = queue.poll();//가장 첫번째 것을 꺼내는 것을 말함
        for(int i=1 ; i<= N ; i++) {
            if (graph[out][i] == 1 && visited[i] == false) {
                queue.offer(i);
                visited[i] = true;
                System.out.print(i + " ");
            }
        }
        }
    }
}
