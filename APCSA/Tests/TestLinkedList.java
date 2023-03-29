package APCSA.Tests;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

import APCSA.List;
import APCSA.LinkedList;

public class TestLinkedList {

  // Add test variables here!
  
  @Before
  public void setUp() {
    
  }

  @Test
  public void testDefaultConstructor() {
    // capacity should be 10
    // data is initialized to object array type E length 10
  }

  @Test
  public void testOverloadedConstructor() {
    // the input array should fill the data
  }

  @Test
  public void testAddFirst() {
    LinkedList<String> list = new LinkedList<>();
    list.add("Cat");
    list.add("Mouse");
    list.add("Dog");
    list.addFirst("Bird");
    assertEquals("Bird", list.get(0));
    assertEquals(4, list.size());
  }

  @Test
  public void testAddLast() {
    LinkedList<String> list = new LinkedList<>();
    list.add("Cat");
    list.add("Mouse");
    list.add("Dog");
    list.addLast("Bird");    
    assertEquals("Bird", list.getLast());
    assertEquals(4, list.size());
  }

  @Test
  public void testAddIndex() {
    List<Integer> v1 = new LinkedList<>();
    v1.add(100); // setup
    v1.add(101); // setup
    v1.add(0, 50); // add front

    assertEquals(3, v1.size());
    assertEquals("[50, 100, 101]", v1.toString());
    assertEquals(50, (int)v1.get(0));

    v1.add(3, 40); // add end
    assertEquals("[50, 100, 101, 40]", v1.toString());

    v1.add(1, Integer.MAX_VALUE); // add middle
    assertEquals("[50, 2147483647, 100, 101, 40]", v1.toString());
    
    v1.add(0, Integer.MAX_VALUE); // add front again
    assertEquals("[2147483647, 50, 2147483647, 100, 101, 40]", v1.toString());
    assertEquals(6, v1.size());
  }

  @Test
  public void testGetFirst() {
    LinkedList<String> list = new LinkedList<>();
    list.add("Cat");
    list.add("Mouse");
    list.add("Dog");
    assertEquals("Cat", list.getFirst());
    assertEquals(3, list.size());
  }

  @Test
  public void testGetLast() {
    LinkedList<String> list = new LinkedList<>();
    list.add("Cat");
    list.add("Mouse");
    list.add("Dog");
    assertEquals("Dog", list.getLast());
    assertEquals(3, list.size());
  }

  @Test
  public void testRemoveFirst() {
    LinkedList<String> list = new LinkedList<>();
    list.add("Cat");
    list.add("Mouse");
    list.add("Dog");

    String first = list.removeFirst();
    assertEquals("Cat", first);
    assertEquals(2, list.size());
  }

  @Test
  public void testRemoveLast() {
    LinkedList<String> list = new LinkedList<>();
    list.add("Cat");
    list.add("Mouse");
    list.add("Dog");

    String last = list.removeLast();
    assertEquals("Dog", last);
    assertEquals(2, list.size());
  }

  @Test
  public void testRemove() {
    List<String> v1 = new LinkedList<>();
    v1.add("Cat");
    v1.add("Cat");
    v1.add("Cat");
    v1.add("Dog");
    assertEquals(v1.remove("Cat"), true);
    assertEquals(v1.remove("Dog"), true);
    assertEquals(v1.remove("Dog"), false);
    assertEquals(v1.remove("Mouse"), false);
    assertEquals(v1.size(), 2);

    String first = v1.get(0);
    assertEquals(first, v1.remove(0));
    try {
      v1.remove(3);
      fail("Can't remove bad index");
    } catch(Exception ex) {
      assertEquals(ex.getClass(), IndexOutOfBoundsException.class);
    }   
  }

  @Test
  public void testToString() {
    List<Integer> v1 = new LinkedList<>();
    assertEquals(v1.toString(), "[]");
    v1.add(1);
    v1.add(2);
    v1.add(4);
    assertEquals(v1.toString(), "[1, 2, 4]");
  }

  @Test
  public void testClear() {
    List<Integer> v1 = new LinkedList<>();
    v1.clear();
    assertEquals(0, v1.size());
    assertEquals("[]", v1.toString());
    v1.add(4);
    v1.add(1234);
    v1.clear();
    assertEquals(0, v1.size());
    assertEquals("[]", v1.toString());    
  }

  @Test
  public void testContains() {
    List<String> v1 = new LinkedList<>();
    v1.add("Cat");
    v1.add("Bat");
    assertEquals(v1.contains("Cat"), true);
    assertEquals(v1.contains("Bat"), true);
    assertEquals(v1.contains("cat"), false);
    assertEquals(v1.contains("catch"), false);
    assertEquals(v1.contains("dog"), false);

    v1.add("Mat");
    assertEquals(v1.contains("Mat"), true);
    v1.remove("Mat");
    assertEquals(v1.contains("Mat"), false);    
  }

  @Test
  public void testGet() {
    List<String> v1 = new LinkedList<>();
    v1.add("Cat");
    assertEquals(v1.get(0), "Cat");

    List<Integer> v2 = new LinkedList<>();
    v2.add(4);
    v2.add(0);
    v2.remove(0);
    assertEquals(v2.contains(4), false);
    assertEquals(v2.get(0), (Integer)0);
    v2.add(0);
    assertEquals(v2.get(1), (Integer)0);
    assertEquals(v2.size(), 2);    
  }

  @Test
  public void testIndexOf() {
    List<String> v1 = new LinkedList<>();
    v1.add("Cat");
    v1.add("Cat");
    v1.add("Cat");
    v1.add("Dog");
    assertEquals(v1.indexOf("Cat"), 0);
    assertEquals(v1.indexOf("Dog"), 3);
    assertEquals(v1.indexOf("Mouse"), -1);    
  }

  @Test
  public void testLastIndexOf() {
    List<String> v1 = new LinkedList<>();
    v1.add("Cat");
    v1.add("Cat");
    v1.add("Cat");
    v1.add("Dog");
    assertEquals(v1.lastIndexOf("Cat"), 2);
    assertEquals(v1.lastIndexOf("Dog"), 3);
    assertEquals(v1.lastIndexOf("Mouse"), -1);       
  }

  @Test
  public void testSet() {
    List<String> v1 = new LinkedList<String>();
    v1.add("dog");
    String result = v1.set(0, "cat");
    assertEquals("dog", result);
    assertEquals("cat", v1.get(0));
    assertEquals(1, v1.size());

    try {
      v1.set(3, "mouse");
      fail("Can't set invalid index");
    } catch(Exception ex) {
      assertEquals(IndexOutOfBoundsException.class, ex.getClass());
    }
  }

  @Test
  public void testIterator() {
    
  }

  @After
  public void tearDown() {
    // Add teardown code here!
  }
}