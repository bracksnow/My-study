package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj6359 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bf.readLine());
        while(count-->0){
            int room_count = Integer.parseInt(bf.readLine());
            int[] room = new int[room_count+1];
            room[0] = -1;//계산하지 않을 인덱스
            for(int i = 1;i<=room_count;i++){
                for(int j = 1;i*j<=room_count;j++){
                    if(room[i*j]==0){
                        room[i*j] = 1;
                    }else if(room[i*j]==1){
                        room[i*j] = 0;
                    }
                }
            }
            int answer = 0;
            for(int num = 1;num<=room_count;num++){
                if(room[num]==1){
                    answer++;
                }
            }
            System.out.println(answer);
        }
    }
}
