package ball;

import ball.Ball;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class BallTest {


    @Test
    public void shouldCheckIfRunsOnThatBallIsOddRun() throws Exception {
        Ball ball1 = new Ball(1,"1");
        Ball ball2 = new Ball(2,"2");

        assertTrue(ball1.isOddRun());
        assertFalse(ball2.isOddRun());

    }

    @Test
    public void shouldCheckWicketonThatBall() throws Exception {
        Ball ball1 = new Ball(1,"W");
        Ball ball2 = new Ball(2,"2");
        assertTrue(ball1.isWicket());
        assertFalse(ball2.isWicket());

    }

    @Test
    public void ShouldReturnScoredRunsTillThatBalls() throws Exception {
        Ball ball1 = new Ball(1,"1");
        assertEquals(1,ball1.runs());
    }

    @Test
    public void wicket() throws Exception {
        Ball ball1 = new Ball(1,"W");
        assertEquals(1,ball1.wicket());

    }

    @Test
    public void ShouldCheckTheGivenballIsLastBallOfTheOver() throws Exception {
        Ball ball1 = new Ball(1,"W");
        Ball ball6 = new Ball(6,"2");

        assertTrue(ball6.last());
        assertFalse(ball1.last());
    }

}