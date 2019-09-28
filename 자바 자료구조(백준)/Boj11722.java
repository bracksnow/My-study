package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11722 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] sequence = new int[count];
        int[] index = new int[count];
        for (int i = 0; i < count; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());//sequence에 int형으로 전부 바꿔서 넣음
        }
        for(int i = 0;i<count;i++){
            index[i] = 1;
            for(int j = 0;j<i;j++){
                if(sequence[i] < sequence[j] && index[j]+1 > index[i])
                    index[i] = index[j] + 1;
            }
        }
        int result = index[0];
        for(int i = 0; i < count; i++){
            if(index[i] > result)
                result = index[i];
        }
        System.out.println(result);
        }
    }


