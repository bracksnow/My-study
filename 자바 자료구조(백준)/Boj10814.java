package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Boj10814 {
    static int count;
    static String[][] array;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        count = Integer.parseInt(bf.readLine());//사람수
        array = new String [count][2];
        for(int i = 0;i<count;i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            array[i][0] = st.nextToken();
            array[i][1] = st.nextToken();
        }
        Arrays.sort(array, new Comparator<String[]>() {//입력순이기 때문에 굳이 이름은 비교X
            @Override
            public int compare(String[] t1, String[] t2) {
                return Integer.compare(Integer.parseInt(t1[0]), Integer.parseInt(t2[0]));
            }
        });
        for(int i = 0;i<count;i++){
            System.out.println(array[i][0]+" "+array[i][1]);
        }
    }
}
