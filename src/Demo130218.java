import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Demo130218 {
    public static void main(String[] args) {
        helloWorld();

        int[][] array = initializeNewArray(3, 4);
        // array = new int[3][4]
        fillArray(array);
        System.out.println(array[2][3]);

        demonstratePrint();

        demonstrateBox();

        demonstrateGrid();

        demonstrateEvents();
    }


    private static void helloWorld() {
        System.out.printf("Hello World! 2+2=%d", 2 + 2);
    }

    private static int[][] initializeNewArray(int size1, int size2) {
        return new int[size1][size2];
    }

    // Remember, the 'array' variable here is just a reference to a memory area,
    // where the data lies. So if you change data, it changes in the caller.
    // But if you changes the variable itself, it won't affect environment.
    private static void fillArray(int[][] array) {
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array[i].length; j++)
                array[i][j] = i + j;

        // The following lines do nothing
        array = new int[1][1];
        array[0][0] = 239;
    }

    private static void demonstratePrint() {
        String s = "a" + Integer.toString(2) + "b";
        int minusTwo = Integer.parseInt("-2");
        double floatingPointNumber = 1.0 / 239.0;
        //
        System.out.printf("s=%s, minusTwo=%d, floatingPointNumber=%.4f=%f", s, minusTwo,
                floatingPointNumber, floatingPointNumber);
    }

    private static void demonstrateBox() {
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
