package testLife.innerClass;

import java.util.AbstractCollection;

/**
 * Created by zhaixuezhong on 12/2/16.
 */
public class Outer {




    static class Inner{
        static int i = 3;

        static{
            System.out.println("this is static block!");
        }

        Inner(){
            System.out.println("this is construction!");
        }




    }
}


abstract class AbastactCl{
    abstract void haha();
}



class TestofInner{



    public static void main(String[] args)
    {
        System.out.println(Outer.Inner.i);
        AbastactCl abst = new AbastactCl() {
            @Override
            void haha() {
                System.out.println("this is the body!");
            }
        };
        abst.haha();

    }
}