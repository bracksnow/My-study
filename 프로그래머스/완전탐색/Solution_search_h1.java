package DataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution_search_h1 {
    public int[] solution(int[] answers) {
        int[] supoPeople = {0,0,0};
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        for(int i = 0;i<answers.length;i++){
            if(answers[i]==a[i%5]){
                supoPeople[0]++;
            }
            if(answers[i]==b[i%8]){
                supoPeople[1]++;
            }
            if(answers[i]==c[i%10]){
                supoPeople[2]++;
            }
        }
        int max = Math.max(Math.max(supoPeople[0], supoPeople[1]), supoPeople[2]);//최대값을 찾는다
        List<Integer> list = new ArrayList<Integer>();
        if(max == supoPeople[0]) {
            list.add(1);
        }
        if(max == supoPeople[1]) {
            list.add(2);
        }
        if(max == supoPeople[2]) {
            list.add(3);
        }
        if(list.size()>1){
            Collections.sort(list);//2이상일 경우에는 오름차순 정렬
        }
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);//list에 있는 것을 answer배열로 옮기기
        }
        return answer;
    }
}
