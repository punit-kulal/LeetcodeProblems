import java.util.HashMap;
import java.util.Map;

class WordDictionary {

    TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    private void add(char[] word, int index, TrieNode node){
        if (word.length == index){
            node.isFinish = true;
        }else{
            TrieNode a;
            if (!node.map.containsKey(word[index])){
                a = new TrieNode();
                node.map.put(word[index], a);
            }else{
                a = node.map.get(word[index]);
            }
            add(word, index+1, a);
        }
    }

    private boolean search(char[] word, int i, TrieNode node){
        if (word.length == i){
            return node.isFinish;
        }else{
            if (word[i] != '.'){
                return node.map.containsKey(word[i]) && search(word, i + 1, node.map.get(word[i]));
            }else{
                for (TrieNode node1: node.map.values()) {
                    if (search(word, i+1, node1)){
                        return true;
                    }
                }
                return false;
            }
        }
    }


    /** Adds a word into the data structure. */
    public void addWord(String word) {
        add(word.toCharArray(), 0, root);
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return  search(word.toCharArray(), 0, root);
    }
}

class TrieNode{
    Map<Character, TrieNode> map;
    boolean isFinish;

    public TrieNode(){
        map = new HashMap<>();
        isFinish = false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
