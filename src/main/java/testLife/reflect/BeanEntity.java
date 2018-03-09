package testLife.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by zhaixuezhong on 11/4/16.
 */
public class BeanEntity {

  private String aaa;


  public String getAaa() {
    return aaa;
  }

  private void setAaa(String aaa) {
    this.aaa = aaa;
  }
}


class Test {

  public static void main(String[] args) {

    Class<?> class1 = null;

    try {
      class1 = Class.forName(BeanEntity.class.getName());
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    if (class1 != null) {
      try {
        BeanEntity be = (BeanEntity) class1.newInstance();


        Method[] methods = class1.getDeclaredMethods();
//                for(int i = 0;i < methods.length;i++){
//
//                    System.out.println("method's name is " + methods[i].getName() + " and the count of the parameters is " +  methods[i].getParameterCount());
//
//
//                }
        try {
          Method method = class1.getDeclaredMethod("setAaa", String.class);

          method.setAccessible(true);
          method.invoke(be, "liLei");
          System.out.println(be.getAaa());

          Field fieldAAA = class1.getDeclaredField("aaa");
          fieldAAA.setAccessible(true);
          System.out.println(fieldAAA.get(be));


        } catch (NoSuchMethodException e) {
          e.printStackTrace();
        } catch (InvocationTargetException e) {
          e.printStackTrace();
        } catch (NoSuchFieldException e) {
          e.printStackTrace();
        }


      } catch (InstantiationException e) {
        e.printStackTrace();
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      }
    }


  }


}
