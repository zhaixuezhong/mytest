package design_practice;

/**
 * Created by zhaixuezhong(2079) on 3/20/18.
 */
interface DrawApi {
  void draw(double x, double y, double radius);
}


class DrawApi1 implements DrawApi {
  @Override
  public void draw(double x, double y, double radius) {
    System.out.printf("API1.circle at %f:%f radius %f\n", x, y, radius);
  }
}

class DrawApi2 implements DrawApi {
  @Override
  public void draw(double x, double y, double radius) {
    System.out.printf("API2.circle at %f:%f radius %f\n", x, y, radius);
  }
}


abstract class Shape {
  DrawApi drawApi;

  public Shape(DrawApi drawApi) {
    this.drawApi = drawApi;
  }

  public abstract void draw();

  public abstract void resetShape(final double pct);
}


class RealShape extends Shape {
  double x, y, radius = 0.0;

  public RealShape(double x, double y, double z, DrawApi drawApi) {
    super(drawApi);
    this.x = x;
    this.y = y;
    this.radius = z;
  }

  @Override
  public void draw() {
    drawApi.draw(x, y, radius);
  }

  @Override
  public void resetShape(final double pct) {
    radius *= (1.0 + pct/100.0);
  }
}


public class Bridge {
  public static void main(String args[]) {

    Shape[] shapes = {new RealShape(1, 2, 3, new DrawApi1()), new RealShape(1, 2, 3, new DrawApi2())};

    for (Shape shape : shapes) {
      shape.resetShape(3.0);
      shape.draw();
    }
  }
}
