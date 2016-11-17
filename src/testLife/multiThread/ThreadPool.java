package testLife.multiThread;

import java.util.concurrent.*;

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
