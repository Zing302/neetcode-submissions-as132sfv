public class TrieNode{
    TrieNode[] children;
    boolean isEnd;
    public TrieNode(){
        children=new TrieNode[26];
        isEnd=false;
    }
}
class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root=new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr=root;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(curr.children[c-'a']==null){
                curr.children[c-'a']=new TrieNode();
            }
            curr=curr.children[c-'a'];
        }
        curr.isEnd=true;
    }

    public boolean search(String word) {
        return dfs(word,root,0);
    }

    public boolean dfs(String word, TrieNode root, int level){
        for(int i=level;i<word.length();i++){
            char c=word.charAt(i);
            if(c=='.'){
                for(TrieNode child:root.children){
                   if(child!=null && dfs(word,child,i+1)){
                        return true;
                   }
                }
                return false;
            }else{
                if(root.children[c-'a']==null){
                    return false;
                }
                root=root.children[c-'a'];
            }
        }
        return root.isEnd;
    }
}
