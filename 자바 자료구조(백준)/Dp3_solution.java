package DataStructure;

public class Dp3_solution {
    public static void LIS(int[] array){
        int[] dp = new int[array.length];
        int max = 0;
        dp[0] = 1;
        for(int i = 1;i<array.length;i++){
            dp[i] = 1;
            for(int j = 0;j<i;j++){
                if(array[i]>array[j] && dp[j]+1>dp[i]){
                    dp[i] = dp[j]+1;
                }
            }
            if(max<dp[i]){
                max = dp[i];
            }
        }
        System.out.println(max);

    }
    public static void main(String[] args) {
        int[] array = {1, 10, 5, 20, 15, 10, 30, 49, 25, 35, 66, 75, 44};
        LIS(array);

    }
}
