package com.google;

import java.util.*;

public class Solution {
    private Trie root;

    public WordDictionary() {
        root = new Trie();
    }

    public void addWord(String word) {
        root.insert(word);
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private class Trie {
        private Trie[] children;
        private boolean isEnd;

        public Trie() {
            children = new Trie[26];
            isEnd = false;
        }

        public void insert(String word) {
            Trie node = this;
            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new Trie();
                }
                node = node.children[index];
            }
            node.isEnd = true;
        }
    }

    public boolean dfs(String word, int index, Trie node) {
        if (index == word.length()) {
            return node.isEnd;
        }
        char ch = word.charAt(index);
        if (Character.isLetter(ch)) {
            int childIndex = ch - 'a';
            Trie child = node.children[childIndex];
            return child != null && dfs(word, index + 1, child);
        } else {
            for (int i = 0; i < 26; ++i) {
                Trie child = node.children[i];
                if (child != null && dfs(word, index + 1, child)) {
                    return true;
                }
            }
        }
        return false;
    }
}