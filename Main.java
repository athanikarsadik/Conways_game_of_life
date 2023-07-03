import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Grid Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridPanel gridPanel = new GridPanel(100); // Create a 10 by 10 grid panel
        frame.getContentPane().add(gridPanel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
        Logic l1 = new Logic(100, gridPanel);
    }

}
