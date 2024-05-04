package ch.hslu.sw10.exercise2;

import java.util.Random;
import java.util.function.Supplier;
import java.lang.reflect.Array;

public class Sort {
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static Character[] randomChars(final int length) {
        return randomElements(length, () -> ALPHABET.charAt(new Random().nextInt(ALPHABET.length())), Character.class);
    }

    public static Integer[] randomInts(final int length, final int bound) {
        return randomElements(length, () -> new Random().nextInt(bound), Integer.class);
    }

    public static <T extends Comparable<T>> void quickSort(final T[] a) {
        quickSort(a, 0, a.length - 1);
    }

    private static <T> T[] randomElements(final int length, final Supplier<T> supplier, final Class<T> componentType) {
        T[] array = (T[]) Array.newInstance(componentType, length);
        for (int i = 0; i < length; i++) {
            array[i] = supplier.get();
        }
        return array;
    }

    private static <T extends Comparable<T>> void quickSort(final T[] a, final int left, final int right) {
        int up = left; // linke Grenze
        int down = right - 1; // rechte Grenze (ohne Trennelement)
        T t = a[right]; // rechtes Element als Trennelement
        boolean allChecked = false;
        do {
            while (a[up].compareTo(t) < 0) {
                up++; // suche grösseres (>=) Element von links an
            }
            // while ((a[down].compareTo(t) >= 0) && (down > up)) {     // QUICK SORT
            while ((a[down].compareTo(t) > 0) && (down > up)) {         // IMPROVED QUICK SORT
                down--; // suche echt kleineres (<) Element von rechts an
            }
            if (down > up) { // solange keine Überschneidung
                exchange(a, up, down);
                up++; down--; // linke und rechte Grenze verschieben
            } else {
                allChecked = true; // Austauschen beendet
            }
        } while (!allChecked);
        exchange(a, up, right); // Trennelement an endgültige Position (a[up])
        if (left < (up - 1)) quickSort(a, left, (up - 1)); // linke Hälfte
        if ((up + 1) < right) quickSort(a, (up + 1), right); // rechte Hälfte, ohne T’Elt.
    }

    /**
     * Vertauscht zwei bestimmte Items im Array.
     *
     * @param a Array
     * @param firstIndex Index des ersten Items
     * @param secondIndex Index des zweiten Items
     */
    private static <T> void exchange(final T[] a, final int firstIndex, final int secondIndex) {
        T tmp;
        tmp = a[firstIndex];
        a[firstIndex] = a[secondIndex];
        a[secondIndex] = tmp;
    }
}
