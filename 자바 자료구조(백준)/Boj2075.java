package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Boj2075 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(bf.readLine());
        int[] array = new int[N*N];
        int idx =0;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0; j<N; j++) {
                array[idx++] = Integer.parseInt(st.nextToken());
            }
        }
        Arrays.sort(array);
        System.out.println(array[N*N - N]);
    }
}
