package testLife.multiThread;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by zhaixuezhong on 11/7/16.
 */


class MyThread {
}

//this is a queue of block

class Test {
  private int queueSize = 10;
  private ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(queueSize);

  public static void main(String args[]) throws InterruptedException {

    Test test = new Test();

    Thread producer = test.new Producer();
    Thread consumer = test.new Consumer();


    producer.start();
    consumer.start();

  }


  class Producer extends Thread {


    @Override
    public void run() {
      produce();
    }


    public void produce() {

      while (true) {


        try {
          queue.put(1);

          System.out.println("get a element from queue!Still left " + queue.size() + " elements.");

        } catch (InterruptedException e) {
          e.printStackTrace();
          this.notify();
        }
      }

    }

  }


  class Consumer extends Thread {


    @Override
    public void run() {
      System.out.println("main body of Cunsumer...");
      consume();
    }


    public void consume() {
      while (true) {
        try {
          synchronized (queue) {
            queue.take();
//                        this.wait();

            System.out.println("put a element from queue!Still left " + queue.size() + " elements.");
          }
        } catch (InterruptedException e) {
          e.printStackTrace();
          this.notify();
        }


      }
    }


  }


}

//this is queue of blocking
class Test2 {
  private int queueSize = 10;
  private ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(queueSize);

  public static void main(String args[]) throws InterruptedException {

    Test2 test = new Test2();

    Thread producer = test.new Producer();
    Thread consumer = test.new Consumer();


    producer.start();
    consumer.start();

  }


  class Producer extends Thread {


    @Override
    public void run() {
      System.out.println("main body of Producer...");
      produce();
    }


    public void produce() {

      while (true) {
        try {
          queue.put(1);

          System.out.println("get a element from queue!Still left " + queue.size() + " elements.");

        } catch (InterruptedException e) {
          e.printStackTrace();

        }
      }


    }


  }


  class Consumer extends Thread {


    @Override
    public void run() {
      System.out.println("main body of Cunsumer...");
      consume();
    }


    public void consume() {
      while (true) {
        try {
          queue.take();
          System.out.println("put a element from queue!Still left " + queue.size() + " elements.");
        } catch (InterruptedException e) {
          e.printStackTrace();
          this.notify();
        }


      }
    }


  }


}


class Test4 {
  Integer k = 0;

  public static void main(String args[]) throws InterruptedException {

    char charV = 'A';
    System.out.println((int) charV);


    Integer i = new Integer(3);

  }


  public void kk(Integer j) {
    synchronized (j) {
      for (int i = 1; i < 10000; i++) {
        System.out.println("No." + j + ":" + i);
      }
    }

  }


}


class ThreadMiii implements Runnable {

  Integer k = 0;


  @Override
  public void run() {

  }
}


class Thread3 {
  class Inner {
    private void m4t1() {
      int i = 5;
      while (i-- > 0) {
        System.out.println(Thread.currentThread().getName() + " : Inner.m4t1()=" + i);
        try {
          Thread.sleep(500);
        } catch (InterruptedException ie) {
        }
      }
    }

    private void m4t2() {
      int i = 5;
      while (i-- > 0) {
        System.out.println(Thread.currentThread().getName() + " : Inner.m4t2()=" + i);
        try {
          Thread.sleep(500);
        } catch (InterruptedException ie) {
        }
      }
    }
  }

  private void m4t1(Inner inner) {
    synchronized (inner) { //使用对象锁
      inner.m4t1();
    }
  }

  private void m4t2(Inner inner) {
    inner.m4t2();
  }

  private synchronized void m4t3(Inner inner) {
    inner.m4t2();
  }

  public static void main(String[] args) {
    final Thread3 myt3 = new Thread3();
    final Inner inner = myt3.new Inner();
    Thread t1 = new Thread(new Runnable() {
      public void run() {
        myt3.m4t1(inner);
      }
    }, "t1");
    Thread t2 = new Thread(new Runnable() {
      public void run() {
        myt3.m4t2(inner);
      }
    }, "t2");
    Thread t3 = new Thread(new Runnable() {
      public void run() {
        myt3.m4t3(inner);
      }
    }, "t3");
    t1.start();
    t2.start();
    t3.start();
  }
}


