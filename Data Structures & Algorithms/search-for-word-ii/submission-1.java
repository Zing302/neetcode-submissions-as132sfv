class TrieNode{
    Map<Character, TrieNode> children;
    boolean isWord;

    public TrieNode(){
        children=new HashMap<>();
        isWord=false;
    }

    public void addWord(String word){
        TrieNode curr=this;
        for(Character c: word.toCharArray()){
            if(!curr.children.containsKey(c)){
                curr.children.put(c,new TrieNode());
            }
            curr=curr.children.get(c);
        }
        curr.isWord=true;
    }
}
class Solution {
    TrieNode root;
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res=new ArrayList<>();
        root=new TrieNode();
        for(String word:words){
            root.addWord(word);
        }
        for(int r=0;r<board.length;r++){
            for(int c=0;c<board[0].length;c++){
                backtracking(board,r,c,root,res,""); 
            }
        }
        return res;
    }
    public void backtracking(char[][] board,int r,int c,TrieNode curr, List<String> res,String word){
        if(r<0 || c<0 || r>=board.length || c>=board[0].length || !curr.children.containsKey(board[r][c])){
            return;
        }
        char temp=board[r][c];
        board[r][c]='#';
        curr=curr.children.get(temp);
        word+=temp;
        if(curr.isWord){
            curr.isWord=false;
            res.add(word);
        }
        backtracking(board,r+1,c,curr,res,word); 
        backtracking(board,r-1,c,curr,res,word);           
        backtracking(board,r,c+1,curr,res,word);
        backtracking(board,r,c-1,curr,res,word);
        board[r][c]=temp;
    }
}
