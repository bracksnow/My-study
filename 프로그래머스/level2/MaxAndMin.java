package DataStructure;

import java.util.ArrayList;
import java.util.Collections;

public class MaxAndMin {
    public String solution(String s) {
        String[] str = s.split(" ");
        ArrayList<Integer> list = new ArrayList<Integer>();//Collections를 사용하고 싶으면 list로 변환해야함
        for(int i=0; i<str.length; i++) {
            list.add(Integer.parseInt(str[i]));
        }
        String answer = Collections.min(list)+" "+Collections.max(list);
        return answer;
    }
}
