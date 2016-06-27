package teams;

import ball.Ball;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import player.Players;

import java.util.ArrayList;

public class BowlingTeamTest {

    private BowlingTeam bowlingTeam;
    private Players bowlers;

    @Before
    public void setUp() throws Exception {
        ArrayList<String> bowlersList = new ArrayList<>();
        bowlersList.add("Bow1");
        bowlersList.add("Bow2");
        bowlersList.add("Bow3");
        bowlersList.add("Bow4");
        bowlersList.add("Bow5");
        bowlers = Players.create(bowlersList);
        bowlingTeam = BowlingTeam.create(bowlers);
    }

    @Test
    public void should_track_the_last_wicket_taking_bowler() {
        Ball ball_with_1_run = new Ball("1");
        Ball ball_with_2_runs = new Ball("2");
        Ball ball_with_wicket = new Ball("W");
        bowlingTeam.update(null, ball_with_1_run);
        bowlingTeam.update(null, ball_with_2_runs);
        bowlingTeam.update(null, ball_with_wicket);
        Assert.assertEquals(bowlingTeam.lastWicketTaker(), bowlers.get(0));

        bowlingTeam.update(null, ball_with_1_run);
        bowlingTeam.update(null, ball_with_2_runs);
        bowlingTeam.update(null, ball_with_2_runs);
        bowlingTeam.update(null, ball_with_wicket);
        Assert.assertEquals(bowlingTeam.lastWicketTaker(), bowlers.get(1));

        bowlingTeam.update(null, ball_with_1_run);
        bowlingTeam.update(null, ball_with_2_runs);
        bowlingTeam.update(null, ball_with_2_runs);
        bowlingTeam.update(null, ball_with_1_run);
        bowlingTeam.update(null, ball_with_1_run);
        bowlingTeam.update(null, ball_with_1_run);
        Assert.assertEquals(bowlingTeam.lastWicketTaker(), bowlers.get(1));

    }
}