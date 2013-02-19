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
        // It's not neccessary to save objects in variables
        // For example, you can avoid doing it if you don't need this object later
        window.add(new JLabel("This is a label"));

        JButton button = new JButton("This is a button that basically hides the label");
        window.add(button);

        window.pack();
        // JFrame.EXIT_ON_CLOSE is considered deprecated. You can still use it,
        // but WindowConstants.EXIT_ON_CLOSE is better style.
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
        topBox.add(Box.createHorizontalStrut(8)); // Struct is an invisible component with fixed width/height
        topBox.add(new JButton("Button 2"));
        topBox.add(Box.createHorizontalStrut(8));
        topBox.add(new JButton("Button 3"));

        JButton buttonB = new JButton("B");

        Box bottomBox = Box.createHorizontalBox();
        // Glue is an invisible component that tries to occupy as much space as possible
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