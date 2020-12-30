package DataStructure;

public class QuadCount {
    static int one = 0;
    static int zero = 0;
    public int[] solution(int[][] arr) {
        int[] answer = {one, zero};
        recursive(arr, arr.length,0,0);
        return answer;
    }
    public void recursive(int[][] arr,int length, int x, int y){
        if(length==1) {
            if(arr[x][y]==1){
                one++;
            }else{
                zero++;
            }
        }else{
            if(isSame(arr, length,x,y)){
                return;
            }
        }
        recursive(arr, length/2, x, y);
        recursive(arr, length/2, x+length/2, y);
        recursive(arr, length/2, x, y+length/2);
        recursive(arr, length/2, x+length/2, y+length/2);
    }
    public boolean isSame(int[][] arr, int length, int x, int y){
        int target = arr[x][y];
        for(int i = x;i<x+length;i++){
            for(int j = y;j<y+length;j++){
                if(target!=arr[x][y]){
                    return false;
                }
            }
        }
        if(target==0){
            zero++;
        }else{
            one++;
        }
        return true;
    }
}
