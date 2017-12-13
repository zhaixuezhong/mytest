package testLife.innerClass;

/**
 * Created by zhaixuezhong on 11/6/16.
 */

/**
 * 内部类构成
 * 1。静态内部类
 * 2。成员内部类
 * 3。局部内部类
 * 4。匿名内部类
 */


public abstract class Father {

    private int i = 0;


    static{
        System.out.println("this is father's static block!");
    }

    {
        System.out.println("this is father's not static block!");
    }

    Father(){
        System.out.println("this is father's construction!");

    }

    Father(int k){
        this.i = k;
        System.out.println("this is father's construction!");

    }

    public int getI(){
        return this.i;
    }




}



class Child extends Father {
    int i = 3;

    static{
        System.out.println("this is children's static block!");
    }

    {
        System.out.println("this is children's not static block!");
    }

    Child(){
        super(4);
        System.out.println("this is children's construction!");

    }

    public int getI(){
        return i;
    }


}

class Test{


    public static void main(String[] args){

        Father child1 = new Child();
        System.out.println("child1's value " + child1.getI());

        System.out.println("--------------------------!");

        Child child2 = new Child();
        System.out.println("child2's value " + child2.i);

        Father child3 = child2;
        System.out.println("child2's value " + child2.i);
        System.out.println("child3's value " + child3.getI());


        Father father = new Father() {
            @Override
            public int getI() {
                return super.getI();
            }
        };


    }
}
