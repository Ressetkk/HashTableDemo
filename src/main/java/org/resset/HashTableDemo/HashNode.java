package org.resset.HashTableDemo;

class HashNode<K, V> {
    K key;
    V value;
    HashNode<K, V> next;
    boolean deletedFlag;

    public HashNode(K key, V value) {
        this.key = key;
        this.value = value;
        this.deletedFlag = false;
    }
}
