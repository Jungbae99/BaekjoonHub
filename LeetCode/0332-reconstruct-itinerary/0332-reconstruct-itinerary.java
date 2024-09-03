class Solution {
    private Map<String, PriorityQueue<String>> map;
    private LinkedList<String> result;

    public List<String> findItinerary(List<List<String>> tickets) {
        map = new HashMap<>();
        result = new LinkedList<>();

        for (List<String> ticket : tickets) {
            map.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
        }

        dfs("JFK");
        return result;
    }

    private void dfs(String airport) {
        PriorityQueue<String> destinations = map.get(airport);
        while (destinations != null && !destinations.isEmpty()) {
            String nextDestination = destinations.poll();
            dfs(nextDestination);
        }
        result.addFirst(airport);
    }
}