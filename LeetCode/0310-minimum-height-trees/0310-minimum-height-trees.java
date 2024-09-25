class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

                if (n == 1) { // n 이 1일때 NPE
            return List.of(0);
        }

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], g -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], g -> new ArrayList<>()).add(edge[0]);
        }

        List<Integer> remove = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (graph.get(i).size() == 1) remove.add(i);
            // 노드의 번호를 저장
        }

        while (n > 2) {
            n -= remove.size();
            List<Integer> newRemove = new ArrayList<>();

            for (Integer removeNode : remove) {
                int nextNode = graph.get(removeNode).get(0); // 리프노드와 이어진 노드
                graph.get(nextNode).remove(removeNode);
                if (graph.get(nextNode).size()==1) newRemove.add(nextNode);
            }
            remove = newRemove;
        }

        return remove;
    }
}