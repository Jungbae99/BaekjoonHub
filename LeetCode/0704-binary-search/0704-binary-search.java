class Solution {
    public int search(int[] num, int target) {
       return binarySearch(0, num.length-1, target, num);
    }

    private static int binarySearch(int left, int right, int target, int[] num) {
        if (left <= right) {
            int mid = left + (right - left) / 2;
            if (num[mid] == target) {
                return mid;
            }
            if (num[mid] > target) {
                return binarySearch(left, mid - 1, target, num);
            } else {
                return binarySearch(mid + 1, right, target, num);
            }

        } else {
            return -1;
        }
    }
}