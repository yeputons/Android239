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
        window.setLayout(new GridLayout(4, 3)); // Number of rows and columns, respectively

        window.add(new JButton("Button 1"));
        window.add(new JButton("Button 2"));
        window.add(new JButton("Button 3"));
        window.add(Box.createGlue()); // We cannot left a cell empty, so we fill it with some invisible component
        window.add(Box.createGlue());
        window.add(Box.createGlue());
        window.add(new JButton("Button 4"));
        window.add(new JButton("Button 5"));

        window.pack(); // pack() function calculates preferred dimensions to avoid 'empty' windows
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    private static int eventsCounter = 0;
    private static void demonstrateEvents() {
        // We declared this reference variable as 'final'
        // to make it accessible from inner classes (such as ActionListeners)
        final JFrame window = new JFrame("Events demo");

        // This layout manager places components one-by-one from the left
        // to the right and makes new lines, if necessary
        window.setLayout(new FlowLayout());

        final JLabel label = new JLabel("Nothing");
        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");

        window.add(label);
        window.add(button1);
        window.add(button2);

        // ActionListener is an object too, so we can save reference to it
        // in a variable...
        ActionListener defaultListener = new ActionListener() {
            // This code should be generated automatically
            // Just start typing 'new ActionList...' and press Tab when
            // 'new ActionListener() { ... }' suggestion appears

            @Override
            public void actionPerformed(ActionEvent e) {
                eventsCounter++;
                label.setText(String.format("Counter=%d", eventsCounter));
            }
        };

        // and use the same listener for two different buttons!
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
