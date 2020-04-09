package DataStructure;

import java.util.HashSet;
import java.util.Set;

public class Solution_search_h2 {
    public int solution(String numbers) {
        char[] chnumberarray = numbers.toCharArray();//문자열을 배열로 만든다
        int[] array = new int[chnumberarray.length];//문자열로 만든 배열을 숫자로 만든 배열로 변경
        for (int i = 0; i < chnumberarray.length; i++) {
            array[i] = Integer.parseInt(String.valueOf(chnumberarray[i]));
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= numbers.length(); i++) {
            perm(array, 0, i, set);
        }
        set.removeIf(item->check(item)==false);//set에서 소수가 아닌 것들은 삭제한다
        return set.size();
    }
    public static void perm(int[] array, int depth, int r, Set<Integer> set) {
        if (depth == r) {
            set.add(makeIntNumber(array,r));
            return;
        }
        for (int i = depth; i < array.length; i++) {
            swap(array, depth, i);
            perm(array, depth + 1, r,set);
            swap(array, depth, i);
        }
    }
    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static boolean check(int num){
        if(num==1 ||num==0){
            return false;
        }
        for(int i = 2;i<num;i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
    public static int makeIntNumber(int[] arr, int k){//숫자로 변경하는 메서드
        int result = 0;
        for(int i=0; i<k; i++){
            result += arr[i] * Math.pow(10, i);
        }
        return result;
    }
}