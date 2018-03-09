package testProject;

public class TestofArrays {

  public static void main(String[] args) {
    // TODO Auto-generated method stub


    String[][] initStrings = {{"a", "b", "c"}, {null, null, null}, {"d", "e", "f"}, {"h", "k", "j"}};
    String[][] initStrings2 = null;
    int deleteRowNum = 0;
    for (int i = 0; i < initStrings.length; i++) {
      int nullNum = 0;
      for (int j = 0; j < initStrings[i].length; j++) {
        if (initStrings[i][j] == null || "".equals(initStrings[i][j])) {
          nullNum++;
        }
      }
      if (nullNum == initStrings[i].length) {
        deleteRowNum++;
      }
    }
    initStrings2 = new String[initStrings.length - deleteRowNum][initStrings[0].length];

    int differCount = 0;
    int nowLocation = 0;
    for (int i = 0; i < initStrings.length; i++) {
      int nullNum = 0;
      for (int j = 0; j < initStrings[i].length; j++) {
        if (initStrings[i][j] == null || "".equals(initStrings[i][j])) {
          nullNum++;
        }
      }

      if (!(nullNum == initStrings[i].length)) {
        for (int j = 0; j < initStrings[i].length; j++) {
          initStrings2[i - differCount][j] = initStrings[i][j];
        }
      } else {
        differCount++;
      }
    }

    for (int i = 0; i < initStrings.length; i++) {
      for (int j = 0; j < initStrings[i].length; j++) {
        System.out.print(initStrings[i][j]);
      }
      System.out.println();
    }
    System.out.println("------------------");
    for (int i = 0; i < initStrings2.length; i++) {
      for (int j = 0; j < initStrings2[i].length; j++) {
        System.out.print(initStrings2[i][j]);
      }
      System.out.println();
    }
  }

}
