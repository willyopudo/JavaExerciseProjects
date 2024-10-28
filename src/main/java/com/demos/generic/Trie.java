package com.demos.generic;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    private final TrieNode root;

    // Constructor initializes the root node of the Trie
    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the Trie
    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            // If the character is not present, add it as a new node
            node.children.putIfAbsent(ch, new TrieNode());
            // Move to the next node
            node = node.children.get(ch);
        }
        node.isEndOfWord = true;
    }

    // Searches for a word in the Trie
    public boolean search(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            // If character is not found, the word doesn't exist
            if (!node.children.containsKey(ch)) {
                return false;
            }
            // Move to the next node
            node = node.children.get(ch);
        }
        // Check if this node is marked as the end of a word
        return node.isEndOfWord;
    }

    // Checks if any word in the Trie starts with the given prefix
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            // If character is not found, no word with this prefix exists
            if (!node.children.containsKey(ch)) {
                return false;
            }
            // Move to the next node
            node = node.children.get(ch);
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));   // true
        System.out.println(trie.search("app"));     // false
        System.out.println(trie.startsWith("app")); // true

        trie.insert("app");
        System.out.println(trie.search("app"));     // true
    }
}

class TrieNode {
    // Boolean flag to indicate if this node is the end of a word
    boolean isEndOfWord;
    // HashMap to store child nodes with character keys
    Map<Character, TrieNode> children;

    // Constructor initializes the HashMap for children
    public TrieNode() {
        isEndOfWord = false;
        children = new HashMap<>();
    }
}
