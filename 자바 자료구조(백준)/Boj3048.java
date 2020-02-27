package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj3048 {
    static int N1;//첫번째 그룹의 개미 수
    static int N2;//두번째 그룹의 개미 수
    static char[] A1;//첫번째 그룹
    static char[] A2;//두번째 그룹
    static int T;
    public static void main(String[] args) throws IOException {
        ArrayList<ant> list = new ArrayList<ant>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb  = new StringBuilder();
        N1 = Integer.parseInt(st.nextToken());
        N2 = Integer.parseInt(st.nextToken());
        A1 = bf.readLine().toCharArray();
        A2 = bf.readLine().toCharArray();
        T = Integer.parseInt(bf.readLine());
        for(int i = N1-1;i>=0;i--){
            list.add(new ant(A1[i],true));//오른쪽으로 향하는 개미들
        }
        for(int i = 0;i<N2;i++){
            list.add(new ant(A2[i],false));//왼쪽으로 향하는 개미들
        }

        while(T-->0){
            for(int i = 0;i<list.size()-1;i++){
                ant current = list.get(i);
                ant next = list.get(i+1);
                if(!current.dir||current.dir==next.dir){
                    continue;
                }else{
                    list.set(i,next);
                    list.set(i+1,current);
                    i++;//계속 바꾸는 것이 아니라 한번 경우의 수가 생기면 바꾼 부분은 넘어가야하기 때문에 i++를 함
                }
            }

        }
        for(int i = 0;i<list.size();i++){
            sb.append(list.get(i).n);
        }
        System.out.println(sb.toString());
    }
    public static class ant{
        char n;
        boolean dir;

        public ant(char n, boolean dir) {
            this.n = n;
            this.dir = dir;
        }
    }
}
