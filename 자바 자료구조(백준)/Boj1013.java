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
            Pattern pattern = Pattern.compile("((100+1+)|(01))+");
            Matcher matcher = pattern.matcher(reg);
            System.out.println(matcher.matches()? "YES":"NO");
        }
    }
}
