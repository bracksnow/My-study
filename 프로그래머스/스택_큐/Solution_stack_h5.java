package DataStructure;

public class Solution_stack_h5 {
    public int solution(String arrangement) {
        int stick = 0;
        int answer = 0;
        for(int i = 0;i<arrangement.length();i++) {
            char bracket = arrangement.charAt(i);
            if (bracket == '(') {
                if (arrangement.charAt(i + 1) == ')') {
                    answer += stick;
                    i++;
                }else{
                    stick++;
                }
            }else{
                answer++;
                stick--;

            }
        }
        return answer;
    }
}
