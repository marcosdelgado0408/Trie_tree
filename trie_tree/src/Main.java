public class Main {
    public static void main(String[] args) {
        TrieTree trieTree = new TrieTree();

        trieTree.insertWord("ola");
        trieTree.insertWord("pessoal");
        trieTree.insertWord("Amar");
//        trieTree.printTrieTree(trieTree.getRoot());

        System.out.println(trieTree.search("ola"));
    }
}
