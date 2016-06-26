package show;

import ball.Ball;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import player.Players;
import teams.BattingTeam;
import teams.BowlingTeam;
import tracker.RunsTracker;
import tracker.WicketsTracker;

import java.util.ArrayList;

public class DisplayerTest {
    BattingTeam battingTeam;
    BowlingTeam bowlingTeam;
    RunsTracker runsTracker;
    WicketsTracker wicketsTracker;

    @Before
    public void setUp() throws Exception {
        ArrayList<String> batsmansList = new ArrayList<>();
        batsmansList.add("Bat1");
        batsmansList.add("Bat2");
        batsmansList.add("Bat3");
        batsmansList.add("Bat4");
        batsmansList.add("Bat5");

        ArrayList<String> bowlersList = new ArrayList<>();
        bowlersList.add("Bow1");
        bowlersList.add("Bow2");
        bowlersList.add("Bow3");
        bowlersList.add("Bow4");
        bowlersList.add("Bow5");
        Players batsmans = Players.create(batsmansList);
        battingTeam = BattingTeam.create(batsmans);
        Players bowlers = Players.create(bowlersList);
        bowlingTeam = BowlingTeam.create(bowlers);
        runsTracker = new RunsTracker();
        wicketsTracker = new WicketsTracker();
    }

    @Test
    public void should_show_scoreBoard_when_zero_balls_are_played() {
        Displayer displayer = new Displayer(battingTeam, bowlingTeam, runsTracker, wicketsTracker);
        String expectedDisplay = ">>> Total runs : 0\n" +
                ">>> Wickets : 0\n" +
                ">>> Player on the batting end is Mr. Bat1, he has played a total of 0 balls scoring 0 runs.\n" +
                ">>> On the non-striker’s end is Mr. Bat2, he has played a total of 0 balls scoring 0 runs.";
        Assert.assertEquals(expectedDisplay, displayer.display());
    }

    @Test
    public void should_show_scoreBoard_when_balls_are_played() {
        Ball ball_with_1_run = new Ball("1");
        Ball ball_with_2_runs = new Ball("2");
        battingTeam.update(null, ball_with_1_run);
        bowlingTeam.update(null, ball_with_1_run);
        runsTracker.update(null, ball_with_1_run);
        wicketsTracker.update(null, ball_with_1_run);
        battingTeam.update(null, ball_with_2_runs);
        bowlingTeam.update(null, ball_with_2_runs);
        runsTracker.update(null, ball_with_2_runs);
        wicketsTracker.update(null, ball_with_2_runs);
        Displayer displayer = new Displayer(battingTeam, bowlingTeam, runsTracker, wicketsTracker);
        String expectedDisplay = ">>> Total runs : 3\n" +
                ">>> Wickets : 0\n" +
                ">>> Player on the batting end is Mr. Bat2, he has played a total of 1 balls scoring 2 runs.\n" +
                ">>> On the non-striker’s end is Mr. Bat1, he has played a total of 1 balls scoring 1 runs.";
        Assert.assertEquals(expectedDisplay, displayer.display());
    }

    @Test
    public void should_show_scoreBoard_with_fallen_wicket_and_credited_bowler() {
        Ball ball_with_1_run = new Ball("1");
        Ball ball_with_wicket = new Ball("W");
        battingTeam.update(null, ball_with_1_run);
        bowlingTeam.update(null, ball_with_1_run);
        runsTracker.update(null, ball_with_1_run);
        wicketsTracker.update(null, ball_with_1_run);
        battingTeam.update(null, ball_with_wicket);
        bowlingTeam.update(null, ball_with_wicket);
        runsTracker.update(null, ball_with_wicket);
        wicketsTracker.update(null, ball_with_wicket);
        Displayer displayer = new Displayer(battingTeam, bowlingTeam, runsTracker, wicketsTracker);
        String expectedDisplay = ">>> Total runs : 1\n" +
                ">>> Wickets : 1\n" +
                ">>> Player on the batting end is Mr. Bat3, he has played a total of 0 balls scoring 0 runs.\n" +
                ">>> On the non-striker’s end is Mr. Bat1, he has played a total of 1 balls scoring 1 runs.\n" +
                ">>> Mr Bat2 got out playing a total of 1 balls scoring 0 runs. Bowler Bow1 is credited with his wicket!";
        Assert.assertEquals(expectedDisplay, displayer.display());
    }
}