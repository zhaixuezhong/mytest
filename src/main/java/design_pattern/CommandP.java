package design_pattern;

/**
 * Created by zhaixuezhong(2079) on 3/22/18.
 */



/** The Receiver class */
class Light {

  public void turnOn() {
    System.out.println("The light is on");
  }
  public void turnOff() {
    System.out.println("The light is off");
  }

}


/** The Command interface */
interface Command {
  void execute();
}

/** The Command for turning on the light - ConcreteCommand #1 */
class FlipUpCommand implements Command {
  private Light theLight;

  public FlipUpCommand(final Light light) {
    this.theLight = light;
  }

  @Override    // Command
  public void execute() {
    theLight.turnOn();
  }
}

/** The Command for turning off the light - ConcreteCommand #2 */
class FlipDownCommand implements Command {
  private Light theLight;

  public FlipDownCommand(final Light light) {
    this.theLight = light;
  }

  @Override    // Command
  public void execute() {
    theLight.turnOff();
  }
}

/** The Invoker class */
class Switch {
  public void storeAndExecute(final Command cmd) {
    cmd.execute();
  }
}

/* The test class or client */
public class CommandP {
  public static void main(String[] arguments){

    arguments = new String[]{"ON","OFF","ON","OFF"};

    final Light lamp = new Light();

    final Command switchUp = new FlipUpCommand(lamp);
    final Command switchDown = new FlipDownCommand(lamp);

    final Switch mySwitch = new Switch();



    for(String argument:arguments){
      switch(argument) {
        case "ON":
          mySwitch.storeAndExecute(switchUp);
          break;
        case "OFF":
          mySwitch.storeAndExecute(switchDown);
          break;
        default:
          System.err.println("Argument \"ON\" or \"OFF\" is required.");
          System.exit(-1);
      }

    }
  }
}
