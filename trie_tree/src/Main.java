public class Main {
    public static void main(String[] args) {
        TrieTree trieTree = new TrieTree();

        //a, ama, amar, ame, amei,
        //ameixa, oi, oito, eu, ele, ela, eles, elas

        trieTree.insertWord("a");
        trieTree.insertWord("ama");
        trieTree.insertWord("amar");
        trieTree.insertWord("ame");
        trieTree.insertWord("amei");
        trieTree.insertWord("ameixa");
        trieTree.insertWord("oi");
        trieTree.insertWord("oito");
        trieTree.insertWord("eu");
        trieTree.insertWord("ele");
        trieTree.insertWord("ela");
        trieTree.insertWord("eles");
        trieTree.insertWord("elas");

        System.out.println(trieTree.autoComplete("am"));
        System.out.println(trieTree.autoComplete("am", 10));

    }
}
