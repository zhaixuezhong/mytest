package practice;

import java.util.Scanner;

/**
 * Created by zxz on 2015/1/26.
 */
public class HouseBoat1005 {


  public static void main(String[] args) {
    Scanner scr = new Scanner(System.in);
    int redLine = 0;
    int totalRestLine = 0;
    while (scr.hasNextLine()) {
      if (redLine == 0) {
        totalRestLine = scr.nextInt();
      }
      redLine++;
      double xCoordinate = scr.nextDouble();
      double yCoordinate = scr.nextDouble();

      if (!(xCoordinate == 0.0 && yCoordinate == 0.0)) {

        double radiusSprt = Math.pow(xCoordinate, 2) + Math.pow(yCoordinate, 2);
        double lostAreaOfGivenLocation = 0.5 * Math.PI * radiusSprt;
        int year = 0;
        double lostAreaOfYear = 0;

        while (lostAreaOfYear < lostAreaOfGivenLocation) {
          year++;
          lostAreaOfYear = 50.0 * Double.parseDouble(year + "");
        }

        System.out.println("Property " + redLine + ": This property will begin eroding in year " + year + ".");
      }
      if (redLine == totalRestLine) {
        scr.close();
        break;
      }
    }
    System.out.println("END OF OUTPUT.");
  }

}
