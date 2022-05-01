package app.pages.vizualizer;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class SortingVisualizer extends JComponent {
    private final Random random;
    private final Timer timer;
    
    private Integer[] array = null;
    private boolean sorted = false;
    
    private static final Color BAR_COLOR = Color.WHITE;
    private static final Color SORTED_BAR_COLOR = Color.GREEN;
    private static final int BAR_COUNT = 20;
    private static final int PADDING = 6;
    private static final int MAX_VALUE = 100;
    private static final Dimension PREFERRED_SIZE = new Dimension(600, 600);

    public SortingVisualizer() {
        this(-1);
    }


    public SortingVisualizer(int order) {
        super();
        random = new Random();
        array = createArray(order);
        timer = new Timer(50, e -> update());
        sorted = false;
        timer.start();
    }

    @Override
    public Dimension getPreferredSize() {
        return PREFERRED_SIZE;
    }

    private Integer[] createArray(int order) {
        Integer[] arr = new Integer[BAR_COUNT];
        float hDiff = (float) MAX_VALUE / BAR_COUNT;
        for (int i = 0; i < BAR_COUNT; i++) {
            switch (order) {
                case -1 -> arr[i] = (int) (hDiff * (BAR_COUNT - i));
                case 0 -> arr[i] = random.nextInt(MAX_VALUE) + 1;
                case 1 -> arr[i] = (int) (hDiff * (i + 1));
                default -> throw new IllegalArgumentException();
            }
        }
        sorted = false;
        return arr;
    }

    private int ind = 0;
    private int ind1 = 0;

    private void update() {
        if(array[ind1] > array[ind1 + 1]) {
            Integer temp = array[ind1];
            array[ind1] = array[ind1 + 1];
            array[ind1 + 1] = temp;
        }
        ind1++;
        if(ind1 >= array.length - 1) {
            ind1 = 0;
            ind++;
        }
        sorted = ind + 1 == array.length;
        if(sorted)
            timer.stop();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        int barWidth = (getWidth() - PADDING * array.length) / array.length;
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());
        if(sorted)
            g.setColor(SORTED_BAR_COLOR);
        else
            g.setColor(BAR_COLOR);
        for (int i = 0; i < array.length; i++) {
            int barHeight = getHeight() * array[i] / MAX_VALUE;
            g.fillRect(PADDING / 2 + (barWidth + PADDING) * i, getHeight() - barHeight, barWidth, barHeight);
        }
    }
}
