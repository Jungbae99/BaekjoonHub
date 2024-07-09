import java.math.BigInteger;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger incrementBy10 = BigInteger.valueOf(1);
        BigInteger num1 = BigInteger.valueOf(0);
        BigInteger num2 = BigInteger.valueOf(0);
        while (l1 != null) {
            num1 = num1.add(BigInteger.valueOf(l1.val).multiply(incrementBy10));
            l1 = l1.next;
            incrementBy10 = incrementBy10.multiply(BigInteger.valueOf(10));
        }

        incrementBy10 = BigInteger.valueOf(1);
        while (l2 != null) {
            num2 = num2.add(BigInteger.valueOf(l2.val).multiply(incrementBy10));
            l2 = l2.next;
            incrementBy10 = incrementBy10.multiply(BigInteger.valueOf(10));
        }
        BigInteger sum = num1.add(num2);
        String sumString = String.valueOf(sum);

        ListNode temp = new ListNode(Character.getNumericValue(sumString.charAt(sumString.length() - 1)));
        ListNode answer = temp;

        for (int i = sumString.length() - 2; i >= 0; i--) {
            temp.next = new ListNode(Character.getNumericValue(sumString.charAt(i)));
            temp = temp.next;
        }

        return answer;
    }
    // 이렇게 하니까... LONG 약 10^19 ..? 를 넘어가네요
    // 더해서 하는건 불가할거같아요.. 라고 생각하고 답지를 봤는데 BigInteger 라는게 있는거에요
    // 그래서 BigInteger 에대해 검색해봤는데 무한대라네요..
}