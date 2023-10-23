class Solution {
    public int solution(String[] board) {
       int answer = 1;
        int oCount = 0;
        int xCount = 0;
        char[][] charBoard = new char[3][3];

        for (int i = 0; i < 3; i++) {
            char[] charArray = board[i].toCharArray();
            for (int j = 0; j < 3; j++) {
                charBoard[i][j] = charArray[j];
                if (charBoard[i][j] == 'X') {
                    xCount++;
                } else if (charBoard[i][j] == 'O') {
                    oCount++;
                }
            }
        }
        // X개수 > O개수
        if (xCount > oCount) {
            answer = 0;
        }

        if (oCount > xCount + 1) {
            answer = 0;
        }

        // 일자일때
        for (int i = 0; i < 3; i++) {
            if (charBoard[i][0] == charBoard[i][1] && charBoard[i][1] == charBoard[i][2]) {
                if (charBoard[i][0] == 'O') {
                    if (xCount >= oCount) {
                        answer = 0;
                    }
                } else if (charBoard[i][0] == 'X') {
                    if (oCount > xCount) {
                        answer = 0;
                    }
                }
            }
            if (charBoard[0][i] == charBoard[1][i] && charBoard[1][i] == charBoard[2][i]) {
                if (charBoard[0][i] == 'O') {
                    if (xCount >= oCount) {
                        answer = 0;
                    }
                } else if (charBoard[0][i] == 'X') {
                    if (oCount > xCount) {
                        answer = 0;
                    }
                }
            }
        }

        // 대각선일때
        if (charBoard[0][0] == charBoard[1][1] && charBoard[1][1] == charBoard[2][2]) {
            if (charBoard[0][0] == 'O') {
                if (xCount >= oCount) {
                    answer = 0;
                }
            } else if (charBoard[0][0] == 'X') {
                if (oCount > xCount) {
                    answer = 0;
                }
            }
        }
         if (charBoard[0][2] == charBoard[1][1] && charBoard[1][1] == charBoard[2][0]) {
            if (charBoard[0][2] == 'O') {
                if (xCount >= oCount) {
                    answer = 0;
                }
            } else if (charBoard[0][2] == 'X') {
                if (oCount > xCount) {
                    answer = 0;
                }
            }
        }
        
        return answer;
    }
}