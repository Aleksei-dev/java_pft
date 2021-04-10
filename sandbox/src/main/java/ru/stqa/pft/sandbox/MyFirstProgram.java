package ru.stqa.pft.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {
    System.out.println("Hello, World!");

    Point p1 = new Point(2,8);
    Point p2 = new Point(5,6);
    System.out.println("Расстояние между двумя точками А с координатами x: " + p1.x + " и " + "y: " + p1.y + " и точки B с координатами x: " + p2.x + " и y: " +  p2.y + " = " + p1.distance(p2));

//    Square s = new Square(5);
//    System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

//    Rectangle r = new Rectangle(3,5);
//    System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());
  }

}