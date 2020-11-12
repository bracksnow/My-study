package DataStructure;

public class Dp2_solution {
    public static void main(String[] args) {
        int number = 4;
        int[] p = {20,10,5,10};
        int[] f = {3,0,0,0};
        int[] s = new int[number+1];
        s[number] = 0;
        for(int i = number-1;i>0;i--){
            int noskip = p[i];
            if(i+1+f[i]<number){
                noskip+=s[i+1+f[i]];
            }
            int skip = s[i+1];
            s[i] = Math.max(noskip, skip);
        }
        System.out.println(s[1]);
    }

}
