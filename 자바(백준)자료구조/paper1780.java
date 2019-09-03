package DataStructure;

import java.util.Scanner;

public class paper1780 {
    static String[][] paper;
    static int zero = 0;
    static int minus = 0;
    static int plus = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        paper = new String[num][num];
        for (int i = 0; i < num; i++) {
            for(int j = 0;j<num;j++){
                paper[i][j] = sc.next();
            }
        }
        paper(0, 0, num);
        System.out.println(minus);
        System.out.println(zero);
        System.out.println(plus);


    }
    public static boolean checker(int row, int col, int size) {
        String target = paper[row][col];
        boolean answer = true;
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (target != paper[i][j]) {
                    answer = false;
                }
            }
        }
        return answer;
    }
    public static void paper(int row, int col, int size) {
        String target1 = paper[row][col];
        if(checker(row,col,size)) {
            for (int i = row; i < row + size; i++) {
                for (int j = col; j < col + size; j++) {
                    if (target1.equals(paper[i][j])) {
                        if (target1.equals("1")) {
                            ++plus;
                        } else if (target1.equals("-1")) {
                            ++minus;
                        } else if(target1.equals("0")) {
                            ++zero;
                        }

                    }

                }
            }
        }else{
            int newsize = size/3;
            paper(row,col,newsize);
            paper(row,col+newsize,newsize);
            paper(row,col+newsize+newsize,newsize);
            paper(row+newsize,col,newsize);
            paper(row+newsize,col+newsize,newsize);
            paper(row+newsize,col+newsize+newsize,newsize);
            paper(row+newsize+newsize,col,newsize);
            paper(row+newsize+newsize,col+newsize,newsize);
            paper(row+newsize+newsize,col+newsize+newsize,newsize);

        }
    }
}

