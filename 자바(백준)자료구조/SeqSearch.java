package DataStructure;

import java.util.Scanner;

public class SeqSearch {
    static int seqSearch(int[] a, int n, int key){
        for(int i = 0;i<n;i++) {
            if (a[i] == key) {
                return i;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

    }
}
