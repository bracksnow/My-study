package DataStructure;

//이진수를 사용하면 되는 문제였음
public class JumpAndBlink {
    public int solution(int n) {
        int ans = 0;
        String bianry = Integer.toBinaryString(n);
        for(int i = 0;i<bianry.length();i++){
            if(bianry.charAt(i)=='1'){
                ans++;
            }
        }
        return ans;
    }
}
