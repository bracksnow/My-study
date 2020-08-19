package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String sentence = bf.readLine();
        String search = bf.readLine();//검색하고자 하는 문자열
        int count = 0;
        for(int i = 0;i<sentence.length()-search.length()+1;i++){
            if(sentence.substring(i,i+search.length()).equals(search)){
                count++;
                i+=search.length();//문자열 길이만큼 뛰어넘기
                i--;
            }else{
                continue;
            }
        }
        System.out.println(count);
    }
}
