package testProject;


public class TestOfString {
  public static void main(String[] args) {
//		System.out.println(String.format("%.0f",200.00,"200.00",200.00,200.00));


    System.out.println("大山那头是什么，大山那头是星星" == null ? "" : repalcechar("大山那头是什么，大山那头是星星", 8, "..."));
  }


  public static String repalcechar(String str, int length, String chr) {
    if (str.length() > length) {
      return str.substring(0, length) + chr;
    } else {
      return str;
    }

  }

}
