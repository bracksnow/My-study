package DataStructure;

//공식은 w+h-최대공약수임
//8 12 의 경우에는 14개가 빠짐
//8X12-최대공약수= 14개
public class Solution_perfect_square {
    public long solution(int w, int h) {
        long w1 = Long.parseLong(String.valueOf(w));
        long h1 = Long.parseLong(String.valueOf(h));
        long answer = w1*h1-(w1+h1-(GCD(w1,h1)));
        return answer;
    }
    public static long GCD(long w, long h){
        long a = w;
        long b = h;
        if(a<b){
            long temp = a;
            a = b;
            b = temp;
        }
        if(a%b==0){
            return b;
        }
        return GCD(b, a%b);
    }
}
