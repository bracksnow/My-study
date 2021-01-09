package DataStructure;

import java.util.ArrayList;

public class WordRelay {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        ArrayList<String> list = new ArrayList<>();
        list.add(words[0]);
        boolean flag = true;
        for(int i = 1;i< words.length;i++){
            if(list.contains(words[i])){
                answer[0] = (i%n) + 1;
                answer[1] = (i/n) + 1;
                flag = false;
                break;
            }
            list.add(words[i]);
            if(!words[i].startsWith(String.valueOf(words[i-1].charAt(words[i-1].length()-1)))){
                answer[0] = (i%n) + 1;
                answer[1] = (i/n) + 1;
                flag = false;
                break;
            }
        }
        if(flag){
            answer[0] = 0;
            answer[1] = 0;
        }
        return answer;
    }
}
