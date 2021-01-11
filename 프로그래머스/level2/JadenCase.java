package DataStructure;

public class JadenCase {
    public String solution(String s) {
        String[] alpha = s.toLowerCase().split("");
        String answer = "";

        boolean flag = true;

        for(String word : alpha) {
            answer += flag ? word.toUpperCase() : word;
            flag = word.equals(" ") ? true : false;
        }
        return answer;
    }
}
