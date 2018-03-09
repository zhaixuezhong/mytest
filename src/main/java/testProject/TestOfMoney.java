package testProject;


import common.util.CommonConstants;

public class TestOfMoney {

  public static void main(String[] args) {

		
		
		
		/*double doubleVal0 = 1.745;
		double doubleVal00 = 0.745;
		System.out.println(new BigDecimal(doubleVal0));
		System.out.println(new BigDecimal(doubleVal00));
		
		
		String doubleVal = "1.745";
		String doubleVal1 = "0.745";
		BigDecimal bdTest = new BigDecimal(doubleVal);
		BigDecimal bdTest1 = new BigDecimal(doubleVal1);
		bdTest = bdTest.setScale(2, BigDecimal.ROUND_HALF_UP);
		bdTest1 = bdTest1.setScale(2, BigDecimal.ROUND_HALF_UP);
		System.out.println("bdTest:" + bdTest); // 1.75
		System.out.println("bdTest1:" + bdTest1);// 0.75, no problem
		  
		  
		Double doubleVa2 = 1.745D;
		Float doubleVa22 = 0.745F;
		BigDecimal bdTest2 = new BigDecimal(doubleVal);
		BigDecimal bdTest22 = new BigDecimal(doubleVal1);
		bdTest = bdTest.setScale(2, BigDecimal.ROUND_HALF_UP);
		bdTest1 = bdTest1.setScale(2, BigDecimal.ROUND_HALF_UP);
		System.out.println("bdTest:" + bdTest); // 1.75
		System.out.println("bdTest1:" + bdTest1);// 0.75, no problem
*/
//		int count=0;
//	for(int i=0;i<100;i++){
//		Double a;
//		Double b;
//		Double c;
//		Double abc;
//		a=Math.random()*1000;
//		b=Math.random()*1000;
//		c=Math.random()*1000;
//		abc=a+b+c;
//		
//		Double dividAdd=Double.parseDouble(CommonConstants.decimalFormat.format(a*0.13*30/365))+Double.parseDouble(CommonConstants.decimalFormat.format(b*0.13*30/365))+Double.parseDouble(CommonConstants.decimalFormat.format(c*0.13*30/365));
//		Double totalAdd=Double.parseDouble(CommonConstants.decimalFormat.format((a+b+c)*0.13*30/365));
//		if(dividAdd>totalAdd){
//			count++;
//		}
//	}
//	System.out.println("count的数量："+count);

    Double subscriptionMoney = 100.0;
    Double subscriptionTotalMoney = 100.23;
    Double realPayMoney1 = 43.58;
    Double realPayMoney2 = subscriptionTotalMoney - realPayMoney1;

    Double equalCrediteMoney1 = 0.0;
    Double equalCrediteMoney2 = 0.0;
    equalCrediteMoney1 = realPayMoney1 * subscriptionMoney / subscriptionTotalMoney / 100;
    equalCrediteMoney1 = Double.parseDouble(CommonConstants.decimalFormat.format(equalCrediteMoney1)) * 100;

    if (realPayMoney2 > 0) {
      equalCrediteMoney2 = subscriptionMoney - equalCrediteMoney1;
    }
    equalCrediteMoney2 = Double.parseDouble(CommonConstants.decimalFormat.format(equalCrediteMoney2));
    System.out.println("投资账户1相当年化[" + equalCrediteMoney1 + "]投资账户2相当年化[" + equalCrediteMoney2 + "]");

  }
}
