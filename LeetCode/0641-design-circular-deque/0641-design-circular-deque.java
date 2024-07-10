class MyCircularDeque {
 private int[] deque;
    private int size; // queue 의 사이즈
    private int currentSize; // 현재 queue 의 크기
    private int head;
    private int tail;

    public MyCircularDeque(int k) {
        this.deque = new int[k];
        this.size = k;
        this.head = 0;
        this.tail = 0;
        this.currentSize = 0;
    }
    
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        // 원형큐이기 때문에 포인터가 index 밖으로 나갈 일이 없습니다.
        // head, tail 포인터가 점점 돌죠. 굳이 나누자면 head, tail 이 각각 왼쪽, 오른쪽으로 점점 이동하다가 배열의 끝에서 끝점으로 이동

        head = (head - 1 + size) % size;
        deque[head] = value;
        currentSize++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        deque[tail] = value;
        tail = (tail + 1) % size;
        currentSize++;
        return true;
    }
    
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        head = (head + 1) % size;
        currentSize--;
        return true;
    }
    
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        tail = (tail - 1 + size) % size;
        currentSize--;
        return true;
    }
    
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return deque[head];
    }
    
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return deque[(tail - 1 + size) % size];
    }
    
    public boolean isEmpty() {
        // 비어있다면 return true;
        return currentSize == 0;
    }
    
    public boolean isFull() {
        // 현재 용량 == 이 원형큐의 크기라면 return true;
        return currentSize == size;
    }

}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */