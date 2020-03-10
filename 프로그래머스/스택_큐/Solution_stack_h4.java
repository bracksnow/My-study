package DataStructure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;


class Solution_stack_h4 {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        ArrayList<Integer> resultArray = new ArrayList<>();
        Queue<Paper> queue = new LinkedList<Paper>();
        for (int i = 0 ; i < priorities.length ; i++) {
            queue.add(new Paper(priorities[i], i));
        }
        int preQueueSize = 0;

        while(!queue.isEmpty()) {

            preQueueSize = queue.size();

            Paper p = queue.poll();

            Iterator<Paper> it = queue.iterator();

            while(it.hasNext()) {
                if (it.next().priority > p.priority) {
                    queue.add(p);
                    break;
                }
            }

            if (queue.size() != preQueueSize) {
                resultArray.add(p.location);
            }
        }

        answer = resultArray.indexOf(location) + 1;

        return answer;
    }

    public static class Paper {
        int priority;
        int location;

        public Paper(int priority, int location) {
            this.priority = priority;
            this.location = location;
        }
    }
}
