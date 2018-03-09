package practice;

import java.util.Scanner;

/**
 * Created by zxz on 2015/2/3.
 */
public class DNASorting1007 {
  static int strLength = 0;
  static int strCount = 0;

  public static void main(String[] args) {
    Scanner scr = new Scanner(System.in);
    int readLine = 0;
    String[] dnaStrArry = null;

    aa:
    while (scr.hasNextLine()) {
      if (readLine == 0) {
        strLength = scr.nextInt();
        strCount = scr.nextInt();
        scr.nextLine();
        dnaStrArry = new String[strCount];
      } else if (readLine <= strCount) {
        dnaStrArry[readLine - 1] = scr.nextLine();
      }
      if (readLine == strCount) {
        scr.close();
        break aa;
      }
      readLine++;
    }


    for (int i = 0; i < dnaStrArry.length; i++) {
      for (int j = i + 1; j < dnaStrArry.length; j++) {
        if (!leftIsMoreSorted(dnaStrArry[i], dnaStrArry[j])) {
          String temStr = dnaStrArry[i];
          dnaStrArry[i] = dnaStrArry[j];
          dnaStrArry[j] = temStr;
        }
      }
      System.out.println(dnaStrArry[i]);
    }
  }

  private static boolean leftIsMoreSorted(String leftStr, String rightStr) {
    boolean isMoreSorted = false;
    if (getUnSorteddNum(leftStr) <= getUnSorteddNum(rightStr)) {
      isMoreSorted = true;
    }
    return isMoreSorted;
  }


  private static int getUnSorteddNum(String dnaStr) {
    int unSortedNum = 0;
    for (int readLocation = 0; readLocation < dnaStr.length(); readLocation++) {
      for (int campareChar = readLocation + 1; campareChar < dnaStr.length(); campareChar++) {
        char a = dnaStr.charAt(readLocation);
        char b = dnaStr.charAt(campareChar);
        if (compareChar(a, b)) {
          unSortedNum++;
        }
      }
    }
    return unSortedNum;
  }

  private static boolean compareChar(char a, char b) {
    int eInt = 0;
    int fInt = 0;
    boolean aBiggerThanB = false;
    switch (a) {
      case 'A':
        eInt = 1;
        break;
      case 'C':
        eInt = 2;
        break;
      case 'G':
        eInt = 3;
        break;
      case 'T':
        eInt = 4;
        break;
    }
    switch (b) {
      case 'A':
        fInt = 1;
        break;
      case 'C':
        fInt = 2;
        break;
      case 'G':
        fInt = 3;
        break;
      case 'T':
        fInt = 4;
        break;
    }
    if (eInt > fInt) {
      aBiggerThanB = true;
    }
    return aBiggerThanB;
  }
}
