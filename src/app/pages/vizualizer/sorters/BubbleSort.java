package app.pages.vizualizer.sorters;

public class BubbleSort extends CycledSort {
    private int i;
    private int j;

    public BubbleSort() {
        super(2);
    }

    @Override
    protected void reset() {
        i = j = 0;
    }

    @Override
    public boolean next() {
        if(j >= array.length - 1) {
            i++;
            j = 0;
        }

        if(array[j] > array[j + 1])
            swap(array, j, j + 1);

        activeIndexes[0] = j;
        activeIndexes[1] = ++j;

        return i == array.length - 1;
    }    
}
