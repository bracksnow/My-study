package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj3190 {
    static int N;
    static int[][] map;
    static int apple;
    static int[] dx = {-1,0,1,0};//x축 방향벡터 북동남서
    static int[] dy = {0,1,0,-1};//y축 방향벡터
    static int L;
    static int[] time;
    static int[] dir;
    static Deque<Node> snake = new ArrayDeque<Node>();//뱀을 머리와 꼬리를 쉽게 뽑기 위해 디큐사용
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(bf.readLine());
        map = new int[N + 1][N + 1];//NxN형식의 정사각형 보드
        apple = Integer.parseInt(bf.readLine());//사과가 몇 개 있는 지를 말함
        for (int i =0 ;i < apple; i++) {
            st = new StringTokenizer(bf.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            map[row][col] = 1;//사과가 있는 위치를 1로 표시
        }
        L = Integer.parseInt(bf.readLine());
        time = new int[L];
        dir = new int[L];
        for(int i = 0;i<L;i++){
            st = new StringTokenizer(bf.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            dir[i] = getdir(st.nextToken());
        }
        solution();

    }
    public static void solution(){
        int second = 0;
        int snakeDir = 1;    // 첫 방향은 오른쪽이라고 함
        int tindex = 0;//시간이 지났음을 알려주기 위한 것
        map[1][1] = 2;
        snake.add(new Node(1, 1));
        while(true){
            if(tindex < L && time[tindex] == second) {
                snakeDir = (snakeDir + dir[tindex])%4;
                tindex++;
            }
            int nx = snake.getFirst().x + dx[snakeDir];
            int ny = snake.getFirst().y + dy[snakeDir];
            //몸과 만나거니 벽인 경우
            if(nx <= 0 || nx > N || ny <= 0 || ny > N) {
                System.out.println(second + 1);
                break;
            }
            if(map[nx][ny] == 2) {
                System.out.println(second + 1);
                break;
            }//이동한 칸에 사과가 있으면 사과를 먹은 것으로 처리후 머리길이 증가
            if(map[nx][ny] == 1) {
                map[nx][ny] = 2;
                snake.addFirst(new Node(nx, ny));

            }
            else if(map[nx][ny] == 0) {
                map[nx][ny] = 2;
                snake.addFirst(new Node(nx, ny));

                Node tail = snake.removeLast();
                map[tail.x][tail.y] = 0;
            }

            second++;

        }

    }
    public static int getdir(String a){
        if(a.equals("D")){
            return 1;//오른쪽
        }
        else{
            return 3;//왼쪽
        }

    }
    public static class Node{
        int x;
        int y;


        public Node(int x, int y) {
            this.x = x;
            this.y = y;

        }
    }
}
