package design_pattern;

/**
 * Created by zhaixuezhong(2079) on 4/9/18.
 */
class AbstractFactoryClient {
  public static void main(String[] args) {

    //get shape factory
    AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");

    //get an object of Shape Circle
    Apparance shape1 = shapeFactory.getShape("CIRCLE");

    //call draw method of Shape Circle
    shape1.draw();

    //get an object of Shape Rectangle
    Apparance shape2 = shapeFactory.getShape("RECTANGLE");

    //call draw method of Shape Rectangle
    shape2.draw();

    //get an object of Shape Square
    Apparance shape3 = shapeFactory.getShape("SQUARE");

    //call draw method of Shape Square
    shape3.draw();

    //get color factory
    AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");

    //get an object of Color Red
    Color color1 = colorFactory.getColor("RED");

    //call fill method of Red
    color1.fill();

    //get an object of Color Green
    Color color2 = colorFactory.getColor("Green");

    //call fill method of Green
    color2.fill();

    //get an object of Color Blue
    Color color3 = colorFactory.getColor("BLUE");

    //call fill method of Color Blue
    color3.fill();
  }
}


interface Apparance {
  void draw();
}

class RectangleApparance implements Apparance {

  @Override
  public void draw() {
    System.out.println("Inside Rectangle::draw() method.");
  }
}

class SquareApparance implements Apparance {

  @Override
  public void draw() {
    System.out.println("Inside Square::draw() method.");
  }
}

class CircleApparance implements Apparance {

  @Override
  public void draw() {
    System.out.println("Inside Circle::draw() method.");
  }
}

interface Color {
  void fill();
}

class Red implements Color {

  @Override
  public void fill() {
    System.out.println("Inside Red::fill() method.");
  }
}
class Green implements Color {

  @Override
  public void fill() {
    System.out.println("Inside Green::fill() method.");
  }
}
class Blue implements Color {

  @Override
  public void fill() {
    System.out.println("Inside Blue::fill() method.");
  }
}

abstract class AbstractFactory {
  abstract Color getColor(String color);
  abstract Apparance getShape(String shape) ;
}
class ShapeFactory extends AbstractFactory {

  @Override
  public Apparance getShape(String shapeType){

    if(shapeType == null){
      return null;
    }

    if(shapeType.equalsIgnoreCase("CIRCLE")){
      return new CircleApparance();

    }else if(shapeType.equalsIgnoreCase("RECTANGLE")){
      return new RectangleApparance();

    }else if(shapeType.equalsIgnoreCase("SQUARE")){
      return new SquareApparance();
    }

    return null;
  }

  @Override
  Color getColor(String color) {
    return null;
  }
}

class ColorFactory extends AbstractFactory {

  @Override
  public Apparance getShape(String shapeType){
    return null;
  }

  @Override
  Color getColor(String color) {

    if(color == null){
      return null;
    }

    if(color.equalsIgnoreCase("RED")){
      return new Red();

    }else if(color.equalsIgnoreCase("GREEN")){
      return new Green();

    }else if(color.equalsIgnoreCase("BLUE")){
      return new Blue();
    }

    return null;
  }
}

class FactoryProducer {
  public static AbstractFactory getFactory(String choice){

    if(choice.equalsIgnoreCase("SHAPE")){
      return new ShapeFactory();

    }else if(choice.equalsIgnoreCase("COLOR")){
      return new ColorFactory();
    }

    return null;
  }
}
