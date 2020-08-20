package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2606 {
    static int[][] map;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int computer = Integer.parseInt(bf.readLine());//컴퓨터의 수
        int network = Integer.parseInt(bf.readLine());//연결되어있는 네트워크의 수
        map = new int[computer+1][computer+1];
        visited = new boolean[computer+1];
        for(int i = 0;i<network;i++){
            st = new StringTokenizer(bf.readLine());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());
            map[one][two] = map[two][one] = 1;
        }
        DFS(1);
    }
    public static void DFS(int number){
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(1);
        visited[1] = true;
        int count = 0;
        while(!q.isEmpty()){
            int virus = q.poll();
            for(int i = 1;i< map.length;i++){
                if(map[virus][i]==1 && !visited[i]){
                    q.offer(i);
                    visited[i] = true;
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
