package ru.stqa.pft.sandbox;

/**
 * Created by coval on 3/11/2021.
 */
public class Point {
  double x;
  double y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double distance(Point p) {
    double res = Math.sqrt(square(p.x-this.x)+square(p.y-this.y));
    return Math.floor(res)*100/100;
  }

  public static double square(double a){
    double res = a*a;
    return res;
  }
}
