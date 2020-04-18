package DataStructure;
import java.util.Arrays;


//H번 이상 인용된 h편이상의 h의 최대값을 구하라
public class Solution_sort_h3 {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);//오름차순
        for(int i = 0;i<citations.length;i++){
            int h = citations.length - i;

            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }
        return answer;
    }
}
