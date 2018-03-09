package testProject;


import common.util.CommonConstants;

public class TestOfDouble {

  public static void main(String[] args) {
    String s = "0.1";
    System.out.println(CommonConstants.decimalFormat.format(Double.parseDouble(s)));


  }

}
