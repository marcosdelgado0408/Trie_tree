public class Main {
    public static void main(String[] args) {
        TrieTree trieTree = new TrieTree();


        trieTree.insertWord("ola");
        trieTree.insertWord("pessoal");
        trieTree.insertWord("pessoas");
        trieTree.insertWord("ama");
        trieTree.insertWord("aoaoao");
        trieTree.insertWord("amar");
        trieTree.insertWord("ame");
        trieTree.insertWord("amei");
        trieTree.insertWord("ameixa");

        System.out.println(trieTree.autoComplete("am"));

    }
}
