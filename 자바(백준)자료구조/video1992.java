package DataStructure;
import java.util.Arrays;
import java.util.Scanner;

public class video1992 {
    public static char[][] QuadTree;
    public static StringBuffer answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        QuadTree = new char[num][num];
        answer = new StringBuffer();
        for (int i = 0; i < num; i++) {
            QuadTree[i] = sc.next().toCharArray();
        }
        srcQuadTree(0,0,num);
        System.out.print(answer);
    }
    public static boolean checker(int row, int col, int size){
        char target = QuadTree[row][col];
        for(int i = row;i<row+size;i++){
            for(int j = col;j<col+size;j++){
                if(target!=QuadTree[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
    public static void srcQuadTree(int row, int col, int size) {
        if(checker(row, col, size)) {
            answer.append(QuadTree[row][col]);
        }else {
            answer.append("(");
            int newSize = size/2;
            srcQuadTree(row, col, newSize);
            srcQuadTree(row, col + newSize, newSize);
            srcQuadTree(row + newSize, col, newSize);
            srcQuadTree(row + newSize, col + newSize, newSize);
            answer.append(")");
        }
    }
}




