import java.util.*;

class Solution {
    static Queue<Character> skillQueue;
    static Queue<Character> treeQueue;
    
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (int i = 0; i < skill_trees.length; i++) {
            if (check(skill, skill_trees[i])) {
                answer ++;
            }
        }
        return answer;
    }
    private static boolean check(String skill, String skillTree) {
        skillQueue = new LinkedList<>();
        treeQueue = new LinkedList<>();

        char[] charArray = skill.toCharArray();
        char[] treeArray = skillTree.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            skillQueue.add(charArray[i]);
        }

        for (int i = 0; i < skillTree.length(); i++) {
            treeQueue.add(treeArray[i]);
        }

        for (int i = 0; i < skillTree.length(); i++) {
            char currentSkill = treeQueue.poll();
            if (skillQueue.contains(currentSkill)) {
                if (currentSkill != skillQueue.peek()) {
                    return false;
                } else {
                    skillQueue.poll();
                }
            }
        }
        return true;
    }
}