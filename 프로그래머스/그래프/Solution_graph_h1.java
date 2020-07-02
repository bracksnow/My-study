package DataStructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution_graph_h1 {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        boolean[] visited = new boolean[n+1];
        boolean[][] connection = new boolean[n+1][n+1];
        for(int i = 0; i < edge.length; i++) {
            connection[edge[i][0]][edge[i][1]] = connection[edge[i][1]][edge[i][0]] = true;
            //맨 앞 인덱스는 의미가 없어 true로 표시
        }
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        queue.add(1);//1부터 시작하기 때문에 1을 큐에 추가
        visited[0] = visited[1] = true;
        while(true) {
            answer = queue.size();
            while(!queue.isEmpty()) {
                int node = queue.poll();
                for(int j = 1; j <= n; j++) {
                    if(!visited[j] && connection[node][j]) {
                        list.add(j);
                        visited[j] = true;
                    }
                }
            }
            if(list.isEmpty()) {
                break;
            }
            queue.addAll(list);
            list.clear();
        }
        return answer;
    }
}