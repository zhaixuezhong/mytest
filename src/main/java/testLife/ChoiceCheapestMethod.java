package testLife;

/**
 * Created by zxz on 2015/1/16.
 */
public class ChoiceCheapestMethod {

  private int totalPersonsNum = 5;
  private double singlePrice = 98.0;


  public static void main(String args[]) {


    //比如说有三个


    int totalNum = 5;
    int groupNum = 3;


    int[] group = new int[groupNum];
    int nowTotalPerson = 0;

    for (int i = 0; i < group.length; i++) {


    }


  }


  private int[] generatePartition(int totalPersonNum) {
    int[] partition = new int[0];
    if (totalPersonNum > 0) {
      partition = new int[totalPersonNum];

      for (int i = 0; i < totalPersonNum; i++) {


      }


    }
    return partition;
  }

  private int generateNextNum(int nowTotal, int maxNum) {
    int num = 1;
    return num;
  }


  private double calculateTotalMoneyForOneOrderBeforeDiscount(int OrderOfPersonCount) {
    return Double.parseDouble(OrderOfPersonCount + "") * singlePrice;
  }


  private Double calculateTotalMoneyForOneOrderAftereDiscount(Double money) {
    Double afterDiscountMoney = 0.0;
    if (money < 0) {
      afterDiscountMoney = 0.0;
    } else if (money >= 0) {
      afterDiscountMoney = money;
    } else if (money >= 100 && money < 120) {
      afterDiscountMoney = money - 10;
    } else if (money >= 120 && money < 200) {
      afterDiscountMoney = money - 12;
    } else if (money >= 200 && money < 300) {
      afterDiscountMoney = money - 25;
    } else if (money >= 300) {
      afterDiscountMoney = money - 30;
    }
    return afterDiscountMoney;
  }


}
