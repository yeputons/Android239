import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Demo130218 {
    public static void main(String[] args) {
        demonstrateGrid();
        demonstrateEvents();
    }

    private static void demonstrateGrid() {
        JFrame window = new JFrame("Window with example of GridLayout");
        window.setLayout(new GridLayout(4, 3));

        window.add(new JButton("Button 1"));
        window.add(new JButton("Button 2"));
        window.add(new JButton("Button 3"));
        window.add(Box.createGlue());
        window.add(Box.createGlue());
        window.add(Box.createGlue());
        window.add(new JButton("Button 4"));
        window.add(new JButton("Button 5"));

        window.pack();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    private static int eventsCounter = 0;
    private static void demonstrateEvents() {
        final JFrame window = new JFrame("Events demo");
        window.setLayout(new FlowLayout());

        final JLabel label = new JLabel("Nothing");
        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");

        window.add(label);
        window.add(button1);
        window.add(button2);

        ActionListener defaultListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventsCounter++;
                label.setText(String.format("Counter=%d", eventsCounter));
            }
        };
        button1.addActionListener(defaultListener);
        button2.addActionListener(defaultListener);

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(window, "Hey, button2 was clicked!");
            }
        });

        window.pack();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}
