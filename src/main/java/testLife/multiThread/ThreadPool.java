package testLife.multiThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhaixuezhong on 11/16/16.
 */
public class ThreadPool {


  public static void main(String[] args) {

    ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
    for (int i = 0; i < 10; i++) {
      final int index = i;
      try {
        Thread.sleep(index * 1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      cachedThreadPool.execute(new Runnable() {
        public void run() {
          System.out.println(index);
        }
      });
    }
    cachedThreadPool.shutdown();

//        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
//        for (int i = 0; i < 10; i++) {
//            final int index = i;
//            fixedThreadPool.execute(new Runnable() {
//                public void run() {
//                    try {
//                        System.out.println(index);
//                        Thread.sleep(2000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            });
//        }
//        fixedThreadPool.shutdown();


//        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
//        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
//            public void run() {
//                System.out.println("delay 3 seconds");
//            }
//        }, 1, 3, TimeUnit.SECONDS);


  }
}


class MyTree {

  public static void main(String[] args) {

    Node node = new Node("a");
    Node left = new Node("b", new Node("d"), new Node("f"));
    Node right = new Node("c");

    node.setLeft(left);
    node.setRight(right);


//        node.readMiddleBetween();

    System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
    System.out.println(Integer.toBinaryString(-1));
    System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));


    long la = 3333223l;
//        int ia = 3333333333333;
    double da = 333333333333322232322323232323232323377733333333332223232232323232323232337773333333333222323223232323232323233777333333333333222323223233232322323232323232323377733333333332223232232323232323232337777773d;

//        da = la;
    System.out.println(Double.MAX_VALUE);
    System.out.println(da);

  }

}


class Node {
  String value;
  Node left;
  Node right;

  Node(String v) {
    this.value = v;
  }

  Node(String v, Node left, Node right) {
    this.value = v;
    this.left = left;
    this.right = right;
  }

  public String getValue() {
    return value;
  }

  public Node getLeft() {
    return this.left;
  }

  public Node getRight() {
    return this.right;
  }

//    public void setValue(int value){
//        this.value = value;
//    }

  public void setLeft(Node left) {
    this.left = left;
  }

  public void setRight(Node right) {
    this.right = right;
  }

  public void readMiddleFirst() {
    readMiddleFirstF(this);

  }

  public void readMiddleFirstF(Node n) {
    if (n != null) {
      System.out.println(n.value);
      readMiddleFirstF(n.left);
      readMiddleFirstF(n.right);
    }

  }

  public void readMiddleBetween() {
    readMiddleBetweenM(this);
  }

  public void readMiddleBetweenM(Node n) {
    if (n != null) {
      readMiddleFirstF(n.left);
      System.out.println(n.value);
      readMiddleFirstF(n.right);
    }

  }

  public void readMiddleLast() {

  }
}
