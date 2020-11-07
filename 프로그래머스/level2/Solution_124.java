package DataStructure;

public class Solution_124 {
    public String solution(int n) {
        String answer = "";
        int reminder = 0;//나머지
        while(n>0){
            reminder = n%3;
            n = n/3;
            if(reminder==0){
                n = n-1;
                reminder = 4;
            }
            answer = Integer.toString(reminder)+answer;
        }
        return answer;
    }
}
