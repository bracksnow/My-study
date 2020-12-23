package DataStructure;

public class JoyStick {
    public int solution(String name) {
        int answer = 0;
        //글자를 바꾸는 경우
        for(int i = 0;i<name.length();i++){
            if(name.charAt(i)!='A'){
                int up = name.charAt(i)-'A';
                int down = 'Z'-name.charAt(i)+1;//만약 U로 이동한다면 Z-U에 A기준이기 때문에 +1을 함
                if(down>up){
                    //아래로 움직이는 경우가 더 큰경우에는 위로 움직이는 것을 선택해야한다
                    answer+=up;
                }else{
                    answer+=down;
                }
            }
        }
        //커서를 이동하는 경우
        int min = name.length() - 1;//단순하게 움직이는 경우
        for(int i = 0 ; i < name.length() ; i++) {
            if(name.charAt(i) != 'A') {
                int next = i+1;
                while(next < name.length() && name.charAt(next) == 'A') {
                    next++;
                }
                int move = 2 * i + name.length() - next;
                min = Math.min(move, min);
            }
        }
        return answer+min;
    }
}
