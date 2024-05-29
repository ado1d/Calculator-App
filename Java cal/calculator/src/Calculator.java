import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;



public class Calculator {
    private JFrame frame;
    private Display display;
    private Operations operations;

    public Calculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(300, 500);
        frame.setLocation(300, 400);
        frame.setResizable(false);

        

        display = new Display();
        frame.add(display.getComponent(), BorderLayout.NORTH);

        try {
            Image icon = ImageIO.read(new File("E:\\Java cal\\pic.jpg"));
            frame.setIconImage(icon);
        } catch (IOException e) {   
            e.printStackTrace();
        }
        

        operations = new Operations(display);

        frame.add(createButtonPanel(), BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel(new GridLayout(4, 4, 5, 5));
        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "x",
            "1", "2", "3", "-",
            "C", "0", "=", "+"
        };

        for (String label : buttonLabels) {
            Button button = new Button(label, display, operations);
            buttonPanel.add(button.getComponent());
        }

        return buttonPanel;
    }

    public static void main(String[] args) {
        new Calculator();
    }
}