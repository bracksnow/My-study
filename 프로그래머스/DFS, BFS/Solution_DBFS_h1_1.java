package DataStructure;
//프로그래머스 DFS 타켓넘버 다시 풀어보기
public class Solution_DBFS_h1_1 {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        DFS(numbers, target, 0);
        return answer;
    }
    public void DFS(int[] numbers, int target, int index){
        if(numbers.length==index){
            int sum = 0;
            for(int i = 0;i< numbers.length;i++){
                sum+=numbers[i];
            }
            if(sum==target){
                answer++;
            }
        }
        else{
            numbers[index]*=1;
            DFS(numbers, target, index+1);
            numbers[index]*=-1;
            DFS(numbers, target, index+1);
        }

    }
}
