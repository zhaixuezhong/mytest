package design_pattern.singleton01;

/**
 * Created by zhaixuezhong on 11/4/16.
 */
public class Car {
    /**
     * Created by zhaixuezhong on 11/4/16.
     */
    private volatile static Car instance;
    int i = 1;
    static int j = 0;


    private Car(){}

    public static Car instanceCar() {
        if(instance == null){


            initCar();
        }

        return instance;
    }



    public static synchronized void initCar(){
        instance = new Car();
        j ++;
    }


    public void showMessage(){
        System.out.println("Hello World! " + i + " times! and init ");
        i ++;

    }
}

class Test {

    public static void main(String[] args) {


//        Car car = Car.instanceCar();
//
//        Car car2 = Car.instanceCar();
//
//        Car car3 = Car.instanceCar();
//
//
//        car.showMessage();
//        car2.showMessage();
//        car2.showMessage();
//        car3.showMessage();

        //every time we invoke Car.instanceCar() they just return the same object

    }
}