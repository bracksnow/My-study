package DataStructure;

public class Keypard {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int leftStart = 10;//*을 의미함
        int rightStart = 12;//#을 의미함
        for(int i = 0;i< numbers.length;i++){
            if(numbers[i]==1||numbers[i]==4||numbers[i]==7){//1,4,7의 경우
                answer.append('L');
                leftStart = numbers[i];
            }else if(numbers[i]==3||numbers[i]==6||numbers[i]==9){//3,6,9의 경우
                answer.append('R');
                rightStart = numbers[i];
            }else{
                int leftLength = getDistance(leftStart, numbers[i]);
                int rightLength = getDistance(rightStart, numbers[i]);
                if(leftLength>rightLength){
                    answer.append('R');
                    rightStart = numbers[i];
                }
                else if(leftLength<rightLength){
                    answer.append('L');
                    leftStart = numbers[i];
                }else{
                    if(hand.equals("right")){
                        answer.append('R');
                        rightStart = numbers[i];
                    }else{
                        answer.append('L');
                        leftStart = numbers[i];
                    }
                }
            }
           
        }
        return answer.toString();
    }
    public static int getDistance(int start, int number){
        start = (start == 0) ? 11 : start;
        number = (number == 0) ? 11 : number;
        int x = (start-1)/3;
        int y = (start-1)%3;
        int newX = (number-1)/3;
        int newY = 1;
        return Math.abs(x-newX)+Math.abs(y-newY);
    }
}
