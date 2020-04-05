package DataStructure;

import java.util.Stack;

public class Soluction_greedy_h3 {
    public String solution(String number, int k) {
        char[] answer_row = new char[number.length()-k];
        Stack<Character> st = new Stack<Character>();
        for(int i = 0;i<number.length();i++){
            char c  = number.charAt(i);
            while(!st.isEmpty() && st.peek()<c && k-->0){
                st.pop();
            }
            st.push(c);
        }
        for(int i = 0;i<answer_row.length;i++){
            answer_row[i] = st.get(i);
        }
        return new String(answer_row);
    }
}
