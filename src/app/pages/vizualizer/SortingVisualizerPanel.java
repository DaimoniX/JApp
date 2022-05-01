package app.pages.vizualizer;

import java.awt.Color;

import javax.swing.JPanel;

public class SortingVisualizerPanel extends JPanel {

    public SortingVisualizerPanel() {
        super();
        setBackground(Color.DARK_GRAY);
        add(new SortingVisualizer());
    }
    
}
