package DataStructure;

public class Solution_stack_h1 {
    public int[] solution(int[] heights) {
        int len = heights.length;
        int[] answer = new int[len];
        for(int i=0 ; i<len ; i++){
            boolean flag = false;
            for(int j=i-1 ; j>=0 ; j--){
                if(heights[j]>heights[i]){
                    flag = true;
                    answer[i] = j+1;
                    break;
                }
            }
            if(!flag){
                answer[i] = 0;
            }
        }
        return answer;
    }
}