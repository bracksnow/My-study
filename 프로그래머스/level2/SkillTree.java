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
        int answer = skill_trees.length;
        for(int i = 0;i< skill_trees.length;i++){
            if(skill.indexOf(skill_trees[i].replaceAll("[^"+skill+"]",""))!=0){
                answer--;
            }
        }
        return answer;
    }
}
