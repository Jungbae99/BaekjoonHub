class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> row = new HashSet<>();
        HashSet<String> column = new HashSet<>();
        HashSet<String> box = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char cur = board[i][j];
                if (cur != '.') {
                    // 이미 있으면 set 은 false 반환
                    if (!row.add(cur + "" + i)) {
                        return false;
                    }
                    if (!column.add(cur + "" + j)) {
                        return false;
                    }
                    if (!box.add(cur + "" +  i / 3 + "," + j / 3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}