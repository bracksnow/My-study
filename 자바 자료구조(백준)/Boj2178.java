package DataStructure;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2178 {
    static int n,m, count = 0;
    static int visit[][];
    static int map[][];
    static int[] dx  = {0,-1,0,1}, dy = {1,0,-1,0};
    public static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visit = new int[n][m];
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String input[] = bf.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        bfs();
        System.out.println(count+1);
    }
        public static void bfs(){
            Queue<Node> q = new LinkedList<>();
            q.offer(new Node(0,0));//큐안에 넣는 것
            while(!q.isEmpty()){
                int size = q.size();
                count++;
                for(int i = 0;i<size;i++){
                    Node node = q.poll();//큐를 출력
                    for(int j = 0;j<4;j++){
                        int sx = node.x+dx[j];
                        int sy = node.y+dy[j];
                        if(sx>=0 && sy>=0 && sx<n && sy<m && visit[sx][sy]==0 && map[sx][sy]==1){
                            if(sx==(n-1) && sy==(m-1)){
                                return;
                            }
                            visit[sx][sy] = 1;
                            q.offer(new Node(sx,sy));
                        }
                    }
                }
            }
        }

    }

