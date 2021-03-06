package corejava.generics;

import java.util.ArrayList;
import java.util.Optional;

class Table<K extends Comparable, V> {

  private ArrayList<Entry> internalList = new ArrayList<>();

  public V get(K key) {
    return (V) internalList.stream().filter(x -> x.getKey().equals(key)).findAny().orElse(null);
  }

  public void put(K key, V value) {
    Entry newEntry = new Entry(key, value);
    boolean alreadyExists = internalList.contains(newEntry);
    if (!alreadyExists) {
      internalList.add(newEntry);
    }
  }

  public void remove(K key) {
    Optional<Entry> entry = internalList.stream().filter(x -> x.key.equals(key)).findFirst();

    if (entry.isPresent()) {
      internalList.remove(entry.get());
    }
  }

  public class Entry implements Comparable<Entry> {
    private V value;
    private K key;

    public Entry(K key, V value) {
      this.setKey(key);
      this.setValue(value);
    }

    public K getKey() {
      return key;
    }

    public void setKey(K key) {
      this.key = key;
    }

    public V getValue() {
      return value;
    }

    public void setValue(V value) {
      this.value = value;
    }

    @Override
    public int compareTo(Entry o) {
      return this.getKey().compareTo(o.getKey());
    }
  }

}
