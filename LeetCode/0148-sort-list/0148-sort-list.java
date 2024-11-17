class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode half = null, slow = head, fast = head;

        while (fast != null && fast.next != null) {
            half = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        half.next = null;

        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        return mergeToNode(l1, l2);
    }

    private ListNode mergeToNode(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val > l2.val) {
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }

        l1.next = mergeToNode(l1.next, l2);

        return l1;
    }

}