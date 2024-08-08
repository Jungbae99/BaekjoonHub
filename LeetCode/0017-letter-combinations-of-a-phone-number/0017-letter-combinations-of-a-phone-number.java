class Solution {
 static Map<Character, char[]> phone = new HashMap<>();

    static {
        phone.put('2', new char[]{'a', 'b', 'c'});
        phone.put('3', new char[]{'d', 'e', 'f'});
        phone.put('4', new char[]{'g', 'h', 'i'});
        phone.put('5', new char[]{'j', 'k', 'l'});
        phone.put('6', new char[]{'m', 'n', 'o'});
        phone.put('7', new char[]{'p', 'q', 'r', 's'});
        phone.put('8', new char[]{'t', 'u', 'v'});
        phone.put('9', new char[]{'w', 'x', 'y', 'z'});
    }

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return new ArrayList<>();

        Set<String> result = new HashSet<>();
        backTracking(digits, 0, new StringBuilder(), result);
        return new ArrayList<>(result);
    }


    private void backTracking(String digits, int index, StringBuilder current, Set<String> result) {

        if (index == digits.length()) { // index 가 처음주어진 문자열에 도달하면 return 해준다
            result.add(current.toString());
            return;
        }

        char digit = digits.charAt(index);
        char[] letters = phone.get(digit); // 숫자에 대응하는 문자열들

        for (char letter : letters) { // 문자열들만큼 같은 레벨을 탐색한다.
            current.append(letter); // 같은 레벨에서 하나씩 StringBuilder add 해준다
            backTracking(digits, index + 1, current, result);
            current.deleteCharAt(current.length() - 1);
        }

    }

}