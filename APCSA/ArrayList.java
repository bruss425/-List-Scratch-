package APCSA;

public class ArrayList<E> implements List<E> {
  public static final int INITIAL_CAPACITY = 10;
  private int size = 0;

  @SuppressWarnings("unchecked")
  private E[] data = (E[]) new Object[INITIAL_CAPACITY];

  // Constructs an empty list with an initial capacity of ten.
  public ArrayList() { }

  // Constructs an empty list with the specified initial capacity.
  @SuppressWarnings("unchecked")
  public ArrayList(int initialCapacity) {
    data = (E[]) new Object[initialCapacity];
  }

  // Constructs a list containing the elements of the specified collection, in the order they are returned by the collection's iterator.
  public ArrayList(E[] objects) {
    for(int i = 0; i < objects.length; i++) {
      add(objects[i]); // warning: don't use super(objects) // why?
    }
  }

  // Appends the specified element to the end of this list.
  public void add(E e) {
    add(size, e);
  }

  // Returns true if this list contains no elements.
  public boolean isEmpty() {
    return size == 0;
  }

  // Returns the number of elements in this list.
  public int size() {
    return size;
  }

  // Inserts the specified element at the specified position in this list.
  public void add(int index, E e) {
    ensureCapacity();
    for(int i = size - 1; i >= index; i--) {
      data[i+1] = data[i];
    }
    data[index] = e;
    size++;
  }

  // Increases the capacity of this ArrayList instance, if necessary, to ensure that it can hold at least the number of elements specified by the minimum capacity argument.
  @SuppressWarnings("unchecked")
  private void ensureCapacity() {
    if (size >= data.length) {
      E[] newData = (E[])(new Object[size + (size / 2) + 1]);
      System.arraycopy(data, 0, newData, 0, size);
      data = newData;
    }
  }

  // Removes all of the elements from this list.
  @SuppressWarnings("unchecked")
  public void clear() {
    data = (E[])new Object[INITIAL_CAPACITY];
    size = 0;
  }

  // Returns true if this list contains the specified element.
  public boolean contains(E e) {
    for(int i = 0; i < size; i++) {
      if(e.equals(data[i])) return true;
    }
    return false;
  }

  // Returns the element at the specified position in this list.
  public E get(int index) {
    checkIndex(index);
    return data[index];
  }

  // Removes the first occurrence of the specified element from this list, if it is present.
  public boolean remove(E e) {
    for (int i = 0; i < size; i++){
      if(e == data[i]){
        for(int j = i + 1; j < size; j++){
          data[j-1] = data[j];
        }
        data[size] = null;
        size--;
        return true;
      } 
    }
    return false; 
    }

  // Checks if the index in question is a valid index of this ArrayList instance.
  private void checkIndex(int index) {
    if(index < 0 || index >= size)
      throw new IndexOutOfBoundsException("index " + index + " out of bounds");
  }

  // Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.
  public int indexOf(E e) {
    for(int i = 0; i < size; i++){
      if(data[i] == e){
        return i;
      }
    } 
    return -1;
  }

  // Returns the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element.
  public int lastIndexOf(E e) {
    int value = -1;
    for(int i = 0; i < size; i++){
      if(data[i] == e){
        value = i;
      }
    }
    return value;
  }

  // Removes the element at the specified position in this list.
  public E remove(int index) {
    checkIndex(index);
    E copy = data[index];
    for(int i = index + 1; i < size; i++){
      data[i-1] = data[i];
    }
    data[size] = null;
    size--;
   return copy;
  }

  // Replaces the element at the specified position in this list with the specified element.
  public E set(int index, E e) {
    checkIndex(index);
    E copy = data[index];
    data[index] = e;
    return copy;

    // i dont even know if this would work -- and again what do I return? 
  }

  // Returns a comma separated string representation of this ArrayList.
  public String toString() {
    StringBuilder result = new StringBuilder("[");
    for(int i = 0; i < size; i++) {
      result.append(data[i]);
      if (i < size - 1) result.append(", ");
    }
    return result.toString() + "]";
  }

  // Trims the capacity of this ArrayList instance to be the list's current size.
  @SuppressWarnings("unchecked")
  public void trimToSize() {
    if(size != data.length) {
      E[] newData = (E[])(new Object[size]);
      System.arraycopy(data, 0, newData, 0, size);
      data = newData;
    }
  }
}