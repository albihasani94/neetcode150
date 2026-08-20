package com.albin.neetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <a href="https://neetcode.io/problems/valid-sudoku/question?list=neetcode150">NeetCode: Valid Sudoku</a>
 */
public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Integer>> cols = new HashMap<>();
        Map<Integer, Set<Integer>> rows = new HashMap<>();
        Map<String, Set<Integer>> squares = new HashMap<>();

        for (int i = 0; i < board.length; i++) { // rows
            for (int j = 0; j < board.length; j++) { // cols
                if (board[i][j] == '.') continue;
                int value = board[i][j];

                String squareKey = (i / 3) + "," + (j / 3);

                if (rows.computeIfAbsent(i, k -> new HashSet<>()).contains(value) ||
                        cols.computeIfAbsent(j, k -> new HashSet<>()).contains(value) ||
                        squares.computeIfAbsent(squareKey, k -> new HashSet<>()).contains(value)) {
                    return false;
                }

                rows.get(i).add(value);
                cols.get(j).add(value);
                squares.get(squareKey).add(value);
            }
        }

        return true;
    }
}
