package DataStructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_stack_h3 {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < speeds.length; i++) {
            double remain = (100 - progresses[i]) / (double) speeds[i];
            int date = (int) Math.ceil(remain);

            if (!q.isEmpty() && q.peek() < date) {
                list.add(q.size());
                q.clear();//나머지가 더 큰 것이 올 경우에는 리스트에 현재 큐의 크기를 보내고 비운다
            }

            q.offer(date);
        }

        list.add(q.size());

        int[] answer = new int[list.size()];
        for(int i=0 ; i<list.size() ; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
