package DataStructure;
//설명이 부족한 편
//처음에 1하고 2,3,2,3,을 비교해서 전부 1보다 크기때문에 1씩 더해서 4가 나온다
//3초인 3이 문제인데 이때는 비교를 해서 최종적으로 prices[3],prices[4]와 비교한다->prices[3]이 2로 작기 때문에 1을 더하고 멈춘다
//마지막 배열인 3은 비교할 것이 없기 때문에 0이 나온다

public class Solution_stack_h6 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i = 0;i<prices.length;i++){
            int count = 0;
            for(int j = i+1;j<prices.length;j++){
                if(prices[i]<=prices[j]){
                    count++;
                }else{
                    count++;
                    break;
                }
            }
            answer[i] = count;
        }
        return answer;
    }
}