/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode root = new ListNode();
        ListNode pointer = root; // 항상 움직인다.


        // head 가 4야.
        // 1(p), 5, 10
        while (head != null) {
            while (pointer.next != null && pointer.next.val < head.val) {
                pointer = pointer.next;
            }
            // 이제 head 를 떼어서 여기에 붙여아함.
            ListNode headNext = head.next;
            ListNode pNext = pointer.next;

            pointer.next = head;
            head.next = pNext;
            head = headNext;

            if (head != null && pointer.val > head.val) {
                pointer = root; // 굳이 다음번 반복에 정렬이 필요하지 않다면, 앞으로 돌릴 필요가 없다.
            }        }

        return root.next;
    }

}