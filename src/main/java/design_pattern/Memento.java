package design_pattern;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by zhaixuezhong(2079) on 3/15/18.
 */

class Originator {
  private String state;
  // The class could also contain additional data that is not part of the
  // state saved in the memento..

  public void set(String state) {
    this.state = state;
    System.out.println("Originator: Setting state to " + state);
  }

  public Memento saveToMemento() {
    System.out.println("Originator: Saving to Memento.");
    return new Memento(this.state);
  }

  public void restoreFromMemento(Memento memento) {
    this.state = memento.getSavedState();
    System.out.println("Originator: State after restoring from Memento: " + state);
  }

  public static class Memento {
    private final String state;

    public Memento(String stateToSave) {
      state = stateToSave;
    }

    // accessible by outer class only
    private String getSavedState() {
      return state;
    }
  }
}


class CareTaker{

  List<Originator.Memento> savedStates = new ArrayList<>();


  public Originator.Memento getMemento(int i){
    return savedStates.get(i);
  }

  public void put(Originator.Memento memento){
    savedStates.add(memento);
  }
}


public class Memento {
  public static void main(String[] args) {
    CareTaker careTaker = new CareTaker();

    Originator originator = new Originator();
    originator.set("State1");
    originator.set("State2");
    careTaker.put(originator.saveToMemento());
    originator.set("State3");
    // We can request multiple mementos, and choose which one to roll back to.
    careTaker.put(originator.saveToMemento());
    originator.set("State4");

    originator.restoreFromMemento(careTaker.getMemento(1));
  }
}
