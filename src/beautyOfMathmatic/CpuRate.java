package beautyOfMathmatic;

import java.util.AbstractSet;
import java.util.LinkedList;

/**
 * Created by zhaixuezhong on 11/16/16.
 */
public class CpuRate extends Thread{

    @Override
    public void run() {
        while(true){

            for(int i = 0;i < 9600000;i++){

            }
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}



class Test{


    public static void main(String[] args) {

        Thread CpuRate = new Thread(new CpuRate());
        CpuRate.start();

        AbstractSet S;
        LinkedList ll;


    }
}
