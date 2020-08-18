package DataStructure;

import java.util.Scanner;

public class Boj11724 {
    static int N;//정점의 수s
    static int M;//간선의 수
    static int graph[][];
    static int visited[];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        graph = new int[N+1][N+1];
        visited = new int[N+1];
        for(int i = 0;i<M;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u][v]=graph[u][v]=1;
        }
        int count = 1;
        for(int i = 1;i<=N;i++){
            if(visited[i]==0){
                DFS(i,count);
                count++;
            }
        }
        System.out.println(count-1);

    }
    static void DFS(int i, int count){
        visited[i] = count;
        for(int j = 1;j<N+1;j++){
            if(graph[i][j]==1 && visited[j]==0){
                DFS(j, count);
            }
        }
    }
}
