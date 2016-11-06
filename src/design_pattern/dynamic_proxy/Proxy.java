package design_pattern.dynamic_proxy;

import java.sql.Timestamp;

/**
 * Created by zhaixuezhong on 11/4/16.
 */
public class Proxy {
}


class Car{
    private String consumer;
    long produceTime;

    public Car(){
    System.out.println("new Car");
    produceTime = System.currentTimeMillis();
    };

    public String getConsumer() {
        return consumer;
    }

    public void setConsumer(String consumer) {
        this.consumer = consumer;
    }

    public long getProduceTime() {
        return produceTime;
    }

    public void setProduceTime(long produceTime) {
        this.produceTime = produceTime;
    }
}


interface CarFactory{
    void sellCar();
}



class CarProduce implements CarFactory {
        Car car;
        CarProduce(String consumer){
            car = new Car();
            car.setConsumer(consumer);
        }

        @Override
        public void sellCar() {
            System.out.println("car no." + car.hashCode() + " has been sold! \n now the owner is "+ car.getConsumer());
        }
}


class CarProxy implements CarFactory{

    public CarProduce carProduce;
    CarProxy(){
        carProduce = new CarProduce("lily");
    }

    @Override
    public void sellCar() {
        carProduce.sellCar();
    }
}

class Test{

    public static void main(String[] args){
        CarFactory cp = new CarProxy();
        cp.sellCar();
    }


}