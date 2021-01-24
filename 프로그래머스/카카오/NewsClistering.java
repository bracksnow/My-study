package DataStructure;

import java.util.ArrayList;
import java.util.Collections;

public class NewsClistering {
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();//대소문자는 같은 것으로 판단하기 때문에
        ArrayList<String> firstSet = new ArrayList<>();
        ArrayList<String> secondSet = new ArrayList<>();
        ArrayList<String> unionSet = new ArrayList<>();
        ArrayList<String> inter = new ArrayList<>();
        for(int i=0; i<str1.length()-1; i++) {
            char ch1 = str1.charAt(i);
            char ch2 = str1.charAt(i+1);
            if(ch1 >= 'a' && ch1 <= 'z' && ch2 >= 'a' && ch2 <= 'z') {
                firstSet.add(ch1+""+ch2);
            }
        }
        for(int i = 0;i<str2.length()-1;i++){
            char ch1 = str2.charAt(i);
            char ch2 = str2.charAt(i+1);
            if(ch1 >= 'a' && ch1 <= 'z' && ch2 >= 'a' && ch2 <= 'z') {//이 부분에서 특수문자는 바로 제거됨
                secondSet.add(ch1+""+ch2);
            }
        }
        Collections.sort(firstSet);
        Collections.sort(secondSet);
        for(int i = 0;i<firstSet.size();i++){
            String firstSetChar = firstSet.get(i);
            if(secondSet.remove(firstSetChar)){
                inter.add(firstSetChar);
            }
            unionSet.add(firstSetChar);
        }
        for(int i=0; i<secondSet.size(); i++) {
            String secondSetChar = secondSet.get(i);
            unionSet.add(secondSetChar);
        }
        double answer = 0;
        if(unionSet.size() == 0)
            answer = 1;
        else
            answer = (double)inter.size() / (double)unionSet.size();

        return (int)(answer*65536);
    }
}
