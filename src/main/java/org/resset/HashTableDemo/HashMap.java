package org.resset.HashTableDemo;

import java.util.ArrayList;

public class HashMap<K, V> {
    private ArrayList<HashNode<K, V>> bucketArray;
    private int numBuckets;
    private int size;
    final double A = 0.61803;

    private int hash(K key) {
        int hashCode = Math.abs(key.hashCode()); // get unique integer value for key regardless of type
        return hashCode % numBuckets;
    }

    public HashMap() {
        bucketArray = new ArrayList<>();
        numBuckets = 10;
        size = 0;

        for (int i = 0; i < numBuckets; i++) {
            bucketArray.add(null);
        }
    }
    public int getSize() {
        return  size;
    }

    public V get(K key) {
        int bucketIndex = hash(key);
        HashNode<K, V> head = bucketArray.get(bucketIndex);
        while (head != null)
        {
            if (head.key.equals(key))
                return head.value;
            head = head.next;
        }
        return null;
    }

    public void add(K key, V value) {
        int bucketIndex = hash(key);
        HashNode<K, V> head = bucketArray.get(bucketIndex);
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        size++;
        head = bucketArray.get(bucketIndex);
        HashNode<K, V> newNode = new HashNode<>(key, value);
        newNode.next = head;
        bucketArray.set(bucketIndex, newNode);

        if ((1.0 * size) / numBuckets >= 0.7) {
            ArrayList<HashNode<K, V>> temp = bucketArray;
            bucketArray = new ArrayList<>();
            numBuckets = 2 * numBuckets;
            size = 0;
            for (int i = 0; i < numBuckets; i++)
                bucketArray.add(null);

            for (HashNode<K, V> headNode : temp) {
                while (headNode != null) {
                    add(headNode.key, headNode.value);
                    headNode = headNode.next;
                }
            }
        }
    }

    public V remove(K key) {
        int bucketIndex = hash(key);
        HashNode<K, V> head = bucketArray.get(bucketIndex);
        HashNode<K, V> prev = null;
        while (head != null)
        {
            if (head.key.equals(key))
                break;
            prev = head;
            head = head.next;
        }
        if (head == null)
            return null;
        size--;
        if (prev != null)
            prev.next = head.next;
        else
            bucketArray.set(bucketIndex, head.next);

        return head.value;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }
}
