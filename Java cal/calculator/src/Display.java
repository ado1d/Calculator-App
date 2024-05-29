import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;

public class Display {
    private JTextField textField;

    public Display() {
        textField = new JTextField();
        textField.setEditable(false);
        textField.setPreferredSize(new Dimension(150, 70)); 
        textField.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));

        textField.setBackground(new Color(130, 150, 160));

    }

    public void append (String text) {
        textField.setText(textField.getText() + text);
    }

    public void clear () {
        textField.setText(null);
    }

    public JTextField getComponent() {
        return textField;
    }
}
