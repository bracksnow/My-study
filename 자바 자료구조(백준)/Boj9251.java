package DataStructure;
import java.util.Scanner;

public class Boj9251 {
    static char[] first = new char[1000];
    static char[] second = new char[1000];
    static int[][] LCS = new int[first.length][second.length];
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        first = sc.nextLine().toCharArray();
        second = sc.nextLine().toCharArray();
        for(int i = 1;i<=first.length;i++){
            for(int j = 1;j<= second.length;j++){
                if(first[i-1]==second[j-1]){
                    LCS[i][j] = LCS[i-1][j-1]+1;//가장 마지막에 오는 문자열이 같을 경우
                    //ex)AC+A C+A일 경우 적용할 수 있는 점화식
                }
                else{
                    LCS[i][j] = Math.max(LCS[i][j-1], LCS[i-1][j]);
                }
            }
        }
        System.out.println(LCS[first.length][second.length]);
        sc.close();
    }
}
