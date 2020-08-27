package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Boj1013 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());//테스트 횟수
        while(T-->0){
            String reg = bf.readLine();
            Pattern pattern = Pattern.compile("((100+1+)|(01))+");//정규표현식을 만듦
            Matcher matcher = pattern.matcher(reg);//pattern 과 reg로 패턴확인
            System.out.println(matcher.matches()? "YES":"NO");//패턴일 경우에는 true 아니면 false
            //삼항연산자 이용함
        }
    }
}
