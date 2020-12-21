package DataStructure;

import java.util.LinkedList;
import java.util.Queue;
public class SkillTree {
    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_trees = {"BACDE","CBADF","AECB", "BDA"};
        System.out.println(solution(skill, skill_trees));
    }
    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Queue<String> queue = new LinkedList<String>();
        for(int i = 0;i<skill.length();i++){
            queue.add(skill.substring(i, i+1));
        }//큐에 skill문자열을 잘라서 넣음
        int fanswer = 1;
        while(!queue.isEmpty()){
            int count = 0;
            String startAlphabet = queue.poll();//앞에 있는 것부터 나와야하기 때문에 큐로 자료구조 선정
            for(int i = 0;i<skill_trees.length;i++){
                String compareAlphabet = skill_trees[i].substring(0,1);
                if(startAlphabet.equals(compareAlphabet)) {
                    count++;
                }
                else{
                    count = 1;
                }
            }
            fanswer*=count;
        }
        if(fanswer==1){
            return answer;
        }else{
            return fanswer;
        }
    }
}
