package design_pattern;

import lombok.Data;

import java.util.Hashtable;

/**
 * Created by zhaixuezhong(2079) on 4/3/18.
 */

@Data
abstract class AbstractShape implements Cloneable {

  private String id;
  protected String type;

  abstract void draw();

  public Object clone() {
    Object clone = null;

    try {
      clone = super.clone();

    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }

    return clone;
  }
}

class Rectangle2 extends AbstractShape {

  public Rectangle2(){
    type = "Rectangle";
  }

  @Override
  public void draw() {
    System.out.println("Inside Rectangle::draw() method.");
  }
}
class Square2 extends AbstractShape {

  public Square2(){
    type = "Square";
  }

  @Override
  public void draw() {
    System.out.println("Inside Square::draw() method.");
  }
}

class Circle2 extends AbstractShape {

  public Circle2(){
    type = "Circle";
  }

  @Override
  public void draw() {
    System.out.println("Inside Circle::draw() method.");
  }
}

class ShapeCache {

  private static Hashtable<String, AbstractShape> shapeMap  = new Hashtable<>();

  public static AbstractShape getShape(String shapeId) {
    AbstractShape cachedShape = shapeMap.get(shapeId);
    return (AbstractShape) cachedShape.clone();
  }

  // for each shape run database query and create shape
  // shapeMap.put(shapeKey, shape);
  // for example, we are adding three shapes

  public static void loadCache() {
    Circle2 circle = new Circle2();
    circle.setId("1");
    shapeMap.put(circle.getId(),circle);

    Square2 square = new Square2();
    square.setId("2");
    shapeMap.put(square.getId(),square);

    Rectangle2 rectangle = new Rectangle2();
    rectangle.setId("3");
    shapeMap.put(rectangle.getId(), rectangle);
  }
}

public class ProtoType {
  public static void main(String[] args) {
    ShapeCache.loadCache();

    AbstractShape clonedShape =  ShapeCache.getShape("1");
    System.out.println("Shape : " + clonedShape.getType());

    AbstractShape clonedShape2 =  ShapeCache.getShape("2");
    System.out.println("Shape : " + clonedShape2.getType());
    clonedShape2.setType("clonedShap2");
    System.out.println("Shape : " + clonedShape2.getType());

    AbstractShape clonedShape20 =  ShapeCache.getShape("2");
    System.out.println("Shape : " + clonedShape20.getType());

    AbstractShape clonedShape3 =  ShapeCache.getShape("3");
    System.out.println("Shape : " + clonedShape3.getType());
  }
}
