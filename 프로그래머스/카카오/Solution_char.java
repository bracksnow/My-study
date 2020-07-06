package DataStructure;

public class Solution_char {
    public static int solution(String s) {
        if(s.length() == 1){
            return 1;
        }
        int answer =1001;//S의 길이가 1이상 1000이하라고 해서 answer은 1001부터 시작하도록 만듦
        for (int i = 1; i <= s.length() / 2; i++) {
            String standard="";
            String compare= "";
            String zip ="";
            int count = 1;
            for (int j = 0; j <= s.length() / i; j++) {
                int start = j * i;
                int end = i * (j + 1) > s.length() ? s.length() : i * (j + 1);
                standard = compare;
                compare = s.substring(start, end);
                if(standard.equals(compare)){
                    count++;
                }else{
                    if(count>1){
                        zip += String.valueOf(count)+standard;
                        count=1;
                    }else{
                        zip+=""+standard;
                    }

                }
            }
            zip += String.valueOf(count)+compare;
            answer = Math.min(answer, zip.length());


        }
        return answer-1;
    }

    public static void main(String[] args) {

        System.out.println(  solution("abcabcdede"));
    }




}
