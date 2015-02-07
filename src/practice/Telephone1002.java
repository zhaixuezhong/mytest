package practice;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by zxz on 2015/1/19.
 */
public class Telephone1002 {
    private static String[][] phoneNumArry =  new String[100][2];
    static final int NUM_LOCATION = 0;
    static final int COUNT_LOCATION = 1;
    static int LASTINDEXNUM = 0;
    public static void main(String[] args){
        Scanner scr =  new Scanner(System.in);

        while(scr.hasNextLine()){
            String line = scr.nextLine();
            if(line.equals("ENDEND")){
                try {
                    System.in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            line = line.toUpperCase();
            String outPutPhoneNumStr = "";
            outPutPhoneNumStr = convertLineToNumString(line);

            putPhoneNumToArray(outPutPhoneNumStr);
        }

        sortOutPutPhoneNum();
        formatOutPutPhoneNum();
        for(int i = 0;i<LASTINDEXNUM-1;i++){
            int countNum = Integer.parseInt(phoneNumArry[i][COUNT_LOCATION]);
            if(countNum>1) {
                System.out.print(phoneNumArry[i][NUM_LOCATION] + "   ");
                System.out.println(phoneNumArry[i][COUNT_LOCATION]);
            }
        }

    }

    private static void putPhoneNumToArray(String outPutPhoneNumStr){
        if(outPutPhoneNumStr.length()==7) {
            int locationStatus = indexPhoneNum(outPutPhoneNumStr);
            if (locationStatus < 0) {
                phoneNumArry[LASTINDEXNUM][NUM_LOCATION] = outPutPhoneNumStr;
                phoneNumArry[LASTINDEXNUM][COUNT_LOCATION] = "1";
                LASTINDEXNUM++;
            } else {
                int countNum = Integer.parseInt(phoneNumArry[locationStatus][COUNT_LOCATION]);
                countNum = countNum + 1;
                phoneNumArry[locationStatus][COUNT_LOCATION] = countNum + "";
            }
        }
    }


    private static int indexPhoneNum(String phoneNum){
        int location = -1;
        for(int i=0;i<phoneNumArry.length;i++){
            if(phoneNum.equals(phoneNumArry[i][NUM_LOCATION])){
                location = i;
            }
        }
        return location;
    }


    private static String convertLineToNumString(String line){
        String[] phoneNumStringArry = convertStringToArray(line);
        String outPutPhoneNumStr = convertStringArryToIntArry(phoneNumStringArry);
        return outPutPhoneNumStr;
    }

    private static String convertStringArryToIntArry(String [] phoneNumStringArry){
        String outPutPhoneNumStr = "";

        for(int i = 0;i< (phoneNumStringArry.length);i++){
            outPutPhoneNumStr = outPutPhoneNumStr + stringToNum(phoneNumStringArry[i]);
        }
        return outPutPhoneNumStr;
    }

    private static String[] convertStringToArray(String s){
        String[] phoneNumStringArry = new String[s.length()];
        s = s.replace("-","");
        phoneNumStringArry = s.split("");
        return phoneNumStringArry;
    }

    private static String stringToNum(String s){
        String num = "";
        if(s.equals("A")||s.equals("B")||s.equals("C")){
            num = "2";
        }else if(s.equals("D")||s.equals("E")||s.equals("F")){
            num = "3";
        }else if(s.equals("G")||s.equals("H")||s.equals("I")){
            num = "4";
        }else if(s.equals("J")||s.equals("K")||s.equals("L")){
            num = "5";
        }else if(s.equals("M")||s.equals("N")||s.equals("O")){
            num = "6";
        }else if(s.equals("P")||s.equals("R")||s.equals("S")){
            num = "7";
        }else if(s.equals("T")||s.equals("U")||s.equals("V")){
            num = "8";
        }else if(s.equals("W")||s.equals("X")||s.equals("Y")){
            num = "9";
        }else{
            num = s;
        }
        return num;
    }



    private static void sortOutPutPhoneNum(){
        for(int i=0;i<LASTINDEXNUM-1;i++){
            for(int j=1;j<LASTINDEXNUM-1;j++){
                String tempPhone = "";
                String tempCount = "";

                  if(isBigger(phoneNumArry[i][NUM_LOCATION],phoneNumArry[j][NUM_LOCATION])){
                      tempPhone = phoneNumArry[i][NUM_LOCATION];
                      tempCount = phoneNumArry[i][COUNT_LOCATION];

                      phoneNumArry[i][NUM_LOCATION] = phoneNumArry[j][NUM_LOCATION];
                      phoneNumArry[i][COUNT_LOCATION] = phoneNumArry[j][COUNT_LOCATION];

                      phoneNumArry[j][NUM_LOCATION] = tempPhone;
                      phoneNumArry[j][COUNT_LOCATION] = tempCount;
                  }


            }

        }
    }

    private static boolean isBigger(String thisPhone,String nextPhone){
        int thisPhoneNum = Integer.parseInt(thisPhone);
        int nextPhoneNum = Integer.parseInt(nextPhone);

        if(thisPhoneNum>nextPhoneNum){
            return true;
        }else{
            return false;
        }
    }

    private static void formatOutPutPhoneNum(){

        for(int i=0;i<LASTINDEXNUM-1;i++){
                String initPhoneNumStr = phoneNumArry[i][NUM_LOCATION];
                String initPhoneNumStr2 = phoneNumArry[i][NUM_LOCATION];

            String phoneNumStr = initPhoneNumStr.substring(0,3)+"-"+initPhoneNumStr.substring(3);
                phoneNumArry[i][NUM_LOCATION] = phoneNumStr;
        }

    }



   /* static char[] s;
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n;
        n = in.nextInt();
        in.nextLine();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            s = in.nextLine().toCharArray();
            data[i] = Hash();
        }
        Arrays.sort(data);
        boolean p = false;
        n--;
        for (int i = 0, num = 1; i < n; i += num = 1) {
            while (i < n && data[i] == data[i + 1]) {
                {//将此循环try掉则为WA，否则为RE
                    num++;
                    i++;
                }
                if (num > 1) {
                    System.out.printf("%03d-%04d %d\n", data[i] / 10000, data[i] % 10000, num);
                    p = true;
                }
                if (!p) {
                    System.out.printf("No duplicates. \n");
                }
            }
        }
    }

    static int Hash() {
        int sum = 0;
        for (int i = 0, k = 0; k < 7; i++) {
            if (s[i] >= '0' && s[i] <= '9') {
                sum *= 10;
                k++;
                sum += (s[i] - '0');
            } else if (s[i] >= 'A' && s[i] < 'Z') {
                sum *= 10;
                k++;
                sum += ((s[i] - 'A' - (s[i] > 'Q' ? 1 : 0)) / 3 + 2);
            }
        }
        return sum;
    }*/






}
