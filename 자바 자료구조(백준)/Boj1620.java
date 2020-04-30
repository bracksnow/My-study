package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(bf.readLine());
        int count = Integer.parseInt(st.nextToken());//포켓몬 수
        int problem = Integer.parseInt(st.nextToken());//문제 수
        HashMap<String,String> map = new HashMap<String, String>();
        for(int i = 1;i<=count;i++){
            String pokemon = bf.readLine();
            String number = Integer.toString(i);
            map.put(pokemon,number);
            map.put(number,pokemon);
        }
        for(int i = 0;i<problem;i++){
            System.out.println(map.get(bf.readLine()));
        }

    }
}
