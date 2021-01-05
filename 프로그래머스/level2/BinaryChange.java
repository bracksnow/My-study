package DataStructure;

public class BinaryChange {
    public int[] solution(String s) {
        int[] answer = {};
        int zeroCount = 0;
        int count = 0;
        while(!s.equals("1")){
            count++;
            String removeZero = s.replace("0","");
            zeroCount += s.length()-removeZero.length();
            s=Integer.toBinaryString(removeZero.length());
            //변환된 후의 길이 이용
        }
        answer = new int[2];
        answer[0] = count;
        answer[1] = zeroCount;
        return answer;
    }
}
