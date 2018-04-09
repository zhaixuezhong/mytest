package design_pattern;

/**
 * Created by zhaixuezhong(2079) on 4/9/18.
 */
class FactoryClient {

  public static void main(String[]args){
    ProductFactory pf=new ProductFactory();
    pf.createInstance('A').saymethod();


    pf.createInstance('B').saymethod();
  }
}

interface Iproduct {
  void saymethod();
}

class ProductA implements Iproduct{

  public void saymethod() {
    System.out.println("A method");

  }

}
class ProductB implements Iproduct{

  public void saymethod() {
    System.out.println("B method");

  }

}

class ProductFactory {
  public Iproduct createInstance(char keyword){
    switch (keyword) {
      case 'A':
        return new ProductA();
      case 'B':
        return new ProductB();
      default:
        return null;
    }
  }
}
