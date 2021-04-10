package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by coval on 3/15/2021.
 */
public class PointTests {

    @Test
    public void testDistance() {
        Point p = new Point(3,-8);
        Point p2 = new Point(5,2);
        Point p3 = new Point(4,1);
        Assert.assertEquals(p.distance(p2), 10.0);
        Assert.assertEquals(p.distance(p3), 9.0);
    }
}
