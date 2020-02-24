package DataStructure;
//조합을 사용하면 쉬운문제
//(모자+1)*(티셔츠+1)-1 = 경우의 수가 나오는 방식이다

import java.util.HashMap;

public class Solution_h3 {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        int answer = 1;
        for(int i = 0;i<clothes.length;i++){
            String key = clothes[i][1];
            if(!map.containsKey(key)){
                map.put(key,1);
            }else{
                map.replace(key,map.get(key+1));
            }
        }
        for(String key: map.keySet()){
            answer*=map.get(key)+1;//프로그래머스에서는 시작할 때 answer이 0이지만 조합을 이용하려면 곱셈을 이용해야하기 때문에 answer를 1로 변경
        }
        return answer-1;
    }
}
