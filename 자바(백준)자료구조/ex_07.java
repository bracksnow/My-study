package DataStructure;

//93p q10~11 연습문제
import java.util.*;
import java.math.*;
//갱신되는 사람 수

public class ex_07 {     //############ class ex_07과 Pysical을 따로쓰면 안되는이유?
    static class Pysical {
        static final int eyes = 21; //시력검사는 0.1차이로 21까지 있다.
        String name;
        int height;
        double myeye;

        public Pysical(String name, int height, double myeye) {  //생성자
            this.name = name;
            this.height = height;
            this.myeye = myeye;
        }

        public static double averheight(Pysical member[], int count) {     //평균키 구하기
            double sum = 0;
            for (int i = 0; i < count; i++) {
                sum += member[i].height;
            }
            return sum / count;
        }
        public static void distVision(Pysical member[], int count)              //시력분포
        {
            double bunpo[] = new double[eyes];
            for (int i = 0; i < eyes; i++) {
                double eyenum;
                eyenum = Math.round((0.1 * i) * 10) / 10.0; //소수점 첫째짜리 까지
                bunpo[i] = 0;           //bunpo[0]=0.0, bunpo[1]=0.1 의미하고 실제 들어가는 값은 '명'수
                for (int j = 0; j < count; j++) {
                    if (eyenum == member[j].myeye)
                        bunpo[i]++;
                }
            }
            System.out.println("시력 분포");
            for (int i = 0; i < eyes; i++) {
                System.out.println(Math.round((0.1 * i) * 10) / 10.0 + "~: " + bunpo[i] + "명");
            }


        }


        public static void main(String[] args) {
            System.out.println("이름,키,시력-형식으로 입력해주세요.그만 입력하려면 'q'를 눌러주세요.(제한 100명)");
            int count = 0;
            ex_07.Pysical Pysicals[] = new ex_07.Pysical[100];
            int z = 0;
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("이름  키  시력");
                System.out.println();
                String name = scanner.next();
                if (name.charAt(0) == 'q') {
                    System.out.println("종료합니다.");
                    break;
                } else {
                    int height = scanner.nextInt();
                    double myeye = scanner.nextDouble();
                    Pysicals[z++] = new ex_07.Pysical(name, height, myeye);
                    count++;
                    System.out.println("ㅁ---신체검사 리스트---ㅁ");
                    System.out.println("이름              키             시력");
                    System.out.println("____________________");
                    for (int i = 0; i < count; i++) {
                        System.out.println(Pysicals[i].name + "       " + Pysicals[i].height + "     " + Pysicals[i].myeye);
                    }

                    System.out.println("평균키: " + Pysical.averheight(Pysicals, count));

                    Pysical.distVision(Pysicals, count);

                }


            }
        }
    }
}