package ru.stqa.pft.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by coval on 4/7/2021.
 */
public class Collections {

  public static void main(String[] args) {
    String[] langs = {"Java", "C#", "Python", "PHP"};

    List<String> listLanguages = Arrays.asList("Java", "C#", "Python", "PHP");

    for (String l : listLanguages){
      System.out.println("Я хочу выучить " + l);
    }
  }
}
