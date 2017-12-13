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


        boolean bBoolean = true;

        System.out.println(Boolean.compare(bBoolean,bBoolean));


        Number n;
        Number m = 12;
        System.out.println(m.toString());




        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE+1);

        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MIN_VALUE-1);


        double douVal = 0.6332;
        float sss = 0.6332f;


        String str1 = "hello";
        String str2 = "he" + new String("llo");
        System.out.println(str1 == str2);


        String str11 = "hello";
        String str21 = "he" + "llo";
        System.out.println(str11 == str21);


        String str12 = "kkk";
        String str22 = new String("kkk");
        System.out.println(str12 == str22);

        char[] charVal = str1.toCharArray();
        for(char c:charVal){
            System.out.println(c);

        }

        boolean aBoolean = false;

    }
}
