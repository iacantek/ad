package ch.hslu.sw04.exercise2;

public class ArrayFactory {
    public static Allocation[] createArray(final int size) {
        var array = new Allocation[size];
        for (var i = 0; i < size; i++) {
            array[i] = new Allocation();
        }
        return array;
    }
}
