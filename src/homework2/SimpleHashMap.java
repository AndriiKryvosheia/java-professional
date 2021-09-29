package homework2;

import java.util.Map;

public class SimpleHashMap<K,V> {
    private Node<K, V>[] table = new Node[10];
    int size;

    public V put(K key, V value) {
        int index = Math.abs(key.hashCode() % table.length);

        if(table[index] == null) {
            table[index] = new Node<K, V>(key, value);

            size++;
            return value;
        }

        Node<K, V> node = table[index];
        while(node != null) {
            if(node.getKey().equals(key)) {
                V oldValue =  node.getValue();
                node.setValue(value);

                return oldValue;
            }

            node = node.next;
        }

        table[index] = new Node<>(key, value, table[index]);
        size++;

        return value;
    }

    public V get(K key) {
        int index = Math.abs(key.hashCode() % table.length);
        Node<K, V> node = table[index];
        while(node != null) {
            if(node.getKey().equals(key)) {
                return node.getValue();
            }
            node = node.next;
        }
        return null;
    }

    public V remove(K key) {
        int index = Math.abs(key.hashCode() % table.length);
        Node<K, V> node = table[index];
        Node<K, V> prevNode = null;
        while(node != null) {
            if(node.getKey().equals(key)) {
                V value = node.getValue();
                // Если нужная нода в середине списка,
                // переопределеим в предыдущей ноде следующую за удаляемой
                if (prevNode != null) {
                    prevNode.next = node.next;
                }
                // Если индекс ссылается на нужнную (первую в списке) ноду - заменим на следующую
                if (table[index] == node) {
                    table[index] = node.next;
                }

                return value;
            }
            prevNode = node;
            node = node.next;
        }
        return null;
    }

    @Override
    public String toString() {
        if(size == 0) return "{}";
        String str = "{";

        for(Node<K, V> node : table) {
            if(node != null) {
                while(node != null) {
                    str += node.key + "=" + node.value + ", ";

                    node = node.next;
                }
            }
        }

        str = str.substring(0, str.length() - 2);

        return str + "}";
    }

    private class Node<K, V> implements Map.Entry<K, V> {
        private K key;
        private V value;
        Node<K,V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public V getValue() {
            return this.value;
        }

        @Override
        public V setValue(V value) {
            this.value = value;
            return value;
        }
    }
}
