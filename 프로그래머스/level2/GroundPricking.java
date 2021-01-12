package DataStructure;


//dp문제 이전 열에서 가능한 것들의 최대값을 선택한다
public class GroundPricking {
    int solution(int[][] land) {
        int answer = 0;
        int target = land.length;
        for(int i = 1;i< land.length;i++){
            land[i][0] += Math.max(land[i-1][1], Math.max(land[i-1][2], land[i-1][3]));
            land[i][1] += Math.max(land[i-1][0], Math.max(land[i-1][2], land[i-1][3]));
            land[i][2] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][3]));
            land[i][3] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][2]));
        }
        answer = Math.max(land[target-1][0],Math.max(land[target-1][1], Math.max(land[target-1][2], land[target-1][3])));
        return answer;
    }
}
