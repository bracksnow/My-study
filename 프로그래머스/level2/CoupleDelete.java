package DataStructure;

import java.util.Stack;

public class CoupleDelete {
    public int solution(String s){
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i<s.length();i++){
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
            }else{
                if(stack.peek().equals(s.charAt(i))){
                    stack.pop();
                }else{
                    stack.push(s.charAt(i));
                }
            }
        }
        int answer = 0;
        if(stack.isEmpty()){
            answer = 1;
            return answer;
        }
        return answer;
    }
}
