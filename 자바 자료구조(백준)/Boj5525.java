package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj5525 {
    static int N, M;
    static char[] S;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(bf.readLine());
        M = Integer.parseInt(bf.readLine());
        S = bf.readLine().toCharArray();
        int result = 0;
        int count = 0;
        for(int i = 0;i<M-2;i++){
            if(S[i]=='I' && S[i+1]=='O' && S[i+2]=='I'){
                count++;//문자열의 IOI 개수를 확인
                if(count==N){
                    count--;//count가 N에 맞는 경우에는
                    result++;
                }
                i++;//IO'I'부터 확인하기 위해서
            }else{
                count = 0;
            }
        }
        System.out.println(result);
    }
}
