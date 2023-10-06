package view;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ViewRandomNumber extends JFrame {
    private final JFrame WINDOW;
    private final Random random;
    private int sortedNumber;

    public ViewRandomNumber(){
        this.WINDOW = new JFrame("Random Number");
        random = new Random();
        createWindow();
    }

    private void createWindow(){
        WINDOW.setSize(400, 400);
        WINDOW.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        WINDOW.setVisible(true);

        JButton button = new JButton("Generate Number");
        button.addActionListener(e ->{
            sortedNumber = random.nextInt(100);
            showNumber();
        });

        WINDOW.getContentPane().removeAll();
        WINDOW.setLayout(new FlowLayout());
        WINDOW.add(button);
    }

    private void showNumber(){
        WINDOW.getContentPane().removeAll();
        WINDOW.repaint();

        JLabel label = new JLabel(Integer.toString(sortedNumber));
        JButton newNumber = new JButton("Generate a new Number");
        newNumber.addActionListener(e -> {
            sortedNumber = random.nextInt(100);
            showNumber();
        });

        WINDOW.setLayout(new BoxLayout(WINDOW.getContentPane(), BoxLayout.Y_AXIS));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setAlignmentY(Component.CENTER_ALIGNMENT);

        newNumber.setAlignmentX(Component.CENTER_ALIGNMENT);
        newNumber.setAlignmentY(Component.CENTER_ALIGNMENT);

        WINDOW.add(label);
        WINDOW.add(newNumber);
        WINDOW.revalidate();
    }
}
