import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.util.Map;
import java.util.HashMap;

import APCSA.Tests.TestArrayList;
import APCSA.Tests.TestLinkedList;


public class TestRunner {
  public static void main() {

    Map<Class, Result> tests = new HashMap<>();

    tests.put(TestArrayList.class, JUnitCore.runClasses(TestArrayList.class));
    tests.put(TestLinkedList.class, JUnitCore.runClasses(TestLinkedList.class));
    
    for (Map.Entry<Class, Result> result : tests.entrySet()) {
      Class testName = result.getKey();
      Result test = result.getValue();
      System.out.println("\nTesting " + testName.getSimpleName());
      if(test.wasSuccessful()) {
        System.out.println(testName + " passed.");
      } else {
        System.out.println(testName + " failed with the following:");
        for(Failure failure : test.getFailures()) {
          System.out.println(failure.toString());
        }
      }
    }
  }
}