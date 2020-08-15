package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj11656 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String sentence = bf.readLine();
        String[] word = new String[sentence.length()];
        for (int i = 0; i < sentence.length(); i++) {
            word[i] = sentence.substring(i,sentence.length());
        }
        Arrays.sort(word);
        for(String answer:word){
            System.out.println(answer);
        }
    }
}
