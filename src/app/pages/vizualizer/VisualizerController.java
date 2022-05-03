package app.pages.vizualizer;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import app.pages.vizualizer.sorters.BubbleSort;
import app.pages.vizualizer.sorters.CycledSort;
import app.pages.vizualizer.sorters.SelectionSort;

public class VisualizerController extends JPanel {
    public VisualizerController(Visualizer visualizer) {
        super();
        setBackground(getBackground());
        JButton runBtn = new JButton("run");
        runBtn.addActionListener(e -> visualizer.start());
        JButton stopBtn = new JButton("stop");
        stopBtn.addActionListener(e -> visualizer.stop());
        JButton randomizeBtn = new JButton("randomize");
        randomizeBtn.addActionListener(e -> visualizer.reset(0));
        CycledSort[] sorters = new CycledSort[] { new BubbleSort(), new SelectionSort() };
        String[] sorterLabels = new String[] { "Bubble", "Selection" };
        JComboBox<String> sorterSelector = new JComboBox<>(sorterLabels);
        sorterSelector.addActionListener(e -> visualizer.setSorter(sorters[sorterSelector.getSelectedIndex()]));
        visualizer.setSorter(sorters[0]);
        add(runBtn);
        add(stopBtn);
        add(randomizeBtn);
        add(sorterSelector);
    }
}
