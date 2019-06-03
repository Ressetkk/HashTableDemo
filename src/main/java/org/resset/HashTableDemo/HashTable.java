package org.resset.HashTableDemo;

import java.util.ArrayList;

public class HashTable<K, V> {
    private ArrayList<HashNode<K, V>> array;
    private int capacity;

    private int hash(K key, int i) {
        int hashCode = Math.abs(key.hashCode()); // get unique absolute integer value for key regardless of type
        return ((hashCode % capacity) + i) % capacity;
    }

    public HashTable() {
        capacity = 5;
        array = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            array.add(null);
        }
    }

    public V get(K key) {
        int i = 0;
        while (i < capacity) {
            int index = hash(key, i);
            HashNode<K, V> node = array.get(index);
            if (node == null) {
                break;
            }
            if (node.key.hashCode() == key.hashCode()) {
                InputHelper.getInstance().infoField.setValue(InputHelper.appendText(InputHelper.getInstance().infoField.getValue(),
                        "Found key " + key + " at hashed index " + index + ". Returned value is: " + node.value));
                return node.value;
            } else {
                InputHelper.getInstance().infoField.setValue(InputHelper.appendText(InputHelper.getInstance().infoField.getValue(),
                        "Collision Detected: hashCode "+ index + " for key " + key + " incrementing probe value by 1."));
                i++;
            }
        }
        InputHelper.getInstance().infoField.setValue(InputHelper.appendText(InputHelper.getInstance().infoField.getValue(),
                "Key " + key + " was not found in Hash Table!"));
        return null;
    }

    public void add(K key, V value) {
        int i = 0;
        while (i < capacity) {
            int index = hash(key, i);
            HashNode<K, V> node = array.get(index);
            if ((node == null) || (node.deletedFlag)) {
                InputHelper.getInstance().infoField.setValue(InputHelper.appendText(InputHelper.getInstance().infoField.getValue(),
                        "Added key " + key + " to hashed index " + index));
                array.set(index, new HashNode<>(key, value));
                return;
            }
            else {
                InputHelper.getInstance().infoField.setValue(InputHelper.appendText(InputHelper.getInstance().infoField.getValue(),
                        "Collision Detected: hashCode "+ index + " for key " + key + " incrementing probe value by 1."));
                i++;
            }
        }
        InputHelper.getInstance().infoField.setValue(InputHelper.appendText(InputHelper.getInstance().infoField.getValue(),
                "Hash Table is full! Can't add new keys!"));
    }

    public V remove(K key) {
        int i = 0;
        while (i < capacity) {
            int index = hash(key, i);
            HashNode<K, V> node = array.get(index);
            if (node == null) {
                break;
            }
            if (node.key.hashCode() == key.hashCode()) {
                InputHelper.getInstance().infoField.setValue(InputHelper.appendText(InputHelper.getInstance().infoField.getValue(),
                        "Deleted key " + key + " at hashed index " + index + "with value: " + node.value));
                node.deletedFlag = true;
                return node.value;
            } else {
                InputHelper.getInstance().infoField.setValue(InputHelper.appendText(InputHelper.getInstance().infoField.getValue(),
                        "Collision Detected: hashCode "+ index + " for key " + key + " incrementing probe value by 1."));
                i++;
            }
        }
        InputHelper.getInstance().infoField.setValue(InputHelper.appendText(InputHelper.getInstance().infoField.getValue(),
                "There's nothing to delete!"));
        return null;
    }

    public String returnHashTable() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < capacity; i++) {
            HashNode<K, V> node = array.get(i);
            if ((node == null) || (node.deletedFlag)) {
                sb.append(i);
                sb.append(" : null\n");
            } else {
                sb.append(i);
                sb.append(" : key : ");
                sb.append(node.key);
                sb.append(" | value : ");
                sb.append(node.value);
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
