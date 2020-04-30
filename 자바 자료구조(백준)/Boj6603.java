package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj6603 {
    static int k;
    static int[] list;
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            k = Integer.parseInt(st.nextToken());
            if (k == 0) {
                break;
            }
            list = new int[k];
            result = new int[k];
            for(int i = 0;i<k;i++){
                list[i] = Integer.parseInt(st.nextToken());
            }
            DFS(0,0);
            System.out.println();
        }
    }

    public static void DFS(int start, int depth){
        if(depth==6){
            print();
        }
        for(int i=start; i<k; i++){
            result[i] = 1;
            DFS(i+1,depth+1);
            result[i] = 0;
        }

    }
    public static void print(){
        for(int i=0; i<k; i++){
            if(result[i]==1)
                System.out.print(list[i]+" ");
        }
        System.out.println();
    }
}
