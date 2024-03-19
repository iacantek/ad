package ch.hslu.sw04.exercise4;

public interface IHashTable<T> {
    /**
     * Inserts a value into the hash table.
     * @param value value to insert
     * @return true if insert succeeded, else false
     */
    boolean insert(T value);

    /**
     * Reads the value from a hash table from the given index.
     * @param hash hash acting as index
     * @return value at given index
     */
    T read(int hash);

    /**
     * Reads the value from a hash table from the given index and offset.
     * @param hash hash acting as index
     * @param offset offset from the starting item
     * @return value at given index and offset.
     */
    T read(int hash, int offset);

    /**
     * Removes value from hash table
     * @param value value to remove
     * @return true if removal was successful, else false
     */
    boolean remove(T value);

    /**
     * Gets size of hash table.
     * @return size
     */
    int size();
}
