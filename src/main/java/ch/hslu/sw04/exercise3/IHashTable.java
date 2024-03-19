package ch.hslu.sw04.exercise3;

public interface IHashTable<T> {
    /**
     * Inserts a value into the hash table.
     * @param value value to insert
     * @return true if insert succeeded, else false
     */
    boolean insert(T value);

    /**
     * Reads the value from a hash table from the given index.
     * @param hash value acting as index.
     * @return value at given index.
     */
    T read(int hash);

    /**
     * Searches value in hash table
     * @param value value to search
     * @return index of value in hash table, null if not found
     */
    Integer search(T value);

    /**
     * Removes value from hash table
     * @param value value to remove
     * @return true if removal was successful, else false
     */
    boolean remove(T value);

    /**
     * Gets allocated size of hash table.
     * @return allocated size
     */
    long allocatedSize();

    /**
     * Gets size of hash table.
     * @return size
     */
    int size();
}
