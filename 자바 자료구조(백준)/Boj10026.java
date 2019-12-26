package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj10026 {
    public static char map[][];
    public static boolean visited[][];
    public static int n;
    public static int dx[] = {0,0,1,-1};
    public static int dy[] = {-1,1,0,0};
    public static int count1 = 0;
    public static int count2 = 0;
    public static void dfs(int x, int y){
        visited[x][y] = true;
        char c = map[x][y];
        for(int i = 0;i<4;i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && ny>=0 && nx< n && ny<n && !visited[nx][ny]){
                if(map[nx][ny]==c){
                    dfs(nx,ny);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        for(int i = 0;i<n;i++){
            String[] str = br.readLine().split("");
            for(int j = 0;j<n;j++){
                map[i][j] = str[j].charAt(0);

            }
        }
        visited = new boolean[n][n];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(visited[i][j]==false){
                    count1++;
                    dfs(i,j);
                }
            }
        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(map[i][j]=='G'){
                    map[i][j]='R';
                }
            }
        }
        visited = new boolean[n][n];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(visited[i][j]==false){
                    count2++;
                    dfs(i,j);
                }
            }
        }
        System.out.println(count1+" "+count2);


    }
}
