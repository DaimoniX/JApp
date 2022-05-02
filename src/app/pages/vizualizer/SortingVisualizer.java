package app.pages.vizualizer;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class SortingVisualizer extends JPanel {

    public SortingVisualizer() {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.DARK_GRAY);
        Visualizer visualizer = new Visualizer();
        VisualizerController controller = new VisualizerController(visualizer);
        controller.setBackground(visualizer.getBackground());
        add(controller);
        add(visualizer);
    }
    
}
