package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Boj2668 {
    static int N;
    static int[] array;
    static boolean[] visited;
    static int number;
    static ArrayList<Integer> list = new ArrayList<Integer>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        array = new int[N+1];
        visited = new boolean[N+1];
        for(int i = 1;i<=N;i++){
            array[i] = Integer.parseInt(bf.readLine());
        }
        for(int i = 1;i<=N;i++){
            visited[i] = true;
            number = i;
            DFS(i);
            visited[i] = false;
        }
        Collections.sort(list);
        System.out.println(list.size());
        for(int i:list){
            System.out.println(i);
        }

    }
    public static void DFS(int i){
        if(!visited[array[i]]){
            visited[array[i]] = true;
            DFS(array[i]);
            visited[array[i]] = false;
        }
        if(array[i]==number){
            list.add(number);
        }


    }
}
