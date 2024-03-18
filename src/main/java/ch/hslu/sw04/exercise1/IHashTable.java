package ch.hslu.sw04.exercise1;

public interface IHashTable<T> {
    /**
     * Inserts a value into the hash table.
     * @param value value to insert
     */
    void insert(T value);

    /**
     * Reads the value from a hash table from the given index.
     * @param hash value acting as index.
     * @return value at given index.
     */
    T read(int hash);

    /**
     * Gets allocated size of hash table.
     * @return allocated size
     */
    int allocatedSize();

    /**
     * Gets size of hash table.
     * @return size
     */
    int size();
}
