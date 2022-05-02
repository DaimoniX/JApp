package app.pages.vizualizer;

import javax.swing.JButton;
import javax.swing.JPanel;

public class VisualizerController extends JPanel {
    public VisualizerController(Visualizer visualizer) {
        super();
        setBackground(getBackground());
        JButton runBtn = new JButton("run");
        runBtn.addActionListener(e -> visualizer.start());
        JButton stopBtn = new JButton("stop");
        stopBtn.addActionListener(e -> visualizer.stop());
        JButton resetBtn = new JButton("reset");
        resetBtn.addActionListener(e -> visualizer.reset());
        add(runBtn);
        add(stopBtn);
        add(resetBtn);
    }
}
