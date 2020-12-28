package DataStructure;

public class Carpet {
    public int[] solution(int brown, int yellow) {
        int[] answer = {0,0};
        int sum = brown+yellow;
        for(int i = 3;i<=sum;i++){//문제에서 brown은 8이상 yellow는 1이상이기 때문에 가로 세로는 최소한 3이상
            if(sum%i==0){
                int col = sum/i;//약수로 가로 세로를 구한다
                int row = sum/col;
                int yellowCol = col-2;
                int yellowRow = row-2;
                if(yellowCol*yellowRow==yellow && col>=row){
                    answer[0] = col;
                    answer[1] = row;
                }
            }
        }
        return answer;
    }
}
