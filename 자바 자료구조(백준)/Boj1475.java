package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String roomnumber = bf.readLine();
        int[] card = new int[10];
        int max = 0;
        for(int i = 0;i<roomnumber.length();i++){
            card[roomnumber.charAt(i)-'0']+=1;//아스크코드를 사용함
        }
        int temp = (card[6] + card[9]);
        if (temp % 2 == 0) {
            card[6]=temp/2;
            card[9]=temp/2;
        }
        else {
            card[6]=temp/2+1;
            card[9]=temp/2+1;
        }
        for (int i : card) {
            max = Math.max(max, i);
        }
        System.out.println(max);

    }
}
