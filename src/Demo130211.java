import javax.swing.*;
import java.awt.*;

public class Demo130211 {
    public static void main(String[] args) {
        demonstrateBorderLayout();
        demonstrateBorderLayoutAlignment();
        demonstrateBoxLayout();
    }

    private static void demonstrateBorderLayout() {
        JFrame window = new JFrame("Window with example of border layout (default)");
        window.add(new JLabel("This is a label"));
        window.add(new JButton("This is a button that basically hides the label"));

        window.pack();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    private static void demonstrateBorderLayoutAlignment() {
        JFrame window = new JFrame("Second window with example of the border layout (default)");
        window.add(new JLabel("This is a label at the top"), BorderLayout.NORTH);
        window.add(new JLabel("This is a button at the bottom"), BorderLayout.SOUTH);
        window.pack();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    private static void demonstrateBoxLayout() {
        JFrame window = new JFrame("Window with example of Box");
        window.setResizable(false);

        Box topBox = Box.createHorizontalBox();
        topBox.add(new JButton("Button 1"));
        topBox.add(Box.createHorizontalStrut(8));
        topBox.add(new JButton("Button 2"));
        topBox.add(Box.createHorizontalStrut(8));
        topBox.add(new JButton("Button 3"));

        JButton buttonB = new JButton("B");

        Box bottomBox = Box.createHorizontalBox();
        bottomBox.add(Box.createHorizontalGlue());
        bottomBox.add(buttonB);

        Box verticalBox = Box.createVerticalBox();
        verticalBox.add(topBox);
        verticalBox.add(bottomBox);

        window.add(verticalBox);
        window.pack();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}