package DataStructure;
import java.util.ArrayList;
import java.util.HashSet;

public class Solution_graph_h2 {
    public int solution(int n, int[][] results) {
        int answer = 0;
        ArrayList<player> players = new ArrayList<player>();
        for (int i = 0; i <= n; i++) {
            players.add(new player(i));
        }
        for (int[] result : results) {
            players.get(result[0]).win.add(result[1]);//이긴횟수 넣기
            players.get(result[1]).lose.add(result[0]);//진 횟수 넣기
            //향상된 for문을 사용시에 가로 한줄 씩 접근하는 것이 가능
            //이후에 더 세로로 접근하고 싶으면 이중 for문을 사용하고 첫번찌 for문의 result를 대상으로 하면 됨
        }
        for (int depth = 0; depth < n; depth++) {
            for (int i = 1; i <= n; i++) {
                player player = players.get(i); // 현재 플레이어
                HashSet<Integer> winSet = new HashSet<>();
                for (Integer win : player.win) { // 현재 플레이어가 이길 리스트들
                    for (Integer w : players.get(win).win) { // 현재 플레이어가 이긴 플레이어의 이긴 리스트들
                        winSet.add(w);
                    }
                }
                player.win.addAll(winSet); // 추가
                HashSet<Integer> loseSet = new HashSet<>();
                for (Integer lose : player.lose) { // 현재 플레이어가 진 리스트들
                    for (Integer l : players.get(lose).lose) { // 현재 플레이어가 진 플레이어의 진 리스트들
                        loseSet.add(l);
                    }
                }
                player.lose.addAll(loseSet);
            }
        }
        for (player player : players) {
            int size = player.win.size() + player.lose.size();//이긴 것+진 것은 순위
            if (size == n-1) {//n-1일 경우 1씩 더해서 정확한 값을 찾는다
                answer++;
            }
        }
        return answer;
    }
    public class player{//플레이어마다 이긴 횟수, 진 횟수를 저정한다
        int num;
        HashSet<Integer> win = new HashSet<Integer>();
        HashSet<Integer> lose = new HashSet<Integer>();
        public player(int num) {
            this.num = num;
        }
    }

}
