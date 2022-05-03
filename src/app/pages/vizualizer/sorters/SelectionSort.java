package app.pages.vizualizer.sorters;

public class SelectionSort extends CycledSort {
    private int i;
    private int j;
    private int min;

    public SelectionSort() {
        super(2);
    }

    @Override
    protected void reset() {
        i = j = 0;
        min = 0;
    }

    @Override
    public boolean next() {
        if(array[j] > array[min]) {
            min = j;
        }

        j++;

        if(j > array.length - i - 1) {
            swap(array, min, array.length - i - 1);
            min = 0;
            i++;
            j = 0;
        }

        activeIndexes[0] = min;
        activeIndexes[1] = j;
        
        return i == array.length - 1;
    }
    
}
