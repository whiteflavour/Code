package com.google;

import java.util.*;

public class Solution {
    private Trie[] children;
    private boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        for (int i = 0; i < word.length(); ++i) {
            char ch = word.charAt(i);
            Trie child = children[ch - 'a'];
            if (child == null) {
                child = new Trie();
            }
            this.children[ch - 'a'] = child;
        }
        isEnd = true;
    }

    public boolean search(String word) {
        for (int i = 0; i < word.length(); ++i) {
            char ch = word.charAt(i);
            Trie child = children[ch - 'a'];
            if (child == null) {
                return false;
            }
            this.children[ch - 'a'] = child;
        }
        return isEnd;
    }

    public boolean startsWith(String prefix) {
        for (int i = 0; i < prefix.length(); ++i) {
            char ch = prefix.charAt(i);
            Trie child = children[ch - 'a'];
            if (child == null) {
                return false;
            }
            this.children[ch - 'a'] = child;
        }
        return true;
    }
}