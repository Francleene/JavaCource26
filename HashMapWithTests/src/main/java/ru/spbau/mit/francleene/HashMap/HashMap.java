package ru.spbau.mit.francleene.HashMap;

import ru.spbau.mit.francleene.ListMap.ListMap;

/**
 * HahsMap implements an associative array data type with functionality:
 * - get size, O(1);
 * - check if an element with the given key exists in Map, O(1);
 * - return value of an element with the given key, O(1);
 * - add an element with the given key and value into Map, O(1);
 * - remove element with the given key, O(1);
 * - clear all elements, O(capacity), O(n).
 */
public class HashMap {
    private int size;
    private int capacity;

    private ListMap[] data;

    /**
     * A constructor of HashMap without parameters
     * Default value of capacity is 8
     */
    public HashMap() {
        this(8);
    }

    /**
     * A constructor of HashMap that get one parameter - initial capacity
     *
     * Constructor initialize capacity of HashMap with value the user give (initCapacity)
     * and constuct ListMaps for every cell of the data array
     */
    public HashMap(int initCapacity) {
        capacity = initCapacity;

        data = new ListMap[capacity];
        for (int i = 0; i < capacity; i++) {
            data[i] = new ListMap();
        }
    }

    /**
     *  Return the current number of elements HashMap stores
     */
    public int size() {
        return size;
    }

    /**
     * Check if HashMap contains the given key and return:
     * - true,  if there is an element with the given key (key) in HashMap
     * - false, otherwise
     */
    public boolean contains(String key) {
        return data[getHashCode(key)].contains(key);
    }

    /**
     * Return:
     * - the value of the element with the given key, if such elements exists
     * - null, otherwise
     */
    public String get(String key) {
        return data[getHashCode(key)].get(key);
    }

    /**
     * Add an element with the given key and value to HashMap and return:
     * - the value of previous element with the given key if such element exists;
     * - null, otherwise
     */
    public String put(String key, String value) {
        if (size == capacity) {
            rebuild(2 * capacity);
        }

        if (!contains(key)) {
            size++;
        }

        return data[getHashCode(key)].put(key, value);
    }

    /**
     * Remove the element with the given key and return:
     * - the value of removed element, if such element exists,
     * - null, otherwise
     */
    public String remove(String key) {
        if (contains(key)) {
            size--;
        }

        return data[getHashCode(key)].remove(key);
    }

    /**
     * Empty HashMap. Remove all elements from HashMap.
     */
    public void clear() {
        for (ListMap listMap : data) {
            listMap.clear();
        }

        size = 0;
    }

    /**
     * Rebuild HashMap data array with a new capacity.
     *
     * Function creates a new array with the required capacity
     * and adds all the elements into the new array;
     */
    private void rebuild(int newCapacity) {
        ListMap[] newData = new ListMap[newCapacity];
        for (int i = 0; i < newCapacity; i++) {
            newData[i] = new ListMap();
        }

        int hashCode;
        String key, value;

        for (ListMap list : data) {
            for (String[] pair : list.toArray()) {
                key = pair[0];
                value = pair[1];
                hashCode = getHashCode(key, newCapacity);

                newData[hashCode].put(key, value);
            }
        }

        data = newData;
        capacity = newCapacity;
    }

    /**
     * Get hashCode of the String with default modulo (= current_capacity)
     * Value of hashCode is from 0 to (current_capacity - 1)
     */
    private int getHashCode(String string) {
        return getHashCode(string, capacity);
    }

    /**
     * Get hashCode of the String with modulo range.
     * Value of hash code is from 0 to (range - 1)
     *
     * Hash code of null string is always 0
     * Hash code of empty string is always 0
     */
    private int getHashCode(String string, int range) {
        if (string == null) {
            return 0;
        }

        int hashCode = 0;
        for (char symbol : string.toCharArray()) {
            hashCode = (int)((31L * hashCode + symbol) % range);
        }

        return hashCode;
    }
}
