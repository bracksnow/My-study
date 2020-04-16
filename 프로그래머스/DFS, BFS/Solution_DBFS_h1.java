package DataStructure;
//BFS는 큐를 이용하고 DFS는 재귀, 스택을 이용한다

public class Solution_DBFS_h1 {
    static int answer = 0;
    public static int solution(int[] numbers, int target) {
        DFS(numbers,target,0);
        return answer;
    }
    public static void DFS(int[] numbers, int target,int index){
        if(index==numbers.length){
            int sum = 0;
            for(int number:numbers){
                sum+=number;
            }
            if(sum==target){
                answer++;
            }
        }else{
            //트리이 구조가 여기서 사용
            numbers[index]*=1;
            DFS(numbers,target,index+1);
            numbers[index]*=-1;
            DFS(numbers,target,index+1);
        }
    }

    public static void main(String[] args) {
        int[] numbers = {1,1,1,1,1};
        int target = 3;
        System.out.println(solution(numbers,target));
    }
}
