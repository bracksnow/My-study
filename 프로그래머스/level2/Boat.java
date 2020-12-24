package DataStructure;

import java.util.Arrays;
//for문으로 비교하면 시간복잡도때문에 문제가 생김
public class Boat {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{70, 50, 80, 50}, 100));
    }
    public static int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int right = people.length-1;
        int left = 0;
        while(right>=left){
            if(people[left]+people[right]<=limit){//무게가 제한 안에 있는 경우
                left++;
            }
            right--;
            answer++;
        }
        return answer;
    }
}
