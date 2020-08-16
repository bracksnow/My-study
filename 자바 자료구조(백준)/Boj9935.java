package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String sentence = bf.readLine();//문자열
        String bomb = bf.readLine();//폭탄문자열
        Stack<Character> s = new Stack<Character>();
        for(int i = sentence.length()-1;i>=0;i--){
            boolean isbomb  =false;
            s.push(sentence.charAt(i));
            if(sentence.charAt(i)==bomb.charAt(0) && s.size()>=bomb.length()){
                isbomb = true;
                for(int j = 0;j<bomb.length();j++){
                    if(bomb.charAt(j)!=s.get(s.size()-1-j)){
                        isbomb = false;
                        break;
                    }
                }
                if(isbomb){
                    for(int k = 0;k<bomb.length();k++){
                        s.pop();
                    }
                }
            }
        }
        if(s.isEmpty()){
            System.out.println("FRULA");
        }else{
            for(int i = 0;i<s.size()-1;i++){
                System.out.println(s.pop());
            }
        }

    }
}
