package DataStructure;

public class MakePrime {
    public int solution(int[] nums) {
        int answer = 0;
        for(int i = 0;i<nums.length;i++){//3중 for문으로 배열을 전부 확인하기
            for(int j = i+1;j< nums.length;j++){
                for(int k = j+1;k< nums.length;k++){
                    int sum = nums[i]+nums[j]+nums[k];
                    if(checkPrime(sum)){
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
    public boolean checkPrime(int num){
        for(int i=2; i*i<=num; i++){
            if(num % i == 0) return false;
        }
        return true;
    }
}
