package design_pattern;

import com.oracle.webservices.internal.api.databinding.DatabindingMode;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by zhaixuezhong(2079) on 3/7/18.
 */
public class ChainOfResponsibility {

  public static void main(String[] args) {
    ManagerPPower manager = new ManagerPPower();
    DirectorPPower director = new DirectorPPower();
    VicePresidentPPower vp = new VicePresidentPPower();
    PresidentPPower president = new PresidentPPower();
    manager.setSuccessor(director);
    director.setSuccessor(vp);
    vp.setSuccessor(president);

    // Press Ctrl+C to end.
    try {
      while (true) {
        System.out.println("Enter the amount to check who should approve your expenditure.");
        System.out.print(">");
        double d = Double.parseDouble(new BufferedReader(new InputStreamReader(System.in)).readLine());
        manager.processRequest(new PurchaseRequest(d, "General"));
      }
    } catch (Exception exc) {
      System.exit(1);
    }
  }
}


abstract class PurchasePower {
  protected static final double BASE = 500;
  protected PurchasePower successor;

  abstract protected double getAllowable();

  abstract protected String getRole();

  public void setSuccessor(PurchasePower successor) {
    this.successor = successor;
  }

  public void processRequest(PurchaseRequest request) {
    if (request.getAmount() < this.getAllowable()) {
      System.out.println(this.getRole() + " will approve $" + request.getAmount());
    } else if (successor != null) {
      successor.processRequest(request);
    }
  }
}

class ManagerPPower extends PurchasePower {

  protected double getAllowable() {
    return BASE * 10;
  }

  protected String getRole() {
    return "Manager";
  }
}

class DirectorPPower extends PurchasePower {

  protected double getAllowable() {
    return BASE * 20;
  }

  protected String getRole() {
    return "Director";
  }
}

class VicePresidentPPower extends PurchasePower {

  protected double getAllowable() {
    return BASE * 40;
  }

  protected String getRole() {
    return "Vice President";
  }
}

class PresidentPPower extends PurchasePower {

  protected double getAllowable() {
    return BASE * 60;
  }

  protected String getRole() {
    return "President";
  }
}


@Data
@AllArgsConstructor
class PurchaseRequest {
  private double amount;
  private String purpose;
}
