import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Ui {
    private JTextField textField;
    private JTextArea textArea;
    private JPanel mainPanel;
    private StringBuilder text;

    public JPanel getMainPanel() { return mainPanel; }

    public Ui(TrieTree trieTree) {

        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                int code = e.getKeyCode();
                if(code == 8 && textField.getText().isEmpty()){ // estava com um bug, onde quando eu pressionava backspace, após isso, ele mostrava todas as palavras
                    textArea.setText(null); // quando não houver nada, ele não mostrará as pesquisas anteriories
                }
                else {
                    textArea.setText(trieTree.autoComplete(textField.getText(), 10));
                }

            }
        });
    }

}
