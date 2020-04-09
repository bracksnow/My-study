package DataStructure;

public class permutation {
    public static void main(String[] args) {
        int[] array = {1,2,3,4};
        perm(array,0,4,4);
    }
    public static void perm(int[] array, int depth, int n, int r){
        if(depth==r){
            return;
        }
        for (int i=depth; i<n; i++) {
            swap(array, depth, i);//처음에 돌릴 경우에는 첫 번째 인덱스와 첫 번째 인덱스를 바꾸는 역할을 한다
            perm(array, depth + 1, n, r);//예시로 첫 번째 돌린 것을 제외하고 재귀를 통해 두 번쩨 인덱스부터 swap한다.
            swap(array, depth, i);//앞에서 swap한 것을 원상태로 돌리는 역할을 한다
        }
    }


    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
