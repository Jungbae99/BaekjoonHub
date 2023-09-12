class Solution {
    public int solution(int m, int n, String[] board) {
       int answer = 0;
        int tmp = 0;
        String[][] board2 = new String[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                String[] split = board[i].split("");
                board2[i][j] = split[j];
            }
        }
        boolean check[][] = new boolean[m][n];
        boolean flag = true;

        do {
            tmp = 0;
            for (int i = 0; i < m - 1; i++) {
                flag = false;
                for (int j = 0; j < n - 1; j++) {
                    if ( board2[i][j] != null && board2[i][j].equals(board2[i][j + 1])) {
                        if (board2[i][j].equals(board2[i + 1][j]) && board2[i][j + 1].equals(board2[i + 1][j + 1])) {
                            check[i][j] = true;
                            check[i][j + 1] = true;
                            check[i + 1][j] = true;
                            check[i + 1][j + 1] = true;
                            flag = true;
                        }
                    }
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (check[i][j]) {
                        tmp++;
                        board2[i][j] = null;
                        check[i][j] = false;
                    }
                }
            }


            boolean flagSecond = true;

                for (int i = m - 1; i >= 1; i--) {
                    for (int j = 0; j < n; j++) {
                        if (board2[i][j] == null) {
                            for (int k = i; k >= 0; k--) {
                                if (board2[k][j] != null) {
                                    board2[i][j] = board2[k][j];
                                    board2[k][j] = null;
                                    break;
                                }
                            }
                        }
                    }
                }
                
        answer += tmp;
        } while (0 != tmp);

        return answer;
    }
}