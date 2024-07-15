package battleship.model;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PlayerTest {
    @Test(description = "Invert Player.FIRST into Player.SECOND")
    public void inverseTest1() {
        // GIVEN
        Player player = Player.FIRST;
        Player expected = Player.SECOND;
        // WHEN
        Player result = player.inverse();
        // THEN
        Assert.assertEquals(result, expected);
    }

    @Test(description = "Invert Player.SECOND into Player.FIRST")
    public void inverseTest2() {
        // GIVEN
        Player player = Player.SECOND;
        Player expected = Player.FIRST;
        // WHEN
        Player result = player.inverse();
        // THEN
        Assert.assertEquals(result, expected);
    }
}
