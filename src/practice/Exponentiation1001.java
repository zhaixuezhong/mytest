package practice;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created by zxz on 2015/1/19.
 */
public class Exponentiation1001 {

    public static void main(String args[]) throws Exception {
        Scanner cin = new Scanner(System.in);
        String outPutString = "";
        int lineNum= 0;
        while(cin.hasNextLine()){
            BigDecimal num = cin.nextBigDecimal();
            int n = cin.nextInt();
            num = num.pow(n);
            String r = num.stripTrailingZeros().toPlainString();
            if(r.startsWith("0.")){
                r = r.substring(1);
            }
            System.out.println(r);




        }


    }
}
