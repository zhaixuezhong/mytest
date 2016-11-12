package design_pattern.decorator;

/**
 * Created by zhaixuezhong on 11/6/16.
 */
public class Coffe {

}



interface Beverage{


    public String getDescrption();

    public double getPrice();

}

class CoffeBean1 implements Beverage{


    @Override
    public String getDescrption() {
        return "have choose coffe bean 1";
    }

    @Override
    public double getPrice() {
        return 10;
    }
}


class CoffeBean2 implements Beverage{


    @Override
    public String getDescrption() {
        return "have choose coffe bean 2";
    }

    @Override
    public double getPrice() {
        return 12;
    }
}



class Decorator implements Beverage{

    String description = "this is just decorator class";

    @Override
    public String getDescrption() {
        return description;
    }

    @Override
    public double getPrice() {
        return 0;
    }
}




class Milk extends Decorator{

    String description = "have already add milk!";

    private Beverage beverage = null;

    public Milk(Beverage beverage){
        this.beverage = beverage;
    }

    public String getDescrption() {
        return beverage.getDescrption() + "\n" + description;
    }

    public double getPrice() {
        return beverage.getPrice() + 5;
    }

}


class Mocha extends Decorator{

    String description = "have already add mocha!";

    private Beverage beverage = null;

    public Mocha(Beverage beverage){
        this.beverage = beverage;
    }
    public String getDescrption() {
        return beverage.getDescrption() + "\n" + description;
    }

    public double getPrice() {
        return beverage.getPrice() + 7;
    }

}


class Test{

    public static void main(String[] args){

        Beverage beverage = new CoffeBean1();
        beverage = new Milk(beverage);
        beverage = new Mocha(beverage);

        System.out.println(beverage.getDescrption() + "\ntotal price is: " +  beverage.getPrice());




    }

}