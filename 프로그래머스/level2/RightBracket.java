package DataStructure;

import java.util.Stack;

public class RightBracket {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0;i<s.length();i++){
            if(stack.isEmpty()){
                stack.add(s.charAt(i));
            }
            else{
                if(stack.peek()==')'){
                    answer = false;
                }else{
                    if(s.charAt(i)==')'){
                        stack.pop();
                    }else{
                        stack.push(s.charAt(i));
                    }
                }
            }
        }
        if(!stack.isEmpty()){
            answer = false;
        }
        return answer;
    }
}
