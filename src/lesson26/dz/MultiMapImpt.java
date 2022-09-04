package lesson26.dz;

import lesson26.MultiMap;

import java.util.*;

import static java.util.Collections.emptyIterator;

public class MultiMapImpt<K, V> extends HashMap<K, V> implements MultiMap<K, V> {
    private HashMap<K, List<V>> multiMap = new HashMap<>();

    Iterator <V> iterator;

    V empty;

    K key1;

    @Override
    public int countValues(K key) {
        return multiMap.get(key).size();
    }

    public V get(Object key) {
        if (multiMap.get(key).size() > 0) {
        return multiMap.get(key).get(multiMap.get(key).size()-1);
        }
        return empty;
    }

    @Override
    public Iterator<V> valuesIterator (K key) {
        if (multiMap.get(key).iterator().hasNext() == false) {
            return emptyIterator();
        }
        if (key1 == null) {
            iterator = multiMap.get(key).iterator();
            key1 = key;
            System.out.println(iterator.next());
        } else if (key1.equals(key)) {
            if (iterator.hasNext()) {
                System.out.println(iterator.next());
            } else {
                System.out.println("Элементы для итерации закончились");
                iterator = emptyIterator();
            }
        } else {
            iterator = multiMap.get(key).iterator();
            key1 = key;
            System.out.println(iterator.next());
        }

        return iterator;
    }

    public V remove(Object key) {
        List<V> values = new ArrayList<>();
        multiMap.put((K) key, values);
        return empty;
    }

    public V put(K key, V value) {
        if (multiMap.containsKey(key)) {
            List<V> values = multiMap.get(key);
            values.add(value);
            multiMap.put(key, values);
        } else {
            ArrayList<V> values = new ArrayList<>();
            values.add(value);
            multiMap.put(key, values);
        }
        return value;
    }

        public void print() {
            for (Entry<K, List<V>> person : multiMap.entrySet()) {
                System.out.println(person.getKey() + " - " + person.getValue());
        }
    }

}
