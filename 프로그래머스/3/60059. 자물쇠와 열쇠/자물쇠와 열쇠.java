class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int keySize = key.length;
        int lockSize = lock.length;
        int boardSize = lockSize + keySize * 2;

        int[][] board = new int[boardSize][boardSize];

        for (int i = 0; i < lockSize; i++) {
            for (int j = 0; j < lockSize; j++) {
                board[i + keySize][j + keySize] = lock[i][j];
            }
        }

        for (int r = 0; r < 4; r++) {
            key = rotate(key); 

            for (int x = 0; x <= boardSize - keySize; x++) {
                for (int y = 0; y <= boardSize - keySize; y++) {

                    for (int i = 0; i < keySize; i++) {
                        for (int j = 0; j < keySize; j++) {
                            board[x + i][y + j] += key[i][j];
                        }
                    }

                    if (check(board, keySize, lockSize)) {
                        return true;
                    }

                    for (int i = 0; i < keySize; i++) {
                        for (int j = 0; j < keySize; j++) {
                            board[x + i][y + j] -= key[i][j];
                        }
                    }
                }
            }
        }

        return false;
    }

    int[][] rotate(int[][] key) {
        int n = key.length;
        int[][] rotated = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][n - 1 - i] = key[i][j];
            }
        }
        return rotated;
    }

    boolean check(int[][] board, int offset, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i + offset][j + offset] != 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
