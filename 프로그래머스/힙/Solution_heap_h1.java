package DataStructure;

import java.util.PriorityQueue;

public class Solution_heap_h1 {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();//작은 것들을 알아서 뽑아주기 위해서 우선순위 큐를 사용
        int answer = 0;
        for(int food:scoville){
            pq.offer(food);
        }
        while(pq.peek()<K){
            if(pq.size()==1){
                return -1;
            }
            int first = pq.poll();
            int second = pq.poll();
            int result = first+(second*2);
            pq.offer(result);
            answer++;
        }

        return answer;
    }
}
