package testProject;

import common.util.DateUtil;

import java.sql.Timestamp;
import java.text.ParseException;



public class TestOfArrys {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int daysofProfit=0;
		Timestamp timestamp1 = Timestamp.valueOf("2014-10-11 11:11:11");
		Timestamp timestamp2 = Timestamp.valueOf("2014-12-11 11:11:11");
		Timestamp timestamp3 = Timestamp.valueOf("2014-11-11 11:11:11");

		Timestamp[] repaymentDateArry = { timestamp1, timestamp2, timestamp3 };

		for (int i = 0; i < repaymentDateArry.length - 1; i++) {
			for (int j = 1; j < repaymentDateArry.length; j++) {
				if (repaymentDateArry[i].after(repaymentDateArry[j])) {
					Timestamp tempDate = null;
					tempDate = repaymentDateArry[i];
					repaymentDateArry[i] = repaymentDateArry[j];
					repaymentDateArry[j] = tempDate;
				}
			}

		}
		for(int i=0;i<repaymentDateArry.length;i++){
		System.out.println(repaymentDateArry[i]);
		}
		//定位购买日期的位置
				int buyDateLocation = 0;
				itstime:
				for(int i=0;i<repaymentDateArry.length;i++){
					if(timestamp2.equals(repaymentDateArry[i])){
						buyDateLocation=i;
						break itstime;
					}
				}
				System.out.println("位置:"+buyDateLocation);
				try {
				if(buyDateLocation==0){
						daysofProfit= DateUtil.getDaysBetween2Date(timestamp2, repaymentDateArry[1]);
				}else{
					daysofProfit=DateUtil.getDaysBetween2Date(repaymentDateArry[buyDateLocation-1], repaymentDateArry[buyDateLocation+1]);
				}
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
				System.out.println("相差天数:"+daysofProfit);
	}
}
