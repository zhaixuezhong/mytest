package design_pattern;

/**
 * Created by zhaixuezhong(2079) on 4/9/18.
 */
public class FactoryMethod {

  public static void main(String args[]) {
    RoomFactory shapeFactory = new RoomFactory();

    //get an object of Circle and call its draw method.
    Room shape1 = shapeFactory.getShape("GAME");

    //call draw method of Circle
    shape1.draw();

    //get an object of Rectangle and call its draw method.
    Room shape2 = shapeFactory.getShape("PLEASURE");

    //call draw method of Rectangle
    shape2.draw();

    //get an object of Square and call its draw method.
    Room shape3 = shapeFactory.getShape("MEETING");

    //call draw method of circle
    shape3.draw();
  }

}




interface Room {
  void draw();
}


class GameRoom implements Room {

  @Override
  public void draw() {
    System.out.println("Inside GameRoom::draw() method.");
  }
}

class PleasureRoom implements Room {

  @Override
  public void draw() {
    System.out.println("Inside PleasureRoom::draw() method.");
  }
}

class MeetingRoom implements Room {

  @Override
  public void draw() {
    System.out.println("Inside MeetingRoom::draw() method.");
  }
}

class RoomFactory {

  //use getShape method to get object of type shape
  public Room getShape(String shapeType){
    if(shapeType == null){
      return null;
    }
    if(shapeType.equalsIgnoreCase("GAME")){
      return new GameRoom();

    } else if(shapeType.equalsIgnoreCase("PLEASURE")){
      return new PleasureRoom();

    } else if(shapeType.equalsIgnoreCase("MEETING")){
      return new MeetingRoom();
    }

    return null;
  }
}
