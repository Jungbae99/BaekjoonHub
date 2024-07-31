class Trie {

    // 1. 인스턴스 변수 자료구조는 해시맵(key : 문자, value : 노드)
    private TrieNode root;

    private class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEndOfWord;

        public TrieNode() {
            this.children = new HashMap<>();
            this.isEndOfWord = false; // false로 초기화
        }
    }

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;

        for (char ch : word.toCharArray()) {
            // 없으면 노드를 생성, 있으면 기존노드 반환 
            current = current.children.computeIfAbsent(ch, c -> new TrieNode());   
        }
        current.isEndOfWord = true;
        // 이러면 apple 에서 
        // a -> p -> p -> l -> e 라는 노드가 저장되었음 e라는 노드는 endOfWord = true
    }

    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        // 완벽한 검색 메서드는, endOfWord까지 검증을 해줘야함.
        if (node != null && node.isEndOfWord) {
            return true;
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        // 그러나 접두사만 검색하는 메서드는 endOfWord를 검증할 필요가없음
        return searchPrefix(prefix) != null;
    }

    private TrieNode searchPrefix(String prefix) {
        TrieNode current = root;
        for (char ch : prefix.toCharArray()) {
            TrieNode node = current.children.get(ch);

            if (node == null) {
                // 해당 문자열에대한 노드가 없다면 null , 해당접두사가 트라이에 없다.
                return null;
            }
            current = node; // 이동
        }
        // 모든 문자를 순회했는데, 전부 존재한다면? 접두사가 있다.
        return current;
    }
}
