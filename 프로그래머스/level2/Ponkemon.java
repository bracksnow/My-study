package DataStructure;

import java.util.ArrayList;

public class Ponkemon {
    public int solution(int[] nums) {
        int answer = 0;
        //중복을 없애기 위해서 Haseset을 사용해도 됨->이게 더 좋은 방법일 듯
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(nums[0]);//중복비교를 위해서 하나는 넣어야함
        for(int i = 1;i<nums.length;i++){
            if(list.contains(nums[i])){
                continue;
            }else{
                list.add(nums[i]);
            }
        }
        answer = (list.size()<nums.length/2)? list.size() : nums.length/2;
        return answer;
    }
}
