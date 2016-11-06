package design_pattern.singleton;

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

            synchronized (Car.class){

                if(instance == null){
                    instance = new Car();

                }

            }
        }

        return instance;
    }





    public void showMessage(){
        System.out.println("Hello World! " + i + " times! and init ");
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



        int i1 = 0;
        int j1 = 0;

        int i2 = 0;
        int j2 = 0;

        j1 = i1++;
        j2 = ++i2;

        System.out.println(j1 + " " + j2 );




        String[] s = {"",""};
        int k = s.length;

    }
}