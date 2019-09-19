package DataStructure;

import java.util.Arrays;
import java.util.Scanner;

public class Boj11726 {
    public static int dp(int n){
        int[] d = new int[1001];
        Arrays.fill(d,0);
        d[0] = 1;
        d[1] = 1;
        for(int i = 2;i<=n;i++){
            d[i] = d[i-2]+d[i-1];
            d[i] %=10007;
        }
        System.out.println(d[n]);
        return d[n];

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        dp(num);
    }
}
