package DataStructure;

import java.util.*;
class Solution_h1 {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < participant.length; i++){
            if(map.containsKey(participant[i])){
                map.replace(participant[i],map.get(participant[i])+1);//중복인 경우 value를 2로
            }else{
                map.put(participant[i],1);//처음 들어가는 경우에는 value를 1로 만들기
            }
        }

        for(int j = 0;j<completion.length;j++){
            if(map.containsKey(completion[j])){
                map.replace(completion[j],map.get(completion[j])-1);//completion에 들어간 것들 중 key로 존재할 경우에는 value를 1씩 감소
            }
        }
        String answer = "";
        for(String s : map.keySet()){
            if(map.get(s)==1){//앞에 for문에서 completion을 1씩 빼고 나면 1로 남는 경우에는 그 인원은 완주하지 못한 인원이다
                answer = s;
                break;//어차피 정답은 완주하지 못한 사람은 1명만 나올 수 밖에 없다.
            }
        }
        return answer;
    }
}