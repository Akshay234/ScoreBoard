package main.scoreBoard;

import ball.Ball;
import ball.Balls;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import player.Players;
import teams.BattingTeam;
import teams.BowlingTeam;
import tracker.RunsTracker;
import tracker.WicketsTracker;

import java.util.ArrayList;

public class ScoreBoardTest {

    private WicketsTracker wicketsTracker;
    private BowlingTeam bowlingTeam;
    private RunsTracker runsTracker;
    private BattingTeam battingTeam;
    private Balls balls;
    private Players batsmans;
    private Players bowlers;

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
        batsmans = Players.create(batsmansList);
        bowlers = Players.create(bowlersList);
        battingTeam = BattingTeam.create(batsmans);
        bowlingTeam = BowlingTeam.create(bowlers);
        runsTracker = new RunsTracker();
        wicketsTracker = new WicketsTracker();
        ArrayList<Ball> ballsList = new ArrayList<>();
        ballsList.add(new Ball("0"));
        ballsList.add(new Ball("w"));
        ballsList.add(new Ball("2"));
        ballsList.add(new Ball("1"));
        ballsList.add(new Ball("4"));
        balls = new Balls(ballsList);
    }

    @Test
    public void should_notify_all_observers_when_updated() {
        ScoreBoard scoreBoard = new ScoreBoard();
        scoreBoard.addObserver(battingTeam);
        scoreBoard.addObserver(bowlingTeam);
        scoreBoard.addObserver(runsTracker);
        scoreBoard.addObserver(wicketsTracker);
        scoreBoard.update(balls);
        Assert.assertEquals(1, battingTeam.playerOnStrike().ballsPlayed());
        Assert.assertEquals(4, battingTeam.playerOnStrike().scored());

        Assert.assertEquals(2, battingTeam.playerOnNonStrike().ballsPlayed());
        Assert.assertEquals(3, battingTeam.playerOnNonStrike().scored());

        Assert.assertEquals(batsmans.get(0), battingTeam.lastBatsmanGotOut());
        Assert.assertEquals(bowlers.get(0), bowlingTeam.lastWicketTaker());

        Assert.assertEquals(7, runsTracker.total());
        Assert.assertEquals(1, wicketsTracker.total());

    }


}