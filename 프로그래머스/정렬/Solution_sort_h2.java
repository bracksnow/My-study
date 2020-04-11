package DataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution_sort_h2 {
    public String solution(int[] numbers) {
        ArrayList<String> list = new ArrayList<String>();
        String answer = "";
        String[] stnumber = new String[numbers.length];//숫자를 문자열로 변경하기위한 배열
        for(int i = 0;i<numbers.length;i++){
            stnumber[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(stnumber, new Comparator<String>() {//comparator을 사용하면 내가 정의한대로 정렬을 한다
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);//내림차순으로 변경, 올림차순으로 변경하고 싶을 경우에는 (01+o2).compareto(o2+o1)으로 변경
            }
        });//정렬을 내가 원하는 방법으로 정렬하기 위해선 Comparator을 사용한다
        if(stnumber[0].startsWith("0")) {
            answer += "0";
        } else {
            for(int j=0; j<stnumber.length; j++) {
                answer += stnumber[j];
            }
        }
        return answer;
    }
}
