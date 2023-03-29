package APCSA.Tests;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

import APCSA.ArrayList;

public class TestArrayList {

  // Add test variables here!
  
  @Before
  public void setUp() {
    
  }

  @Test
  public void testDefaultConstructor() {
    // capacity should be 10
    // data is initialized to object array type E length 16
  }

  @Test
  public void testOverloadedConstructor() {
    // the input array should fill the data
  }

  @Test
  public void testAddIndex() {
    ArrayList<Integer> v1 = new ArrayList<>();
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
  public void testClear() {
    ArrayList<Integer> v1 = new ArrayList<>();
    v1.clear();
    assertEquals(v1.size(), 0);
    assertEquals(v1.toString(), "[]");
    v1.add(4);
    v1.add(1234);
    v1.clear();
    assertEquals(v1.size(), 0);
    assertEquals(v1.toString(), "[]");
  }

  @Test
  public void testContains() {
    ArrayList<String> v1 = new ArrayList<>();
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
    ArrayList<String> v1 = new ArrayList<>();
    v1.add("Cat");
    assertEquals(v1.get(0), "Cat");

    ArrayList<Integer> v2 = new ArrayList<>();
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
    ArrayList<String> v1 = new ArrayList<>();
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
    ArrayList<String> v1 = new ArrayList<>();
    v1.add("Cat");
    v1.add("Cat");
    v1.add("Cat");
    v1.add("Dog");
    assertEquals(v1.lastIndexOf("Cat"), 2);
    assertEquals(v1.lastIndexOf("Dog"), 3);
    assertEquals(v1.lastIndexOf("Mouse"), -1);    
  }

  @Test
  public void testRemove() {
    ArrayList<String> v1 = new ArrayList<>();
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
  public void testSet() {
    ArrayList<String> v1 = new ArrayList<>();
    String dog = new String("dog");
    v1.add(dog);
    String result = v1.set(0, "cat");    
    assertEquals(dog, result);
  }

  @Test
  public void testToString() {
    ArrayList<Integer> v1 = new ArrayList<>();
    assertEquals(v1.toString(), "[]");
    v1.add(1);
    v1.add(2);
    v1.add(4);
    assertEquals(v1.toString(), "[1, 2, 4]");
  }

  @Test
  public void testTrimToSize() {
    // requires reflection, skipping for now
  }

  @Test
  public void testIterator() {
    // not yet
  }

  @After
  public void tearDown() {
    // Add teardown code here!
  }
}
