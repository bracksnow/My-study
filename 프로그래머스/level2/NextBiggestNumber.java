package DataStructure;

public class NextBiggestNumber {
    public int solution(int n) {
        int binary = Integer.bitCount(n);//1의 개수를 세주는 메서드임 굳이 for문을 안돌려도 됨
        int findBinary = 0;
        int answer = 0;
        for(int i = n+1;i<=1000000;i++){
            findBinary = Integer.bitCount(i);
            if(binary==findBinary){
                answer = i;
                break;//최소값이기 때문에 조건을 만족하는 순간 for문 탈출
            }
        }
        return answer;
    }
}
