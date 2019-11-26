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

    public boolean search(String key){
        return recursiveSearch(key, this.root);
    }


    private boolean recursiveSearch(String key, TrieNode root){ // key será a palavra

        if(root.getChildren().isEmpty()){ // caso chegar no nó folha eu vou pegar a palavra
            System.out.println("txt: " + root.getText());
            System.out.println("key: " +  key);
            if(root.getText().equals(key)){
                System.out.println("idjasdjopasdjasopjdpsoao");
                return true;
            }
        }
        else {
            for (Map.Entry<Character, TrieNode> pair : root.getChildren().entrySet()) {
                recursiveSearch(key, pair.getValue());
            }
        }
        return false;
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