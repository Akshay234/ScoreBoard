package tracker;

import ball.Ball;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WicketsTrackerTest {
    Ball ball_with_0_runs;
    Ball ball_with_1_runs;
    Ball ball_with_2_runs;
    Ball ball_with_wicket;

    @Before
    public void setUp() throws Exception {
        ball_with_0_runs = new Ball("0");
        ball_with_1_runs = new Ball("1");
        ball_with_2_runs = new Ball("2");
        ball_with_wicket = new Ball("W");
    }

    @Test
    public void should_give_a_total_of_runs_taken_on_given_balls() {
        WicketsTracker wicketsTracker = new WicketsTracker();
        wicketsTracker.update(null, ball_with_0_runs);
        wicketsTracker.update(null, ball_with_1_runs);
        wicketsTracker.update(null, ball_with_wicket);
        wicketsTracker.update(null, ball_with_2_runs);
        wicketsTracker.update(null, ball_with_wicket);

        Assert.assertEquals(2, wicketsTracker.total());
    }
}