package ball;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BallsTest {


    @Test
    public void ShouldShowTotalNoOfBalls() throws Exception {
         ArrayList<Ball> balls = new ArrayList<>();

        Ball ball1 = new Ball("1");
        Ball ball2 = new Ball("2");

        balls.add(ball1);
        balls.add(ball2);

        assertEquals(2,balls.size());
        assertTrue(balls.contains(ball1));
    }


}