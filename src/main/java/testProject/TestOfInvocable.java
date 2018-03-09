package testProject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import javax.script.Bindings;
import javax.script.Invocable;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class TestOfInvocable {

  public static void main(String[] args) throws FileNotFoundException, ScriptException, NoSuchMethodException {

    ScriptEngine engin = new ScriptEngineManager().getEngineByName("javascript");
    Bindings bind = engin.createBindings();
    bind.put("factor", 1);

    //bind context
    engin.setBindings(bind, ScriptContext.ENGINE_SCOPE);

		
		
		/*
		//测试使用java调用js并返回执行结果
		Scanner input=new Scanner(System.in);
		while(input.hasNextInt()){
			int first=input.nextInt();
			int sec=input.nextInt();
			System.out.println("输入的参数是："+first+","+sec);
			System.out.println(System.getProperty("user.dir"));
			
			//执行js方法
			engin.eval(new FileReader(System.getProperty("user.dir")+"/js/model.js"));
			
			//是否可调用方法
			if(engin instanceof Invocable){
				Invocable in=(Invocable)engin;
				
				//执行js中的函数
				Double result=(Double)in.invokeFunction("formula", first,sec);
				System.out.println("运算结果是:"+result.intValue());
				
			}
			
		}*/

    Scanner input = new Scanner(System.in);
    while (input.hasNextInt()) {
      int investMoney = input.nextInt();
      int investDays = input.nextInt();
      int middleDays = input.nextInt();
      int resudlDays = input.nextInt();

      engin.eval(new FileReader(System.getProperty("user.dir") + "/js/profitCaclulate.js"));

      if (engin instanceof Invocable) {
        Invocable in = (Invocable) engin;

        //执行js中的函数
        String result = (String) in.invokeFunction("profitCaclulate", investMoney, investDays, middleDays, resudlDays);
        System.out.println("运算结果是:" + result);

      }
    }


  }

}
