package ru.spbau.mit.francleene.ListMap;

/**
 * ListMap is a map based on LinkedList.
 * It implements all basic map functionality:
 * - get size, O(1);
 * - check if an element with the given key exists in Map, O(n);
 * - return value of an element with the given key, O(n);
 * - add an element with the given key and value into Map, O(n);
 * - remove element with the given key, O(n);
 * - clear all elements, O(1).
 */
public class ListMap {
    private int size;
    private ListMapNode head;

    /**
     * Empty list contains only one element - the head (the element with null key and null value)
     */
    public ListMap() {
        head = new ListMapNode();
    }

    /**
     * If the node isn't null then set its next to newNext
     */
    private void setNext(ListMapNode node, ListMapNode newNext) {
        if (node != null) {
            node.next = newNext;
        }
    }

    /**
     * If the node isn't null then set its prev to newPrev
     */
    private void setPrev(ListMapNode node, ListMapNode newPrev) {
        if (node != null) {
            node.prev = newPrev;
        }
    }

    /**
     * Add an element with the given key and value into ListMap.
     *
     * Create a node with the given key and value and add this node right after head
     * Size of ListMap increments by 1
     */
    private void add(String key, String value) {
        ListMapNode newNode = new ListMapNode(key, value, head, head.next);

        setNext(newNode.prev, newNode);
        setPrev(newNode.next, newNode);

        size++;
    }

    /**
     * Check if the Strings store the same value or the both are null
     */
    private boolean isEquals(String firstString, String secondString) {
        return firstString != null ? firstString.equals(secondString) : secondString == null;
    }

    /**
     * Find an element with the given key.
     * If an element with the given key doesn't exist in ListMap, return the head
     *
     * Find(...) starts with a node right after head and iterates through the whole list
     * trying to find an element with the given key.
     * If an element with the given key doesn't exist in ListMap, return the head
     */
    private ListMapNode find(String key) {
        ListMapNode ansNode = head;

        for (ListMapNode node = head.next; node != null; node = node.next) {
            if (isEquals(key, node.key)) {
                ansNode = node;
                break;
            }
        }

        return ansNode;
    }

    /**
     * Exclude the node from ListMap.
     *
     * Connect the previous node with the next node.
     * So the node is excluded from the list.
     */
    private void delete(ListMapNode node) {
        setNext(node.prev, node.next);
        setPrev(node.next, node.prev);
    }

    /**
     * Exclude an element with the given key from ListMap.
     *
     * Find an element with the given key in ListMap.
     * If such element was found, exclude it from ListMap.
     */
    private ListMapNode delete(String key) {
        ListMapNode node = find(key);

        if (node != head) {
            delete(node);
            size--;
        }

        return node;
    }

    /**
     * Return the current number of elements in the ListMap.
     */
    public int size() {
        return size;
    }

    /**
     * Check if ListMap contains an element with the given key and return:
     * - true, if ListMap contains such element;
     * - false, otherwise
     */
    public boolean contains(String key) {
        return find(key) != head;
    }

    /**
     * Get the value of an element with the given key.
     *
     * Return:
     * - value of an element with the given key, if ListMap contains such element;
     * - null, otherwise
     */
    public String get(String key) {
        return find(key).value;
    }

    /**
     * Add an element with the given key and value into ListMap and return:
     * - the previous value of an element with the given key, if ListMap contains such key;
     * - null, otherwise
     */
    public String put(String key, String value) {
        String previousValue = remove(key);

        add(key, value);

        return previousValue;
    }

    /**
     * Remove an element with the given key from ListMap and return:
     * - the value of an element with the given key, if ListMap contains such element;
     * - null, otherwise
     */
    public String remove(String key) {
        return delete(key).value;
    }

    /**
     * Empty ListMap. Remove all elements from ListMap.
     */
    public void clear() {
        head = new ListMapNode();
        size = 0;
    }

    /**
     * Return all elements ListMap stores.
     *
     * Every element is represented as an array of length 2:
     * - there's the value of an element at the first position;
     * - there's the key of an element at the second position.
     */
    public String[][] toArray() {
        String[][] data = new String[size][2];

        ListMapNode node = head.next;
        for (int i = 0; i < size; i++, node = node.next) {
            data[i][0] = node.key;
            data[i][1] = node.value;
        }

        return data;
    }

    /**
     * ListMapNode represents an node of ListMap and store:
     * - a value of an element;
     * - a key of an element;
     * - a reference to the previous node;
     * - a reference to the next node.
     */
    private class ListMapNode {
        private String key, value;
        private ListMapNode prev, next;

        /**
         * Constructor without parameters. Store an element with:
         * - null value;
         * - null key;
         * - null reference to previous node (haven't the previous node);
         * - null reference to next node (haven't the next node).
         */
        ListMapNode() {
            this(null, null, null, null);
        }

        /**
         * Constructor that get:
         * - initial key;
         * - initial value;
         * - initial reference to the previous node;
         * - initial reference to the next node.
         */
        ListMapNode(String initKey, String initValue, ListMapNode initPrev, ListMapNode initNext) {
            key   = initKey;
            value = initValue;
            next  = initNext;
            prev  = initPrev;
        }
    }
}
