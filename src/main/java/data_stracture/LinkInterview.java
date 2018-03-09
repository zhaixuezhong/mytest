package data_stracture;




import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;



/**
 * Created by zhaixuezhong on 11/25/16.
 */
public class LinkInterview {


}


class LinkTest {

  @Test

  public Node nodeReverse(Node head) {

    if (head == null || head.next == null) {
      return head;
    }

    Node current = head;
    Node next = null;
    Node reverseNode = null;


    while (current != null) {
      next = current.next;

      current.next = reverseNode;
      reverseNode = current;

      current = next;

    }

    return null;
  }


  @Test
  public void fILO1(Node head) {
    Stack<Node> stackNode = new Stack<Node>();
    if (head == null) {
      return;
    }
    Node current = head;

    while (current != null) {
      stackNode.push(current);
      current = current.next;
    }

    while (stackNode.size() > 0) {
      System.out.println(stackNode.pop().value);
    }


  }

  @Test
  public void fILO2(Node head) {
    if (head == null) {
      return;
    }

    fILO2(head.next);
    System.out.println(head.value);
  }


  @Test
  public boolean checkCircle(Node head) {
    if (head == null) {
      return false;
    }

    Node first = head;
    Node second = head;

    while (second != null) {
      first = first.next;
      second = second.next.next;


      if (first == second) {
        return true;
      }
    }

    return false;

  }


  @Test
  public void listTest() {
    List list = Collections.synchronizedList(new LinkedList<String>());
    List list2 = Collections.synchronizedList(new ArrayList<String>());


    ListIterator<String> listIterator = list.listIterator();


    while (listIterator.hasNext()) {


    }


  }
}


class Node {

  int value;
  Node next;


  public Node(int value, Node next) {
    this.value = value;
    this.next = next;

  }

}


class MinStack {

  private Stack<Integer> stack = new Stack<Integer>();
  private Stack<Integer> minStack = new Stack<Integer>(); //辅助栈：栈顶永远保存stack中当前的最小的元素


  public void push(int data) {
    stack.push(data);  //直接往栈中添加数据

    //在辅助栈中需要做判断
    if (minStack.size() == 0 || data < minStack.peek()) {
      minStack.push(data);
    } else {
      minStack.push(minStack.peek());   //【核心代码】peek方法返回的是栈顶的元素
    }
  }

  public int pop() throws Exception {
    if (stack.size() == 0) {
      throw new Exception("栈中为空");
    }

    int data = stack.pop();
    minStack.pop();  //核心代码
    return data;
  }

  public int min() throws Exception {
    if (minStack.size() == 0) {
      throw new Exception("栈中空了");
    }
    return minStack.peek();
  }

  public static void main(String[] args) throws Exception {
//        MinStack stack = new MinStack();
//        stack.push(4);
//        stack.push(3);
//        stack.push(5);
//
//        System.out.println(stack.min());
//        stack.pop();
//        System.out.println(stack.min());
//        stack.pop();
//        System.out.println(stack.min());


    StringBuffer sb = new StringBuffer("ss");
    final StringBuffer sb2 = new StringBuffer("ssd");
    sb2.append("22323");
    sb.append("222");


    System.out.println(sb.toString());

    List kkkkkk = new ArrayList<Object>();
    kkkkkk.add("String");

    printList(kkkkkk);


  }

  static void printList(List<?> l) {
    for (Object o : l)
      System.out.println((String) o);
  }

  RuntimeException e;
}


class Something {
  int i;

  @Test
  public void doSomething() {
    System.out.println("i = " + i);
  }
}

/**
 * @author Rollen-Holt 线程的强制执行
 *
 */
class hello implements Runnable {
  public void run() {
    for (int i = 0; i < 3; i++) {
      System.out.println(Thread.currentThread().getName());
    }
  }

  public static void main(String[] args) {
    hello he = new hello();
    Thread demo = new Thread(he, "线程");
    demo.start();
    for (int i = 0; i < 50; ++i) {
      if (i > 10) {
        try {
          demo.join();  //强制执行demo
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
      System.out.println("main 线程执行-->" + i);
    }
  }
}


class hello2 implements Runnable {
  public void run() {
    while (true) {
      System.out.println(Thread.currentThread().getName());
    }
  }

  public static void main(String[] args) {
    hello2 he = new hello2();
    Thread demo = new Thread(he, "线程");
    demo.setDaemon(true);
    demo.start();
  }
}


class Plant {

  int eggNum = 0;

  synchronized void produce() {
    eggNum++;
    System.out.println("生产鸡蛋... 目前鸡蛋数量： " + eggNum);
  }

  synchronized void consume() {
    eggNum--;
    System.out.println("消费鸡蛋... 目前鸡蛋数量： " + eggNum);

  }

}


class Producer implements Runnable {
  @Override
  public void run() {
    for (int i = 0; i < 20; i++) {

      if (plant.eggNum == 20) {
        try {
          this.wait(100);
        } catch (InterruptedException e) {
          e.printStackTrace();
          this.notifyAll();
        }
      }
      plant.produce();
    }
  }

  Plant plant;

  Producer(Plant plant) {
    this.plant = plant;
  }
}

class Consumer implements Runnable {
  Plant plant;

  Consumer(Plant plant) {
    this.plant = plant;
  }

  @Override
  public void run() {
    for (int i = 0; i < 20; i++) {
      if (plant.eggNum == 0) {
        try {
          this.wait(1);
        } catch (InterruptedException e) {
          e.printStackTrace();
          this.notifyAll();
        }
      }
      plant.consume();

    }
  }

}


class TestProCun {


  public static void main(String[] args) {
    Plant plant = new Plant();
    Thread threadProducer = new Thread(new Producer(plant));
    Thread threadConsumer = new Thread(new Consumer(plant));

    threadProducer.start();
    threadConsumer.start();

  }
}
