package com.example.studyDemo.cases.ths;

/**
 * @Author: hao wu
 * @Date： 2023/2/24 17:42
 * 先读取文件中的每个单词，并插入到Trie树中。插入操作中，对于每个单词，从根节点开始遍历Trie树
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

class TrieNode {
    boolean isEndOfWord;
    HashMap<Character, TrieNode> children;

    TrieNode() {
        isEndOfWord = false;
        children = new HashMap<>();
    }
}

class DictionarySearcher {
    private TrieNode root;

    public DictionarySearcher(String filename) {
        root = new TrieNode();
        // 读取文件中的每个单词，并插入到Trie树中
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String word;
            while ((word = br.readLine()) != null) {
                insert(word);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new TrieNode());
            }
            curr = curr.children.get(c);
        }
        curr.isEndOfWord = true;
    }

    public HashMap<String, ArrayList<Integer>> search(String document) {
        HashMap<String, ArrayList<Integer>> result = new HashMap<>();
        for (int i = 0; i < document.length(); i++) {
            TrieNode curr = root;
            for (int j = i; j < document.length(); j++) {
                char c = document.charAt(j);
                if (!curr.children.containsKey(c)) {
                    break;
                }
                curr = curr.children.get(c);
                if (curr.isEndOfWord) {
                    String word = document.substring(i, j + 1);
                    if (!result.containsKey(word)) {
                        result.put(word, new ArrayList<>());
                    }
                    result.get(word).add(i);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        DictionarySearcher searcher = new DictionarySearcher("D:\\hooscope\\Java_WorkSpace\\StudyDemo\\src\\main\\java\\com\\example\\studyDemo\\cases\\ths\\input_file.txt");
        String document = "美国规划协会中国办公室揭牌仪式及美国规划领域合作研讨会在浙江大学城乡规划设计研究院208会议室举行。美国规划协会CEO James Drinan，国际项目及外联主任Jeffrey Soule先生，浙江大学党委副书记任少波，浙江大学控股集团领导杨其和，西湖区政府代表应权英副主任....";
        HashMap<String, ArrayList<Integer>> result = searcher.search(document);
        for (String word : result.keySet()) {
            System.out.println(word + ": " + result.get(word));
        }
    }
}

