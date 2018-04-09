package design_pattern;

/**
 * Created by zhaixuezhong(2079) on 3/20/18.
 */

/**
 * "Implementor"
 */
interface DrawingAPI {
  void drawCircle(final double x, final double y, final double radius);
}

/**
 * "ConcreteImplementor"  1/2
 */
class DrawingAPI1 implements DrawingAPI {
  public void drawCircle(final double x, final double y, final double radius) {
    System.out.printf("API1.circle at %f:%f radius %f\n", x, y, radius);
  }
}

/**
 * "ConcreteImplementor" 2/2
 */
class DrawingAPI2 implements DrawingAPI {
  public void drawCircle(final double x, final double y, final double radius) {
    System.out.printf("API2.circle at %f:%f radius %f\n", x, y, radius);
  }
}

/**
 * "Abstraction"
 */
abstract class BridgeShape {
  protected DrawingAPI drawingAPI;

  protected BridgeShape(final DrawingAPI drawingAPI) {
    this.drawingAPI = drawingAPI;
  }

  public abstract void draw();                                 // low-level

  public abstract void resizeByPercentage(final double pct);   // high-level
}

/**
 * "Refined Abstraction"
 */
class CircleShape extends BridgeShape {
  private double x, y, radius;

  public CircleShape(final double x, final double y, final double radius, final DrawingAPI drawingAPI) {
    super(drawingAPI);
    this.x = x;
    this.y = y;
    this.radius = radius;
  }

  // low-level i.e. Implementation specific
  public void draw() {
    drawingAPI.drawCircle(x, y, radius);
  }

  // high-level i.e. Abstraction specific
  public void resizeByPercentage(final double pct) {
    radius *= (1.0 + pct / 100.0);
  }
}

/**
 * "Client"
 */
public class Bridge {
  public static void main(final String[] args) {
    BridgeShape[] shapes = new BridgeShape[]{
        new CircleShape(1, 2, 3, new DrawingAPI1()),
        new CircleShape(5, 7, 11, new DrawingAPI2())
    };

    for (BridgeShape shape : shapes) {
      shape.resizeByPercentage(2.5);
      shape.draw();
    }
  }
}
