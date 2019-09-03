import java.util.*;
public class ex_06 {
    static int total=0;
    static int monthdays[][]=  {
            {31,28,31,30,31,30,31,31,30,31,30,31},   //평년
            {31,29,31,30,31,30,31,31,30,31,30,31} }; //윤년
    static int dates(int year,int month,int date) {   //윤년판단하고, 그해 경과일수
        int years[];
        //static int total=0; 그 해 경과 일수 ###static으로 바꾸면 안되는이유
        if(year%4==0)
            years=monthdays[1];
        else years=monthdays[0];
        int num=0;
        while(num<month-1) {    //q8
            total+=years[num];
            num++;
        }
        total+=date;
        return total;
    }

    static int leftDayofYear(int year,int month, int date) {

        if(year%4==0) return 366-total;
        else return 365-total;
    }

    public static void main(String args[]) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("년:");
        int a=scanner.nextInt();
        System.out.println("월:");
        int b=scanner.nextInt();
        System.out.println("일:");
        int c=scanner.nextInt();
        System.out.println("그해의"+dates(a,b,c)+"번째 해 입니다.");
        System.out.println("그해의"+leftDayofYear(a,b,c)+"남은 일 수 입니다.");
    }



}
