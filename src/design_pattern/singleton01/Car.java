package design_pattern.singleton01;

/**
 * Created by zhaixuezhong on 11/4/16.
 */
public class Car {
    /**
     * Created by zhaixuezhong on 11/4/16.
     */
        private static Car instance = new Car();
        int i = 0;


        private Car(){}

        public static Car instanceCar() {
            return instance;
        }


        public void showMessage(){
            System.out.println("Hello World! " + i + " times!");
            i ++;
            }
}

class Test {

    public static void main(String[] args) {


        Car car = Car.instanceCar();


        Car car2 = Car.instanceCar();

        Car car3 = Car.instanceCar();


        car.showMessage();
        car2.showMessage();
        car2.showMessage();
        car3.showMessage();

        //every time we invoke Car.instanceCar() they just return the same object

    }
}