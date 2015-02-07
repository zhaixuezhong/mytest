package practice;

import java.util.Scanner;

/**
 * Created by zxz on 2015/1/22.
 */
public class Hangover1003 {



    public static void main(String[] args) {


        Scanner scr =  new  Scanner(System.in);

        while(scr.hasNextDouble()){
            double inputLength =  scr.nextDouble();
            int cardNum = 1;
            double nowLength = 0.0;
            if(inputLength>=0.01&&inputLength<=5.20) {
                while (nowLength < inputLength) {
                    nowLength = nowLength + returnAdditionalLength(cardNum);
                    cardNum = cardNum + 1;
                }
                cardNum = cardNum - 1;
                System.out.println(cardNum+" card(s)");
            }
        }

    }


    public static double returnAdditionalLength(int cardNum){
        double additionalLength = 0.0;
        additionalLength = 1/(Double.parseDouble((cardNum+1)+""));
        return additionalLength;
    }




    }
