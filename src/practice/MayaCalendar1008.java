package practice;

import java.util.Scanner;

/**
 * Created by zxz on 2015/2/4.
 */
public class MayaCalendar1008 {

    public static void main(String args[]) {


    Scanner scr = new Scanner(System.in);
        int readLine = 0;
        int needConvertLine = 0;
        String needConvertStr = "";
        String[] needConvertStrArry = null;
    while(scr.hasNextLine()){
        if(readLine==0) {
            needConvertLine = scr.nextInt();
            System.out.println(needConvertLine);
            scr.nextLine();
        }else if(readLine<=needConvertLine){
            needConvertStr = scr.nextLine();
            needConvertStrArry = needConvertStr.split(" ");

            int days = 0;
            String haabStr = "";
            int day =0;
            int monthtoDay = 0;
            int yeartoDay = 0;

            int dayToYear = 0;
            int dayToMonth =  0;
            int day2 = 0;
            int tempDays = 0;
            day = Integer.parseInt(needConvertStrArry[0].replace(".", "")) + 1;
            monthtoDay = 20 * (convertStrToNum(needConvertStrArry[1]) - 1);
            yeartoDay = 365 * (Integer.parseInt(needConvertStrArry[2]));
            days = day + monthtoDay + yeartoDay;

            dayToYear = (days - days % 260) / 260;
            tempDays = days % 260;
            if(tempDays==0){
                dayToYear = dayToYear -1;
                dayToMonth = 20;
                day2 = 13;
            }else {
                dayToMonth = tempDays % 20;
                if (dayToMonth == 0) {
                    dayToMonth = 20;
                }

                day2 =tempDays%13;
                if(day2==0){
                    day2 = 13;
                }
            }
            System.out.println(day2 +" "+convertNumToStr(dayToMonth)+" "+dayToYear);
        }

        if(readLine==needConvertLine){
            scr.close();
            break;
        }
        readLine++;
    }
}
    private static int convertStrToNum(String str) {
        int num = 0;
        String[][] strArgs = {
          {"pop","1"},{"no","2"},{"zip","3"},{"zotz","4"},{"tzec","5"},{"xul","6"},{"yoxkin","7"},{"mol","8"},{"chen","9"},{"yax","10"},{"zac","11"},{"ceh","12"},{"mac","13"},{"kankin","14"},{"muan","15"},{"pax","16"},{"koyab","17"},{"cumhu","18"},{"uayet","19"}
        };
        aa:
        for(int i =0;i<strArgs.length;i++){
            if(strArgs[i][0].equals(str)){
                num = Integer.parseInt(strArgs[i][1]);
                break aa;
            }
        }
        return num;
    }


    private static String convertNumToStr(int num){
        String str = "";
        String[][] strArgs ={{"imix","1"},{"ik","2"},{"akbal","3"},{"kan","4"},{"chicchan","5"},{"cimi","6"},{"manik","7"},{"lamat","8"},{"muluk","9"},{"ok","10"},{"chuen","11"},{"eb","12"},{"ben","13"},{"ix","14"},{"mem","15"},{"cib","16"},{"caban","17"},{"eznab","18"},{"canac","19"},{"ahau","20"}};
        aa:
        for(int i =0;i<strArgs.length;i++){
            if(strArgs[i][1].equals(num+"")){
                str = strArgs[i][0];
                break aa;
            }
        }
        return str;
    }
}