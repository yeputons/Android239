import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Demo130225 {
    public static void main(String[] args) {
        demonstrateStrings();
        demonstrateSourceDetection();
    }

    private static void demonstrateStrings() {
        String first = "aba", second = "c";
        String a = first + second + first;
        String b = "abacaba";
        System.out.println("a == b: " + (a == b));
        System.out.println("a.equals(b): " + (a.equals(b)));
    }

    private static void demonstrateSourceDetection() {
        JFrame window = new JFrame("Source detection");

        final JButton button1 = new JButton("Button1");
        final JButton button2 = new JButton("Button2");
        final JButton button3 = new JButton("Button3");

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton)e.getSource();
                System.out.printf("Label: %s\n", button.getText());
                if (button == button1)
                    System.out.println("Button1 was clicked!");
                if (button == button2)
                    System.out.println("Button2 was clicked!");
            }
        };
        button1.addActionListener(listener);
        button2.addActionListener(listener);
        button3.addActionListener(listener);

        window.setLayout(new FlowLayout());
        window.add(button1);
        window.add(button2);
        window.add(button3);
        window.pack();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}
