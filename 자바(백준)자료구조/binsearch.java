package DataStructure;

import java.util.Scanner;

public class binsearch {
    static int binsearch(int[] a, int n, int key){
        int start = 0;
        int end = n-1;
        int middle = (start+end)/2;
        while(a[middle]!=key){
            if(a[middle]<key){
                start = middle+1;
            }else if(a[middle]>key){
                end = middle-1;
            }

        }
        return middle;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("요솟수를 입력하시오");
        int num = sc.nextInt();
        int[] x = new int[num];

        System.out.println("오름차순으로 입력하시오");
        for(int i = 0;i<num;i++){
            x[i] = sc.nextInt();
        }
        System.out.println("키값을 입력하시오");
        int key = sc.nextInt();
        int idx  = binsearch(x,num,key);
        if(key==x[idx]){
            System.out.println(idx);
        }

    }
}
