package design_pattern.factory.factory_method;

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


abstract class Factory {


    public Car getCar(){
        return null;
    }


}


class EleCarFactory extends Factory{

    @Override
    public Car getCar() {
        Car car = new EleCar();
        return car;

    }
}

class GasCarFactory extends Factory{

    @Override
    public Car getCar() {
        Car car = new GASCar();
        return car;

    }

}



class Test{


    public static void main(String[] args) {

        Factory factory;
        Car car;
        char aaa = 'A';

        if(aaa == 'A'){
            factory = new EleCarFactory();
            car = factory.getCar();
        }else if(aaa == 'B'){
            factory = new GasCarFactory();
            car = factory.getCar();
        }



        switch (aaa){
            case('A'):System.out.println("this is A");break;
            case('B'):System.out.println("this is B");break;
            case('C'):System.out.println("this is C");break;
            case('D'):System.out.println("this is D");break;
            case('E'):System.out.println("this is E");break;
        }

        System.out.println("this is the end");
    }
}