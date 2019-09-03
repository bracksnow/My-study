package DataStructure;

public class IntSet {
    private int max; //집합의 최대갯수
    private int num; //집합의 요소의 갯수
    private int[] set; //집합 본체

    public IntSet(int capacity) {
        num = 0;
        max = capacity;
        try{
            set = new int[capacity];
        }catch(OutOfMemoryError e){
            max = 0;
        }
    }
    //최대 갯수
    public int capacity(){
        return max;
    }
    //현재 갯수
    public int size(){
        return num;
    }
    public int indexOf(int n){
        for(int i = 0;i<set.length;i++){
            if(set[i]==n){
                return n;
            }
        }
        return -1;
    }
    public boolean contain(int n){
        if(indexOf(n) != -1){
            return true;
        }
        return false;
    }
    public void add(int n){
        if(num>=max || contain(n)==true){
            System.out.println("추가 할 수 없습니다");
        }else{
            set[num++] = n;
        }
    }
    public void remove(int n){
        int idx = 0;
        if(num<=0 || indexOf(n)==-1){
            System.out.println("삭제할 수 없습니다");
        }else{
            set[idx] = set[--num];
            System.out.printf("%d를 삭제했습니다",n);
        }
    }
}
