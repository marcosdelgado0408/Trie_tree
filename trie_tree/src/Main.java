import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TrieTree trieTree = new TrieTree();

        // Insertion
        try {
            File file = new File(args[0]);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()){
                String word = scanner.next();
                trieTree.insertWord(word);
            }

            scanner.close();

        }
        catch (FileNotFoundException e) {
            System.out.println("Erro\nEste arquivo não existe");
            return;
        }

        // Java Swing
        if(args.length == 2 && args[1].equals("-ui")){
            JFrame frame = new JFrame("Trie Tree Search");
            frame.setContentPane(new Ui(trieTree).getMainPanel()); // passando a trietree por paraêmetro
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500,500);
            frame.setVisible(true);
        }


        // AutoComplete
        else if(args.length == 3){
            System.out.println(trieTree.autoComplete(args[1], Integer.parseInt(args[2])));
        }
        else if(args.length == 2){
            System.out.println(trieTree.autoComplete(args[1]));
        }
        else {
            System.out.println("Quantidade de argumentos inválida");
        }



    }


}
