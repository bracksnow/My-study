package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj9372 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        for(int i = 0;i<T;i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            for(int j = 0;j<M;j++){
                bf.readLine();
            }
            System.out.println(N-1);
        }
    }
}
//그림을 그려보니 국가수-1이 비행기 종류의 최소 갯수로 나온다
//알아보니 최소 스패닝트리 문제이다.
//노드-1이 간선의 수이다.
//이게 가능했던 이유는 가장 중요한 것은 비행기 항로가 왕복이 가능하다는 것이 가장 중요하다
