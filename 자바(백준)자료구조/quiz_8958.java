package DataStructure;

import java.util.Scanner;

public class quiz_8958 {
    public static int checker(char[] test){
        int sum = 0;
        int num = 0;
        for(int index = 0;index<test.length;index++){
            if(test[index]=='O'){
                num++;
                sum+=num;
            }else if(test[index]=='X'){
                num=0;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        for(int i = 0;i<count;i++){
            char[] test = sc.next().toCharArray();
            System.out.println(checker(test));
        }

    }
}
