package DataStructure;

import java.util.Scanner;

public class BFmatch {
    static int BFmatch(String text, String word){
        int pt = 0;
        int pp = 0;
        while(pt!=text.length() && pp!=word.length()){
            if(text.charAt(pt)==word.charAt(pp)){
                pt++;
                pp++;

            }else{
                pp = 0;
                pt = pt - pp+1;
            }
        }
        if(pp==word.length()) {
            return pt - pp;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        String word = sc.next();
        if(BFmatch(text,word)==-1){
            System.out.println("일치하는 부분이 없습니다");
        }else{
            System.out.println(BFmatch(text,word)+"부터 일치합니다");
        }
    }
}
