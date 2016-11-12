package testLife.multiThread;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by zhaixuezhong on 11/7/16.
 */



class MyThread{
}

//this is a queue of block

class Test{
    private int queueSize = 10;
    private ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(queueSize);

    public static void main(String args[]) throws InterruptedException {

        Test test = new Test();

        Thread producer  = test.new Producer();
        Thread consumer  = test.new Consumer();


        producer.start();
        consumer.start();

    }




    class Producer  extends Thread{


        @Override
        public void run() {
            produce();
        }


        public void produce(){

            while(true){


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


    class Consumer extends Thread{


        @Override
        public void run() {
            System.out.println("main body of Cunsumer...");
            consume();
        }


        public void consume(){
            while(true){
                try {
                    synchronized (queue){
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
class Test2{
    private int queueSize = 10;
    private ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(queueSize);

    public static void main(String args[]) throws InterruptedException {

        Test2 test = new Test2();

        Thread producer  = test.new Producer();
        Thread consumer  = test.new Consumer();


        producer.start();
        consumer.start();

    }




    class Producer  extends Thread{


        @Override
        public void run() {
            System.out.println("main body of Producer...");
            produce();
        }


        public void produce(){

            while(true){
                    try {
                        queue.put(1);

                        System.out.println("get a element from queue!Still left " + queue.size() + " elements.");

                    } catch (InterruptedException e) {
                        e.printStackTrace();

                    }
                }



            }


        }



    class Consumer extends Thread{


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



class Test4{
    public static void main(String args[]) throws InterruptedException {

        char charV = 'A';
        System.out.println((int)charV);



    }



}


