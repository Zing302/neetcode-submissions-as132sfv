public class TrieNode{
    TrieNode[] character;
    boolean isEnd;
    public TrieNode(){
        character=new TrieNode[26];
        isEnd=false;
    }
}
class PrefixTree {
    TrieNode root;
    public PrefixTree() {
        root=new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr=root;
        for(char c:word.toCharArray()){
            if(curr.character[c-'a']==null){
                curr.character[c-'a']=new TrieNode();
            }
            curr=curr.character[c-'a'];
        }
        curr.isEnd=true;
    }

    public boolean search(String word) {
        TrieNode curr=root;
        for(char c:word.toCharArray()){
            if(curr.character[c-'a']==null){
                return false;
            }
            curr=curr.character[c-'a'];
        }
        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr=root;
        for(char c:prefix.toCharArray()){
            if(curr.character[c-'a']==null){
                return false;
            }
            curr=curr.character[c-'a'];
        }
        return true;
    }
}
