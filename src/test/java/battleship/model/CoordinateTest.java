package battleship.model;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CoordinateTest {
    @DataProvider
    public Object[][] coordinateData() {
        return new Object[][] {
                { new Coordinate(3, 4), 5, Direction.SOUTH, new Coordinate(8, 4) },
                { new Coordinate(8, 4), 6, Direction.NORTH, new Coordinate(2, 4) },
                { new Coordinate(3, 4), 2, Direction.WEST, new Coordinate(3, 2) },
                { new Coordinate(8, 7), 3, Direction.EAST, new Coordinate(8, 10) },
        };
    }

    @Test(dataProvider = "coordinateData", description = "Test plus method with some data")
    public void plusTest(Coordinate start, int length, Direction direction, Coordinate end) {
        Assert.assertEquals(start.plus(length, direction), end);
    }

    @Test(description = "Test plus column")
    public void plusColumnTest() {
        Assert.assertEquals(new Coordinate(2, 4).plusColumn(2), new Coordinate(2, 6));
    }

    @Test(description = "Test plus row")
    public void plusRowTest() {
        Assert.assertEquals(new Coordinate(2, 4).plusRow(-2), new Coordinate(0, 4));
    }
}
