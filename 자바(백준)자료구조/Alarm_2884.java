package DataStructure;

import java.util.Scanner;

public class Alarm_2884 {
    public static void main(String[] args) {
        Scanner sc  =  new Scanner(System.in);
        String time = sc.nextLine();
        String[] time_convert = time.split("\\s");
        int h = Integer.parseInt(time_convert[0]);
        int m = Integer.parseInt(time_convert[1]);
        if(h==0){
            if(m>=45){
                System.out.printf("%d %d",h,m);
            }else{
                h = 23;
                m = 60-(45-m);
                System.out.printf("%d %d",h,m);
            }
        }else{
            if(m>=45){
                System.out.printf("%d %d",h,m);
            }else{
                h = h-1;
                m = 60-(45-m);
                System.out.printf("%d %d",h,m);
            }
        }
    }
}
