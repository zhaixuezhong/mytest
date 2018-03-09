

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zxz on 2015/1/8.
 */
public class ideaTest {

  private int i;

  public static void main(String args[]) {
    int i = 5;
    System.out.println("aaaaaaaaaaaaaaaaaaaa");
    System.out.println("bbbbbbbbbbbbbbbbbb");
    System.out.println("cccccccccccccccccccc");
    System.out.println("dddddddddddddddddd");
    System.out.println("eeeeeeeeeeeeeee");
    System.out.println("fffffffffffffffffff");
    System.out.println("gggggggggggggggggg");
    System.out.println("hhhhhhhhhhhhhhhhhhh");
    System.out.println("iiiiiiiiiiiiiiiiiii");
    System.out.println("i的值是" + i);
    printInt();
  }

  /*
  打印
   */
  private static void printInt() {
    System.out.println("打印");
  }


  private static void printString(String s) {


    Map<String, Object> map = new HashMap<String, Object>();
    map.put("", "");


  }

  ideaTest component;


  LinkedList list = new LinkedList();


  @Test
  public void myTest() {

    String myStr[] = {"", ""};
    int j = 0;
    myStr[j++] = "aaa";
    myStr[j] = "bbb";
    System.out.println(myStr[0]);
    System.out.println(myStr[1]);

    notEmpty.signal();

    List<String> names = new LinkedList<>();

// ... add some names to the collection
    names.forEach(name -> System.out.println(name));

  }

  Lock lock = new ReentrantLock();

  Condition notEmpty = lock.newCondition();

  Callable callable;

}


