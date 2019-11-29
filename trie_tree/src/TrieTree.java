import java.util.*;

public class TrieTree {
    private TrieNode root;
    private List<String> startsWithStrings;

    public TrieTree() {
        root = new TrieNode();
        startsWithStrings = new ArrayList<>();
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
            TrieNode temp = root.getChildren().get(key.charAt(i)); // pegando o caractere filho que a key possui

//            System.out.println(root.getChildren());


            if(temp == null){
                return false;
            }

            root = temp; // proxima iterção será checado os filhos de temp -> e assim por diante
        }

        return root.isWord();
    }

    public String autoComplete(String key){
        startsWith(key, this.root);
        StringBuilder message = new StringBuilder();

        if(key.isBlank()){
            return "";
        }

        for(String it: this.startsWithStrings){
            message.append(it).append("\n");
        }

        this.startsWithStrings.clear(); //limpando o startsWithStrings para não ficar lixo na nova chamada de método
        return String.valueOf(message);
    }


    public String autoComplete(String key, int maxShow){
        startsWith(key, this.root);
        StringBuilder message = new StringBuilder();
        String[] startsWithStringsArray = startsWithStrings.toArray(new String[0]);


        if(key.isBlank()){
            return "";
        }

        if(maxShow > startsWithStringsArray.length){ // caso a pessoa indique um tamanho maior que o tamanho existesnte da lista de strings
            maxShow = startsWithStringsArray.length;
        }

        for(int i=0;i<maxShow;i++){
            message.append(startsWithStringsArray[i]).append("\n");
        }

        this.startsWithStrings.clear(); //limpando o startsWithStrings para não ficar lixo na nova chamada de método
        return String.valueOf(message);
    }



    /**
     * Nessa função eu tive que passar em todos os nós, verificar se ele é um nó de fim de palavra,
     * e assim eu poderei comparar se essa palavra começa com o valor da chave.
     *
     * @param key chave para pesquisa
     * @param root root node
     */
    private void startsWith(String key, TrieNode root){

        if(root == null){
            return;
        }

        for (Map.Entry<Character, TrieNode> pair : root.getChildren().entrySet()) {
            if(pair.getValue().isWord()){ // se for palavra ela vai possuir o string text
               if(pair.getValue().getText().startsWith(key)){
                   // jogando em uma variavel global, pois somente com o return não funcionaria por causa das chamadas recursivas
                   startsWithStrings.add(pair.getValue().getText());
               }
            }
            startsWith(key, pair.getValue());
        }
    }


    public void remove(String key){
        TrieNode root = this.root;

        boolean canRemove = search(key);

        if(canRemove){
            changeBoolean(key, this.root);
        }

    }


    private void changeBoolean(String key, TrieNode root) {
        for (Map.Entry<Character, TrieNode> pair : root.getChildren().entrySet()) {

            if(pair.getValue().isWord()){
                if(pair.getValue().getText().equals(key)){
                    pair.getValue().setIsWord(false);
                    pair.getValue().setText(null);
                }
            }


            changeBoolean(key, pair.getValue());
        }
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