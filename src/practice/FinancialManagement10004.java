package practice;

import java.util.Scanner;

/**
 * Created by zxz on 2015/1/26.
 */
public class FinancialManagement10004 {




    public static void main(String[] args){

        Scanner scr = new Scanner(System.in);
        double totalSpent = 0.0;
        double averageSpent = 0.0;
        int monthCount = 0;

        while(scr.hasNextDouble()){
           monthCount++;

            double thisMonth = scr.nextDouble();
            totalSpent = totalSpent + thisMonth;

            if(monthCount==12){
                try{
                    scr.close();
                    break;
                }catch (Exception e){
                    System.out.println("中断程序时出现错误！");
                    e.printStackTrace();
                }
            }
        }
        averageSpent = totalSpent/(Double.parseDouble(monthCount+""));
        averageSpent = Math.round(averageSpent*100);
        averageSpent = averageSpent / 100.0;
        System.out.println("$"+averageSpent);

    }

}
