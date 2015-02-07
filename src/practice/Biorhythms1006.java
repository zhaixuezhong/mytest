package practice;

import java.util.Scanner;

/**
 * Created by zxz on 2015/2/2.
 */
public class Biorhythms1006 {
    public static void main(String[] args){
        int caseCount = 0;
        int physicalCycle = 23;
        int emotionalCycle = 28;
        int intellectualCycle = 33;

        Scanner scr = new Scanner(System.in);
        while(scr.hasNextLine()){
            caseCount++;

            int p = scr.nextInt();
            int e = scr.nextInt();
            int i = scr.nextInt();
            int d = scr.nextInt();
            int occursDay = 0;

            if(p==e&&e==i&i==d&&d==-1){
                scr.close();
                break;
            }

            int initP = getStartDay(p,physicalCycle);
            int initE = getStartDay(e,emotionalCycle);
            int initI = getStartDay(i,intellectualCycle);

            int tempAddedNum = physicalCycle;
            int tempChangedNum=0;
            for(int j=initP;j<=21252;j+=tempAddedNum){


                if((j-initP)%physicalCycle==0&&(j-initE)%emotionalCycle==0){
                    if((j-initI)%intellectualCycle!=0&tempChangedNum==0) {
                        tempAddedNum = physicalCycle + emotionalCycle;
                    }else if((j-initI)%intellectualCycle==0){
                        occursDay = j;
                        break;
                    }
                }

            }

            for(int j=initI;j<=21252;j+=intellectualCycle){
                if((j-initI)%intellectualCycle==0&&(j-initE)%emotionalCycle==0&&(j-initP)%physicalCycle==0){
                    occursDay = j;
                    break;
                }
            }

            occursDay = occursDay - d;
            if(occursDay<=0){
                occursDay = occursDay + 21252;
            }
            System.out.println("Case "+caseCount+": the next triple peak occurs in "+occursDay+" days.");
        }
    }

    private static int getStartDay(int peaksDay,int cycleDays){
        while(peaksDay>cycleDays){
            peaksDay = peaksDay - cycleDays;
        }
        return peaksDay;
    }
}
