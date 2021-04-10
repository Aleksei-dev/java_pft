package ru.stqa.pft.sandbox;

/**
 * Created by coval on 3/10/2021.
 */
public class Rectangle {
  public double a;
  public double b;

  public Rectangle(double a, double b){
    this.a = a;
    this.b = b;
  }

  public double area(){
    return this.a * this.b;
  }

}
