package design_practice;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaixuezhong(2079) on 4/23/18.
 */
public class Builder {

  public static void main(String[] args) {
    MealBuilder mealBuilder = new MealBuilder();
    Meal meal = mealBuilder.parpareMeatMeal();
    meal.showItems();
    meal.getCost();


    Meal meal2 = mealBuilder.parpareVegMeal();
    meal.showItems();
    meal.getCost();

  }
}


interface Packing{
  String packing();
}


class Wapper implements Packing{

  @Override
  public String packing() {
    return "Wapper...";
  }
}

class Bottom implements Packing{

  @Override
  public String packing() {
    return null;
  }
}

interface Item{
  String name();

  Packing pack();

  float price();
}


abstract class Burger implements Item{
  public Packing pack() {
    return new Wapper();
  }
}

abstract class Drink implements Item{
  public Packing pack() {
    return new Wapper();
  }
}

class VegBurger extends Burger{

  @Override
  public String name() {
    return "veg burger";
  }

  @Override
  public float price() {
    return 4;
  }
}


class MeatBurger extends Burger{

  @Override
  public String name() {
    return "meat burger";
  }

  @Override
  public float price() {
    return 8;
  }
}


class Coke extends Drink{

  @Override
  public String name() {
    return "coke";
  }

  @Override
  public float price() {
    return 1;
  }
}

class Pepsi extends Drink{


  @Override
  public String name() {
    return "Pepsi";
  }

  @Override
  public float price() {
    return 1.2F;
  }
}


class Meal{
  List<Item> items = new ArrayList<>();

  public void addItems(Item item){
    this.items.add(item);
  }


  public float getCost(){
    float cost = 0.0F;
    for(Item item:items){
      cost += item.price();
    }
    return cost;
  }

  public void showItems(){
    for(Item item:items){
      System.out.println(item.name());
      System.out.println(item.pack().packing());
      System.out.println(item.price());
    }
  }
}



class MealBuilder{

  public Meal parpareVegMeal(){
    Meal meal = new Meal();
    meal.addItems(new VegBurger());
    meal.addItems(new Coke());
    return meal;
  }

  public Meal parpareMeatMeal(){
    Meal meal = new Meal();
    meal.addItems(new MeatBurger());
    meal.addItems(new Pepsi());
    return meal;
  }

}
