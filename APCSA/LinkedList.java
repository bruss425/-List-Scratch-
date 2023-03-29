package APCSA;

public class LinkedList<E> implements List<E> {
  private Node<E> head, tail;
  private int size = 0;

  public LinkedList() {
  }

  public LinkedList(E[] objects) {
    for (int i = 0; i < objects.length; i++) {
      add(objects[i]);
    }
  }

  public void add(E e) {
    add(size, e);
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int size() {
    return size;
  }

  public boolean remove(E e) {
    if (indexOf(e) >= 0) {
      remove(indexOf(e));
      return true;
    } else
      return false;
  }

  // Insert at front of list
  public void addFirst(E e) {
    Node<E> newNode = new Node<>(e);
    newNode.next = head;
    head = newNode;
    size++;

    if (tail == null)
      tail = head;
  }

  public void addLast(E e) {
    Node<E> newNode = new Node<>(e);

    if (tail == null) {
      head = tail = newNode;
    } else {
      tail.next = newNode;
      tail = tail.next;
    }

    size++;
  }

  public void add(int index, E e) {
    if (index == 0)
      addFirst(e);
    else if (index >= size)
      addLast(e);
    else {
      Node<E> current = head;
      for (int i = 1; i < index; i++) {
        current = current.next;
      }
      Node<E> temp = current.next;
      current.next = new Node<E>(e);
      (current.next).next = temp;
      size++;
    }
  }

  public E getFirst() {
    if (size == 0)
      return null;
    return head.element;
  }

  public E getLast() {
    if (size == 0)
      return null;
    return tail.element;
  }

  public E removeFirst() {
    if (size == 0)
      return null;
    else {
      Node<E> temp = head;
      head = head.next;
      size--;
      if (head == null)
        tail = null;
      return temp.element;
    }
  }

  public E removeLast() {
    if (size == 0)
      return null;
    else if (size == 1) {
      Node<E> temp = head;
      head = tail = null;
      size = 0;
      return temp.element;
    } else {
      Node<E> current = head;

      for (int i = 0; i < size - 2; i++) {
        current = current.next;
      }

      Node<E> temp = tail;
      tail = current;
      tail.next = null;
      size--;
      return temp.element;
    }
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder("[");

    Node<E> current = head;
    for (int i = 0; i < size; i++) {
      result.append(current.element);
      current = current.next;
      if (current != null) {
        result.append(", ");
      }
    }
    result.append("]");
    return result.toString();
  }

  public void clear() {
    size = 0;
    head = tail = null;
  }

  // Removes the element at the specified position in this list.
  public E remove(int index) {
    if(index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Index " + index + " out of bounds.");
    }
    if(index == 0) return removeFirst();
    if(index == size - 1) return removeLast();

    Node<E> current = head;

    for (int i = 0; i < index - 1; i++) {
      current = current.next;
    }

    E removedObject = current.next.element;
    if (current.next.next != null) {
      current.next = current.next.next;
      size--;
    }

    return removedObject;
  }

  // Returns true if this list contains the specified element.
  public boolean contains(E e) {
    Node<E> current = head;

    for (int i = 0; i < size; i++) {
      if (current.element == e) {
        return true;
      }
      current = current.next;
    }
    return false;
  }

  // Returns the element at the specified position in this list.
  public E get(int index) {
    if(size < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Index " + index + " out of bounds.");
    }
    Node<E> current = head;
    for (int i = 0; i < index; i++) {
      current = current.next;
    }
    return current.element;
  }

  // Returns the index of the first occurrence of the specified element in this
  // list,
  // or -1 if this list does not contain the element.
  public int indexOf(E e) {
    Node<E> current = head;
    for (int i = 0; i < size; i++) {
      if (current.element == e) {
        return i;
      }
      current = current.next;
    }
    return -1;
  }

  // Returns the index of the last occurrence of the specified element in this
  // list,
  // or -1 if this list does not contain the element.
  public int lastIndexOf(E e) {
    int value = -1;
    Node<E> current = head;
    for (int i = 0; i < size; i++) {
      if (e == current.element) {
        value = i;
      }
      current = current.next;
    }
    return value;
  }

  // Replaces the element at the specified position in this list with the
  // specified element.
  // Returns the previous element that was replaced.
  public E set(int index, E e) {
    E oldValue = get(index);
    if(index == 0) head.element = e;
    else if (index == size - 1) tail.element = e;
    else {
      Node<E> node = head;
      // if(index > size - 1){
      // return null;
      // } // HOW WOULD I GET AN OUT OF BOUNDS 
      for (int i = 1; i < index; i++) {
        node = node.next;
      }
      node.element = e;
    }
    return oldValue;
  }

  // What's the advantage of making an inner class as static with Java?
  // https://stackoverflow.com/q/16147405
  private static class Node<E> {
    E element;
    Node<E> next;

    public Node(E element) {
      this.element = element;
    }
  }
}
