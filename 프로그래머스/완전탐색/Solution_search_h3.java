package DataStructure;
import java.util.Stack;

public class Solution_search_h3 {
    public static int solution(int[][] baseball) {
        Stack<String> st=new Stack<String>();
        makenumber(st);
        int answer = 0;
        while(!st.isEmpty()){
            if(check(st.pop(),baseball)){
                answer++;
            }
        }
        return answer;
    }
    public static void makenumber(Stack st){
        for(int i = 1;i<=9;i++){
            for(int j = 1;j<=9;j++){
                for(int k = 1;k<=9;k++){
                    if(i!=k && j!=k && i!=j ){
                        st.push(String.valueOf(100*i+10*j+k));
                    }
                }
            }
        }
    }
    public static boolean check(String num, int[][] baseball) {
        String baseballnum = "";
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < baseball.length; i++) {
            baseballnum = String.valueOf(baseball[i][0]);
            for (int j = 0; j < 3; j++) {
                if (num.charAt(j) == baseballnum.charAt(j)) {//스트라이크 체크
                    strike++;
                }
                if (baseballnum.contains(String.valueOf(num.charAt(j)))) {//볼 체크
                    ball++;
                }
            }
            ball = ball - strike;
            if (strike != baseball[i][1] || ball != baseball[i][2]) {//strike와 ball을 확인해서 맞지 않는 경우에는 false를 출력
                return false;
            }
            strike = 0;
            ball = 0;
        }
        return true;

    }
}
