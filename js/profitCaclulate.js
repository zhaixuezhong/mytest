function profitCaclulate(var1,var2,var3,var4){
	
	
var investMoney=var1;
var investDays=var2;
var middleDays=var3;
var resudlDays=var4;

var profit=0.0;
var yearrate=0.13;

profit1=investMoney*yearrate*middleDays/365;//中间收益
profit2=investMoney*yearrate*(resudlDays+middleDays)/365;//未收利息
profit3=investMoney*yearrate*(investDays+resudlDays)/365;//总利息


profit1=Math.round(profit1*100)/100;
profit2=Math.round(profit2*100)/100;
profit3=Math.round(profit3*100)/100;
return "中间收益:"+profit1+" 未收利息:"+profit2+" 总利息:"+profit3;
	
}