package app;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import app.pages.vizualizer.SortingVisualizer;

public class AppWindow extends JFrame {
    public AppWindow() {
        super("Java app");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(new SortingVisualizer());
        pack();
        setResizable(true);
        setVisible(true);
    }
}
