package design_pattern;

/**
 * Created by zhaixuezhong(2079) on 4/9/18.
 */
class FactoryMethodClient {

  public static void main(String[] args) {
    FactoryMethod brand1 = new ProductFactoryE();
    brand1.createProduct().brand();

    FactoryMethod brand2 = new ProductFactoryF();
    brand2.createProduct().brand();

  }
}


interface Product {
  void brand();
}

interface FactoryMethod {
  Product createProduct();
}

class ProductE implements Product {
  public void brand() {
    System.out.println("ProductE");
  }
}

class ProductF implements Product {
  public void brand() {
    System.out.println("ProductF");
  }
}

class ProductFactoryE implements FactoryMethod {

  public Product createProduct() {
    return new ProductE();
  }

}


class ProductFactoryF implements FactoryMethod {
  public Product createProduct() {
    return new ProductF();
  }
}
