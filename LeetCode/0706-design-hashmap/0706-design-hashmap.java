class MyHashMap {

    private static final int BUCKET_CAPACITY = 100;
    private static Bucket[] buckets;

    private class Bucket {
        Node node;

        public Bucket(Node node) {
            this.node = node;
        }
    }

    private class Node {
        int key;
        int value;
        Node next;

        public Node(int key, int value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public MyHashMap() {
        buckets = new Bucket[10001];
    }
    
    public void put(int key, int value) {
        int index = key / BUCKET_CAPACITY;

        if (buckets[index] == null || buckets[index].node == null) {
            buckets[index] = new Bucket(new Node(key, value, null));
        } else {
            Node node = buckets[index].node;

            while (node != null) {
                if (node.key == key) {
                    node.value = value;
                    return;
                }
                if (node.next == null) {
                    node.next = new Node(key, value, null);
                    return;
                }

                node = node.next;
            }
        }
    }
    
    public int get(int key) {
        int index = key / BUCKET_CAPACITY;

        if (buckets[index] == null) {
            return -1;
        } else {
            Node node = buckets[index].node;

            while (node != null) {
                if (node.key == key) {
                    return node.value;
                }
                node = node.next;
            }
            return -1;
        }
    }
    
    public void remove(int key) {
        int index = key / BUCKET_CAPACITY;

        if (buckets[index] == null) {
            return;
        } else {
            Node node = buckets[index].node;
            Node prev = null;

            while (node != null) {
                if (node.key == key) {
                    if (prev == null) {
                        // 초기 상태일 때를 의미한다.
                        // 리스트가 [10, 20, 30]이고 10을 삭제하는 경우 (prev == null)
                        // buckets[index].node -> 20 -> 30
                        buckets[index].node = node.next;
                    } else {
                        // 리스트가 [10, 20, 30]이고 20을 삭제하는 경우 (prev != null)
                        // buckets[index].node -> 10 -> 20 -> 30
                        // buckets[index].node -> 10 -> 30
                        prev.next = node.next;
                    }
                    return;
                }
                prev = node;
                node = node.next;
            }
        }
    }

}

