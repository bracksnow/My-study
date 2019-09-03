package DataStructure;
import java.util.Scanner;

public class quick_sort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] number = new int[count];
        for(int i = 0;i<count;i++){
            number[i] = sc.nextInt();
        }
        quick(number,0,count-1);
        for(int SortedNumber:number){
            System.out.println(SortedNumber);
        }
    }

    public static void quick(int[] number, int left, int right) {
        int pl = left;
        int pr = right;
        int pivot = number[(left+right)/2];
        do{
            while(number[pl]<pivot)
                pl++;
            while(number[pr]>pivot)
                pr--;
            if(pl<=pr){
                swap(number,pl++,pr--);
            }
        }while(pl<=pr);
        if(left<pr){
            quick(number,left,pr);
        }
        if(pl<right){
            quick(number,pl,right);
        }
    }
    public static void swap(int array[], int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
