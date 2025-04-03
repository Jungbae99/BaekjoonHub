class Solution {
    public int findContentChildren(int[] g, int[] s) {
        // 아이들의 탐욕 지수와 쿠키 크기를 정렬
        Arrays.sort(g);
        Arrays.sort(s);
        
        int childIndex = 0; // 현재 고려 중인 아이의 인덱스
        int cookieIndex = 0; // 현재 고려 중인 쿠키의 인덱스
        
        // 아이들과 쿠키를 하나씩 확인
        while (childIndex < g.length && cookieIndex < s.length) {
            // 현재 쿠키가 현재 아이의 탐욕 지수를 충족하는지 확인
            if (s[cookieIndex] >= g[childIndex]) {
                // 충족하면 아이에게 쿠키 할당하고 다음 아이로 이동
                childIndex++;
            }
            // 다음 쿠키로 이동 (충족하든 안하든 현재 쿠키는 사용했거나 사용할 수 없음)
            cookieIndex++;
        }
        
        // 만족한 아이들의 수 반환
        return childIndex;
    }
}