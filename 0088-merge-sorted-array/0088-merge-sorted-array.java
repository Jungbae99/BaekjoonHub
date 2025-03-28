class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int counter = nums1.length - 1;

        for (int i = nums2.length - 1; i >= 0; i--) {
            if (nums1[counter] != 0)
                break;

            if (nums1[counter] == 0) {
                nums1[counter] = nums2[i];
            }
            counter--;
        }

        Arrays.sort(nums1);
    }
}