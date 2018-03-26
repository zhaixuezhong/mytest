package design_pattern;

/**
 * Created by zhaixuezhong(2079) on 3/26/18.
 */
interface BaseShape {
  void draw();
}

class Rectangle implements BaseShape {

  @Override
  public void draw() {
    System.out.println("Rectangle::draw()");
  }
}

class Square implements BaseShape {

  @Override
  public void draw() {
    System.out.println("Square::draw()");
  }
}

class Circle implements BaseShape {

  @Override
  public void draw() {
    System.out.println("Circle::draw()");
  }
}


/* Facade */

class ShapeMaker {
  private BaseShape circle;
  private BaseShape rectangle;
  private BaseShape square;

  public ShapeMaker() {
    circle = new Circle();
    rectangle = new Rectangle();
    square = new Square();
  }

  public void drawCircle() {
    circle.draw();
  }

  public void drawRectangle() {
    rectangle.draw();
  }

  public void drawSquare() {
    square.draw();
  }
}

/* Client */

public class Facade {
  public static void main(String[] args) {
    ShapeMaker shapeMaker = new ShapeMaker();

    shapeMaker.drawCircle();
    shapeMaker.drawRectangle();
    shapeMaker.drawSquare();
  }
}
