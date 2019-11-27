import java.util.Iterator;
import java.util.Map;

public class TrieTree {
    private TrieNode root;


    public TrieTree() {
        root = new TrieNode();
    }

    public TrieNode getRoot() { return root; }

    // primeiro temos que checar se a primeira letra da palavra pertence a algum dos filhos do root.
    // quando adicionarmos a primeira letra no root, precisamos as outras letras como cada novo filho dessa primeira letta adicionada
    public void insertWord(String word){
        TrieNode root = this.root;

        for(int i=0;i<word.length();i++){
            TrieNode temp = root.getChildren().get(word.charAt(i));

            if(temp == null){
                temp = new TrieNode();
                root.getChildren().put(word.charAt(i), temp);
            }

            root = temp; // na proxima iteração do for ele adicionará o caractere nos filhos de temp
        }
        // leaf node será o fim da palavra
        root.setIsWord(true);
        root.setText(word);
    }


    public boolean search(String key){ // key será a palavra
        TrieNode root = this.root;

        for(int i=0;i<key.length();i++){
            TrieNode temp = root.getChildren().get(key.charAt(i));

            if(temp == null){
                return false;
            }

            root = temp; // proxima iterção será checado os filhos de temp -> e assim por diante
        }

        return root.isWord();
    }




    public void printTrieTree(TrieNode root){
        if(root == null){
            return;
        }
        if(root.getChildren().isEmpty()){ // caso for o no folha
            System.out.println(root.getText());
        }
        printMap(root.getChildren());
        for (Map.Entry<Character, TrieNode> pair : root.getChildren().entrySet()) {
            printTrieTree(pair.getValue());
        }
    }

    private static void printMap(Map mp) {
        Iterator it = mp.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(pair.getKey() + " - " + pair.getValue());
        }
    }


}