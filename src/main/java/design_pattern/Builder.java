package design_pattern;

import java.util.function.BiFunction;

/**
 * Created by zhaixuezhong(2079) on 3/15/18.
 */

/**
 * Represents the product created by the builder.
 */

class Car {
  public final int wheels;
  public final String color;

  private Car(final int wheels, final String color) {
    this.wheels = wheels;
    this.color = color;
  }

  public static Builder<Car> builder() {
    return new Builder<>(Car::new);
  }

  @Override
  public String toString() {
    return "Car [wheels = " + wheels + ", color = " + color + "]";
  }
}

/**
 * The builder abstraction.
 */
public class Builder<T> {
  private final BiFunction<Integer, String, T> builder;

  private int wheelsOrZero;
  private String colorOrNull;

  Builder(final BiFunction<Integer, String, T> builder) {
    this.builder = builder;
  }

  public T build() {
    return builder.apply(wheelsOrZero, colorOrNull);
  }

  public Builder<T> setWheels(final int wheels) {
    wheelsOrZero = wheels;
    return this;
  }

  public Builder<T> setColor(final String color) {
    colorOrNull = color;
    return this;
  }
}
