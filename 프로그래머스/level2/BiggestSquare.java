package DataStructure;

public class BiggestSquare {
    public int solution(int [][]board) {
        int answer = 0;
        int up, left, upLeft;
        for(int y = 1;y< board.length;y++){
            for(int x = 1;x<board[y].length;x++){
                if(board[y][x]==1){
                    up = board[y-1][x];
                    left = board[y][x-1];
                    upLeft = board[y-1][x-1];
                    int min = Math.min(up, upLeft);
                    min = Math.min(min, left);
                    board[y][x] = min+1;
                }
            }
        }
        int max = 0;
        for(int y = 0;y< board.length;y++){
            for(int x = 0;x< board[y].length;x++){
                if(board[y][x] > 0) {
                    max = Math.max(max, board[y][x]);
                }
            }
        }
        answer = max;
        return answer*answer;
    }
}
