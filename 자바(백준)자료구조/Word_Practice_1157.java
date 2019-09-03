package DataStructure;

import java.util.Scanner;

public class Word_Practice_1157 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] word = sc.next().toLowerCase().toCharArray();//문자열을 소문자로 대체한 후 1개씩 나누어 배열안에 넣음
        char[] alphabet = new char[26];//a~z까지가 들어갈 배열
        int[] number = new int[26];//안에 들어간 알파벳의 갯수를 카운트할 배열
        int i;
        int max = 0;
        for(i = 0;i<alphabet.length;i++){
            alphabet[i] = (char)(i+97);
        }
        for(i = 0;i<alphabet.length;i++){
            for(int j = 0;j<word.length;j++){
                if(alphabet[i]==word[j]){
                    number[i]++;
                }
            }
        }
        for(int x = 0;x<number.length;x++) {
            if (number[x] > max) {
                max = number[x];
            }
        }
        System.out.println(max);
    }
}
