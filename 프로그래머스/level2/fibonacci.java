package DataStructure;

public class fibonacci {
    public static void main(String[] args) {
        System.out.println(solution(5));
    }
    public static int solution(int n) {//정수형범위를 벗어나서 생기는 문제임
        int[] dp = new int[100001];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2;i<=n;i++){
            dp[i] = (dp[i-1]%1234567+dp[i-2]%1234567)%1234567;
        }
        int answer = dp[n];
        return answer;
    }
}
