package DataStructure;

public class FindLsm {
    public int solution(int[] arr) {
        int answer = 0;
        int temp = arr[0];
        for(int i=0;i<arr.length;i++) {
            temp = LCM(temp, arr[i]);
        }
        answer = temp;
        return answer;
    }
    public int GCD(int a, int b){
        while(b!=0){
            int temp = a%b;
            a = b;
            b = temp;
        }
        return a;
    }
    public int LCM(int a, int b){
        return a*b/GCD(a,b);
    }
}
