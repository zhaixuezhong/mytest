package life_style;

/**
 * Created by zhaixuezhong(2079) on 3/24/18.
 */
public class ProfitRate {

  public static void main(String[] args) {

    double yearProfitRate = 0;  //年化收益率
    double initialMoney = 8000;  //初始价格
    int totalMonth = 12; //还款月份
    double rate = 0.0023;  //月息
    double moneyShouldPayPerMonth = initialMoney / totalMonth; //每月应还款额
    double profitShouldPayPerMonth = initialMoney * rate; //每月多还款额


    double[] yearRate = new double[totalMonth];
    for (int i = 1; i <= totalMonth; i++) {
      yearRate[i - 1] = profitShouldPayPerMonth / (moneyShouldPayPerMonth * i + (i - 1) * profitShouldPayPerMonth) * 12;
    }

    for (int i = 0; i < totalMonth; i++) {
      yearProfitRate += yearRate[i];
    }
    System.out.println("年化收益率为  : " + yearProfitRate / totalMonth);
  }
}
