class Solution {
  public int findKthLargest(int[] nums, int k) {
        Integer[] integerArray = Arrays.stream(nums)  // int[] 배열을 Integer[]로 변환합니다.
                .boxed()  // 각 요소를 Integer 래퍼로 박싱합니다.
                .toArray(Integer[]::new);  // Integer[]로 변환합니다.

        Arrays.sort(integerArray, Comparator.reverseOrder());  // 내림차순으로 정렬합니다.

        return integerArray[k-1];  // k번째로 큰 요소를 반환합니다.
    }
}