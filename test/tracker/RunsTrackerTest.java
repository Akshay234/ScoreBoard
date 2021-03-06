package tracker;

import ball.Ball;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RunsTrackerTest {
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
        RunsTracker runsTracker = new RunsTracker();
        runsTracker.update(null, ball_with_0_runs);
        runsTracker.update(null, ball_with_1_runs);
        runsTracker.update(null, ball_with_wicket);
        runsTracker.update(null, ball_with_2_runs);

        Assert.assertEquals(3, runsTracker.total());
    }
}