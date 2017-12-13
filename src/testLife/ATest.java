package testLife;

/**
 * Created by zxz on 2015/1/30.
 */
public class ATest {
    ATest(){
        System.out.println("ATest");
    }

    public static void main(String[] args){

       ATest a = new ATest();
       BTest bTest =  a.new BTest();

    }


    class BTest{
        BTest(){
            System.out.println("BTest");
        }
    }
}



