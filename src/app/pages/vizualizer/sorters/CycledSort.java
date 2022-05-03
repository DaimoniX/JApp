package app.pages.vizualizer.sorters;

public abstract class CycledSort {
    protected int[] array;
    protected final int[] activeIndexes;

    protected CycledSort(int activeIndexesLength) {
        activeIndexes = new int[activeIndexesLength];
        reset();
    }

    /**
    Sets array of sorter and reset state
    @param array - array for sorting
    @throws IllegalArgumentException if provided array is null
    */
    public void setArray(int[] array) {
        if(array == null)
            throw new IllegalArgumentException();
        this.array = array;
        reset();
    }

    /**
    Resets the sorter state
    */
    protected abstract void reset();

    /**
    Perfroms next cycle of sorting
    @return true if array is sorted
    */
    public abstract boolean next();

    /**
    Returns array of currently selected elements of array
    @return arrat of active indexes
    */
    public int[] getActiveIndexes() {
        return activeIndexes;
    }

    /**
    Swaps two elements of array
    @param array - provided array
    @param a - first index
    @param b - second index
    */
    protected static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
