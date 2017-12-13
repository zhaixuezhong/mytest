package design_pattern.adapter;

import java.lang.reflect.Proxy;
import java.util.*;

/**
 * Created by zhaixuezhong on 11/30/16.
 */
public class Test {

    public static void main(String[] args){

        Target target = new Adapter();
        target.request();



    }
}

abstract class MMMMM{

}

class Adaptee{

    public void specificRequest(){

    }
}

class Adaptee2 {

    public void specificRequest2(){

    }
}


interface Target{

   public void request();
}


abstract class MyAdapee{
    Adaptee adaptee =  new Adaptee();
    Adaptee2 adaptee2 = new Adaptee2();

    public void specificRequest(){
        adaptee.specificRequest();
    }

    public void specificRequest2(){
        adaptee2.specificRequest2();
    }

}



class Adapter extends MyAdapee implements Target{


    @Override
    public void request(){
        specificRequest();
        specificRequest2();


        Exception exception;
        Error e ;
    }


    public static void main(String[] arg){

        Map<String,Object> map = new HashMap<String,Object>();

        HashMap maps =  new HashMap();

        map.put("zxz",3);
        map.put("bugaosu",3);
        map.put("cc",3);

        for(Map.Entry<String,Object> entry:map.entrySet()){
            System.out.println(entry.getKey());

        }


        for(String key:map.keySet()){
            System.out.println(key);
        }


        Iterator<Map.Entry<String,Object>> entryIterator = map.entrySet().iterator();
        while(entryIterator.hasNext()){
            System.out.println(entryIterator.next().getKey());
        }

        Iterator iterator = map.entrySet().iterator();
        while(iterator.hasNext()){

            Map.Entry entry = (Map.Entry)iterator.next();
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());

        }

        System.out.println("this is divide line of ArrayList...........");


        List list = new ArrayList();
        list.add("zhangsan");
        list.add("lisi");
        list.add("wangwu");
//        list.add(5);
        for (int x = 0; x < list.size(); x++) {
            String s = (String) list.get(x);
            if ("lisi".equals(s))
            { list.add("zhaoliu"); break;}
        }


        ListIterator lit = list.listIterator();
        while (lit.hasNext()) {
            String s = (String) lit.next();
            if (s.equals("lisi")) {
                lit.add("zhaoliu");
                break;
            }
        }



        for (int x = 0; x < list.size(); x++) {
            System.out.println((String)list.get(x));
        }


        double k = (1- Math.pow(0.997,12))*5000;
        Math.random();
        System.out.println(k);



        final byte a = 12;
        final byte b = 5;
        int _s;

        System.out.println(a|b);


        HashSet ha;
        LinkedHashSet h21;
        Vector ve;
        Queue e;


        System.out.println("this is divide line of TreeSet...........");


        Set<String> treeSet = new TreeSet<String>();
        treeSet.add("1");
        treeSet.add("3");
        treeSet.add("2");
        treeSet.add("4");
//        treeSet.add(null);  // can not do this cause element of tree set can not be empty

        Iterator<String> treeSetIter = treeSet.iterator();
        while(treeSetIter.hasNext()){
            System.out.println(treeSetIter.next());
        }


        System.out.println("this is divide line of HashSet...........");


        Set<String> hashSet = new HashSet<String>();
        hashSet.add("1");
        hashSet.add("3");
        hashSet.add("2");
        hashSet.add("4");
        hashSet.add(null);

        Iterator<String> treeSetIter2 = hashSet.iterator();
        while(treeSetIter2.hasNext()){
            System.out.println(treeSetIter2.next());
        }


        Set<String> linkedHashSet = new LinkedHashSet<String>();
        linkedHashSet.add("1");
        linkedHashSet.add("3");
        linkedHashSet.add("2");
        linkedHashSet.add("4");

        Iterator<String> treeSetIter3 = linkedHashSet.iterator();
        while(treeSetIter3.hasNext()){
            System.out.println(treeSetIter3.next());
        }


        Set<String> set3 = Collections.synchronizedSet(new HashSet<String>());

        char dsdfd = '好';

        int kdddd = Priority.HIGH.getPriorityNumber();
        System.out.println("emun's value is " + kdddd);

        Enumeration ss;


        Vector<String>  jksdf;


        ClassLoader classLoader;

        WAITING();

    }
    private static void WAITING() {
        final Object lock = new Object();
        Thread t1 = new Thread(){
            @Override
            public void run() {

                int i = 0;

                while(true){
                    synchronized (lock) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                        }
                        System. out.println(i++);
                    }
                }
            }
        };

        Thread t2 = new Thread(){
            @Override
            public void run() {

                while(true ){
                    synchronized (lock) {
                        for(int i = 0; i< 10; i++){
                            System. out.println(i);
                        }
                        lock.notifyAll();
                    }

                }
            }
        };

        t1.setName("^^t1^^”");
        t2.setName("^^t2^^");

        t1.start();
        t2.start();
    }

    static private class sss{
    }


}

enum Priority {
    LOW {
        int getPriorityNumber() {
            return 0;
        }
    },

    NORMAL {
        int getPriorityNumber() {
            return 1;
        }
    },

    HIGH {
        int getPriorityNumber() {
            return 2;
        }
    },

    SEVERE {
        int getPriorityNumber() {
            return 3;
        }
    };

    abstract int getPriorityNumber();
}


