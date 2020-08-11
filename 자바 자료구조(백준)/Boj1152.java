package DataStructure;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1152 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String sentence = bf.readLine().trim();//trim을 사용하면 문자열 앞 뒤의 공백을 없애준다
        int count = 0;
        for(int i = 0;i<sentence.length();i++){
            if(sentence.substring(i,i+1).equals(" ")){
                count++;
            }
        }
        if(sentence.isEmpty()){
            System.out.println(0);
        }else{
            System.out.println(count+1);
        }
    }
}
