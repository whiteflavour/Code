package com.google;

import java.util.*;

public class Solution {
    private Set<String> ans;
    private int[][] dirs;

    public List<String> findWords(char[][] board, String[] words) {
        ans = new HashSet<>();
        dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Trie root = new Trie();
        for (String word : words) {
            root.insert(word);
        }
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                dfs(board, root, i, j, ans);
            }
        }
        return new ArrayList<>(ans);
    }

    public void dfs(char[][] board, Trie node, int row, int col, Set<String> ans) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return;
        }
        char ch = board[row][col];
        if (!node.children.containsKey(ch)) {
            return;
        }
        Trie next = node.children.get(ch);
        if (!"".equals(next.word)) {
            ans.add(next.word);
        }
        if (!next.children.isEmpty()) {
            board[row][col] = '#';
            for (int[] dir : dirs) {
                int i = row + dir[0], j = col + dir[1];
                dfs(board, next, i, j, ans);
            }
            board[row][col] = ch;
        } else {
            node.children.remove(ch);
        }
    }

    class Trie {
        private String word;
        private Map<Character, Trie> children;

        public Trie() {
            word = "";
            children = new HashMap<>();
        }

        public void insert(String word) {
            Trie node = this;
            for (int i = 0; i < word.length(); ++i) {
                char ch = word.charAt(i);
                if (!node.children.containsKey(ch)) {
                    node.children.put(ch, new Trie());
                }
                node = node.children.get(ch);
            }
            node.word = word;
        }
    }
}