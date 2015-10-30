package edu.berkeley.nlp;

import edu.berkeley.nlp.assignments.POSTaggerTester;

/**
 * @author Dan Klein
 */
public class Test<E> {
  public static void main(String[] args) {
      POSTaggerTester.main(new String[]{
              "-path",
              ".\\data\\wsj\\"
              //,"-verbose"
      });
      System.out.println("Test PASSED.");
  }
}