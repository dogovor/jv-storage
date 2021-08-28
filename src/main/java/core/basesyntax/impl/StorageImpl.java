package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int MAX_SIZE = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_SIZE];
        values = (V[]) new Object[MAX_SIZE];
        size = 0;

    }

    @Override
    public void put(K key, V value) {
        if (size < MAX_SIZE) {
            for (int i = 0; i < size; i++) {
                if (key == keys[i] || (key != null && key.equals(keys[i]))) {
                    values[i] = value;
                    size--;
                }
            }
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < MAX_SIZE; i++) {
            if (key == keys[i] || (key != null && key.equals(keys[i]))) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        for (int i = 0; i < MAX_SIZE; i++) {
            if (values[i] == null) {
                return i;
            }
        }
        return 0;
    }
}

