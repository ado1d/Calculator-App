import javax.swing.*;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class Button {
    private JButton button;

    public Button(String label, Display display, Operations operations) {
        button = new JButton(label);

        button.setFont(new Font("Futura", Font.BOLD, 20));
        button.setSize(new Dimension(20, 20));

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = button.getText();
                if (input.equals("=")) {
                    operations.evaluate();
                } else if (input.equals("C")) {
                    display.clear();
                } else {
                    display.append(input);
                }
            }
        });
    }

    public JButton getComponent() {
        return button;
    }
}


