import java.util.HashMap;
import java.util.Map;


public class TrieNode {
    private boolean isWord;
    private Map<Character,TrieNode> children;
    private String text;
    //opcional -- deve ser preenchido apenas quando isWord é → true


    public TrieNode() {
        this.children = new HashMap<>();
    }

    public Map<Character, TrieNode> getChildren() { return children; }
    public String getText() { return text; }
    public boolean isWord() { return isWord; }

    public void setIsWord(boolean word) { isWord = word; }
    public void setText(String text) { this.text = text; }

}
