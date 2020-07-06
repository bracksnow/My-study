package DataStructure;

import java.util.Stack;

public class Solution_winter_doll {
    public static int solution(int[][] board, int[] moves) {
        Stack<Integer> st = new Stack<Integer>();
        int answer = 0;
        for(int movesnum : moves) {
            movesnum = movesnum-1;//-1을 해줘야하는 이유는 예시에선 1부터 시작이지만 배열은 0부터 시작이라서
            for(int i = 0;i<board.length;i++){
                if(board[i][movesnum]!=0){
                    if(!st.isEmpty()&&st.peek()==board[i][movesnum]){
                        st.pop();
                        answer = answer+2;
                    }else{
                        st.push(board[i][movesnum]);
                    }
                    board[i][movesnum] = 0;//빼고나선 꼭 0으로 바꿔줘야함 0이 그 자리에 인형이 없는 것을 의미하기 때문에
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        System.out.println(solution(board,moves));
    }
}
