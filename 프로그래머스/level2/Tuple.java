package DataStructure;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class Tuple {
    public int[] solution(String s) {
        s = s.substring(2, s.length()-2);
        s = s.replaceAll("[{}]", " ").trim();
        String[] str = s.split(" ,");
        int[] answer = new int[str.length];
        HashSet<Integer> set = new HashSet<Integer>();
        int index = 0;
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String s, String s2) {
                return s.length()-s2.length();
            }
        });
        for(String target : str){
            for(String st : target.split(",")){
                int a  = Integer.parseInt(st.trim());
                if(set.contains(a))continue;
                set.add(a);
                answer[index++] = a;
            }
        }
        return answer;
    }
}
