class Solution {
    static Map<Integer, List<Integer>> map;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        map = new HashMap<>();

        for (int[] prerequisite : prerequisites) {
            map.computeIfAbsent(prerequisite[0], k -> new ArrayList<>()).add(prerequisite[1]);
        }

        List<Integer> takes = new ArrayList<>();
        List<Integer> taken = new ArrayList<>();
        for (Integer finish : map.keySet()) {
            if (!dfs(finish, takes, taken)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(Integer finish, List<Integer> takes, List<Integer> taken) {
        if (takes.contains(finish)) {
            return false;
        }

        if (taken.contains(finish)) {
            return true;
        }
        
        if (map.containsKey(finish)) {
            takes.add(finish);
            for (Integer take : map.get(finish)) {
                if (!dfs(take, takes, taken)) {
                    return false;
                }
            }
            takes.remove(finish);
            taken.add(finish);
        }
        return true;
    }
}