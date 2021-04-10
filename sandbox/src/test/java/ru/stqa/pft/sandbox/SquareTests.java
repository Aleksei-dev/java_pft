package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by coval on 3/15/2021.
 */
public class SquareTests {

    @Test
    public void teatArea(){
        Square s = new Square(5);
        Assert.assertEquals(s.area(), 25.0);
    }
}
