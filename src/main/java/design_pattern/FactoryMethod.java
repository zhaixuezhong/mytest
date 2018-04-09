package design_pattern;

/**
 * Created by zhaixuezhong(2079) on 4/9/18.
 */
class FactoryMethodClient {

  public static void main(String[] args) {
    FactoryMethod brand1 = new ConcreateFactoryA();
    brand1.createProduct().brand();

    FactoryMethod brand2 = new ConcreateFactoryB();
    brand2.createProduct().brand();

  }
}


interface Product {
  void brand();
}

interface FactoryMethod {
  Product createProduct();
}

class ConcreateProductA implements Product {
  public void brand() {
    System.out.println("ConcreateProductA");
  }
}

class ConcreateProductB implements Product {
  public void brand() {
    System.out.println("ConcreateProductB");
  }
}

class ConcreateFactoryA implements FactoryMethod {

  public Product createProduct() {
    return new ConcreateProductA();
  }

}


class ConcreateFactoryB implements FactoryMethod {
  public Product createProduct() {
    return new ConcreateProductB();
  }
}
