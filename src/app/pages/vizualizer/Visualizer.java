package app.pages.vizualizer;

import javax.swing.*;

import app.pages.vizualizer.sorters.*;

import java.awt.*;
import java.util.Random;

public class Visualizer extends JComponent {
    private final Random random;
    private final Timer timer;
    
    private int[] array = null;
    private int[] selectedElements = null;
    private boolean sorted = false;
    private int order = -1;
    private CycledSort sorter;
    
    private static final Color SELECTED_BAR_COLOR = Color.RED;
    private static final Color BAR_COLOR = Color.WHITE;
    private static final Color SORTED_BAR_COLOR = Color.GREEN;
    private static final int BAR_COUNT = 20;
    private static final int PADDING = 6;
    private static final int MAX_VALUE = 100;
    private static final Dimension PREFERRED_SIZE = new Dimension(600, 600);

    public Visualizer() {
        this(-1);
    }

    public Visualizer(int order) {
        super();
        random = new Random();
        timer = new Timer(50, e -> update());
        sorter = new BubbleSort();
        reset(order);
    }

    public void setSorter(CycledSort sorter) {
        this.sorter = sorter;
        this.sorter.setArray(array);
    }

    public void start() {
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

    public void reset() {
        reset(order);
    }

    public void reset(int order) {
        stop();
        this.order = order;
        array = createArray(order);
        sorted = false;
        sorter.setArray(array);
        repaint();
    }

    @Override
    public Dimension getPreferredSize() {
        return PREFERRED_SIZE;
    }

    private int[] createArray(int order) {
        int[] arr = new int[BAR_COUNT];
        float hDiff = (float) MAX_VALUE / BAR_COUNT;
        for (int i = 0; i < BAR_COUNT; i++) {
            switch (order) {
                case -1:
                    arr[i] = (int) (hDiff * (BAR_COUNT - i));
                    break;
                case 0:
                    arr[i] = random.nextInt(MAX_VALUE) + 1;
                    break;
                case 1:
                    arr[i] = (int) (hDiff * (i + 1));
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }
        sorted = false;
        return arr;
    }

    private void update() {
        sorted = sorter.next();
        selectedElements = sorter.getActiveIndexes();
        if(sorted)
            timer.stop();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        int barWidth = (getWidth() - PADDING * array.length) / array.length;
        g.setColor(getBackground()); // r 64 g 64 b 64
        g.fillRect(0, 0, getWidth(), getHeight());     

        for (int i = 0; i < array.length; i++) {
            int barHeight = getHeight() * array[i] / MAX_VALUE;

            // TODO: painting optimisation

            if(sorted)
                g.setColor(SORTED_BAR_COLOR);
            else
                g.setColor(BAR_COLOR);

            if(selectedElements != null && !sorted)
                for(int j = 0; j < selectedElements.length; j++)
                    if(selectedElements[j] == i)
                        g.setColor(SELECTED_BAR_COLOR);

            g.fillRect(PADDING / 2 + (barWidth + PADDING) * i, getHeight() - barHeight, barWidth, barHeight);
        }
        
        Toolkit.getDefaultToolkit().sync();
    }
}
