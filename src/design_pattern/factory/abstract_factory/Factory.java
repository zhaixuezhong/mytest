package design_pattern.factory.abstract_factory;

/**
 * Created by zhaixuezhong on 11/4/16.
 */
abstract class Car{

    String color;

    String icon;


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}


class EleCar extends Car {
    public EleCar(){
        System.out.println("this is electratical car!");
    }


}


class GASCar extends Car {
    public GASCar(){
        System.out.println("this is gasoline car!");
    }

}



abstract class AirCondition{

    public AirCondition(){
    }
}



class AirCondition1 extends AirCondition{

    public AirCondition1(){
        System.out.println("this is air condition 1");
    }


}




class AirCondition2 extends AirCondition{

    public void AirCondition2(){
        System.out.println("this is air condition 2");
    }


}





abstract class Factory {
    Car car;
    AirCondition airCondition;

    public Car getCar(){
        return null;
    }


    public AirCondition getCondition(){
    return null;
    }
}


class EleCarFactory extends Factory {


    @Override
    public Car getCar() {
        car = new EleCar();
        return car;

    }

    @Override
    public AirCondition getCondition(){
        airCondition = new AirCondition1();
        return airCondition;
    }
}

class GasCarFactory extends Factory {

    @Override
    public Car getCar() {
        car = new GASCar();
        return car;

    }

    @Override
    public AirCondition getCondition(){
        airCondition = new AirCondition2();
        return airCondition;
    }

}


class Test{


    public static void main(String[] args) {

        Factory factory;
        Car car;
        AirCondition airCondition;
        String aaa = "ELE";

        if("ELE".equals(aaa)){
            factory = new EleCarFactory();
            car = factory.getCar();
            airCondition = factory.getCondition();
        }else if("GAS".equals(aaa)){
            factory = new GasCarFactory();
            car = factory.getCar();
            airCondition = factory.getCondition();
        }


        System.out.println("this is the end");
    }
}