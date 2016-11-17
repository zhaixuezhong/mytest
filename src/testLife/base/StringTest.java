package testLife.base;

/**
 * Created by zhaixuezhong on 11/13/16.
 */
public class StringTest {

    public static void main(String[] args){


        String aa = "abc";

        String bb = "abc";

        String cc = new String("abc");

        System.out.println(aa == bb);
        System.out.println(aa == cc);


        boolean aBoolean = false;
        boolean bBoolean = true;

        System.out.println(Boolean.compare(bBoolean,aBoolean));


        Number n;
        Number m = 12;
        System.out.println(m.toString());

    }
}
