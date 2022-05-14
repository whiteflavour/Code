package com.google;

public class Solution {
    private static final int[] DIRECTIONS = {0, 1, -1};

    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        for (int row = 0; row < m; ++row) {
            for (int col = 0; col < n; ++col) {

                int liveNeighbors = 0;
                for (int i = 0; i < 3; ++i) {
                    for (int j = 0; j < 3; ++j) {
                        if (!(DIRECTIONS[i] == 0 && DIRECTIONS[j] == 0)) {
                            int r = row + DIRECTIONS[i];
                            int c = col + DIRECTIONS[j];
                            if (!(r < 0 || c < 0 || r >= m || c >= n) && Math.abs(board[r][c]) == 1) {
                                ++liveNeighbors;
                            }
                        }
                    }
                }

                if (board[row][col] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[row][col] = -1;
                }
                if (board[row][col] == 0 && liveNeighbors == 3) {
                    board[row][col] = 2;
                }
            }
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                board[i][j] = board[i][j] > 0 ? 1 : 0;
            }
        }
    }
}