package DataStructure;

import java.util.LinkedList;
import java.util.Queue;

class Bridge {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int sum = 0;//다리에 놓여진 트럭들의 총무게
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int truck:truck_weights){
            while(true){
                if(queue.isEmpty()){
                    queue.add(truck);
                    sum+=truck;
                    answer++;
                    break;
                }else if(queue.size()==bridge_length){
                    sum-=queue.poll();//예를 들어 2초후인 경우 트럭이 큐에 한대만 남아있어야한다.
                }else{
                    if(sum+truck>weight){
                        queue.add(0);
                        answer++;
                    }else{
                        queue.add(truck);
                        sum+=truck;
                        answer++;
                        break;
                    }
                }
            }
        }
        return answer+bridge_length;
    }
}