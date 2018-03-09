package yourendaiTest;

public class StringGenerate {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    String[] repaymentDetailIds = {"8a23337949e0a8910149e5635fd22e1c", "8a23337949e0a8910149e5279fc52b6c", "8a23337949e0a8910149e27dc9a6161c", "8a23337949e0a8910149e238d843154e",
        "8a23337949e0a8910149e17c7b9a0e05", "8a23337949e0a8910149e127e8860abc", "8a23337949e0a8910149e0f0c1060548"};
    String repaymentPlanId = "8a23337948f9a6540148fcf994200919";
    String userId = "";
    double repayMoney = 0.0;
    String[] projectsUsersIds = {"8a23337949e0a8910149e56111a22dfa", "8a23337949e0a8910149e5254ae22b44", "8a23337949e0a8910149e27d48eb1608", "8a23337949e0a8910149e23738b91539",
        "8a23337949e0a8910149e178ada80dc8", "8a23337949e0a8910149e12477520a39", "8a23337949e0a8910149e0f001c6052f"};

    for (int i = 0; i < repaymentDetailIds.length; i++) {
      String sqlString = "insert into `wz_repayment_detail` (`repayment_detail_id`,`repayment_plan_id`,`user_id`,`repayment_money`,`mange_money`,`createby`,`lastupdateby`,`lastupdatedate`,`createdate`,`attribute1`,`attribute2`,`attribute3`,`attribute4`,`attribute5`,`segment1`,`segment2`,`date1`,`date2`,`projects_users_id`)" +
          "values('" + repaymentDetailIds[i] + "','" + repaymentPlanId + "','" + userId + "'," + repayMoney + ",0,'8a23337948f8bd860148f8c327850013','',null,'2014-10-11 18:45:58','','','','','',null,null,null,null,'" + projectsUsersIds[i] + "');";
      System.out.println(sqlString);
    }


  }

}
