package teams;

import ball.Ball;
import ball.Balls;
import org.junit.Test;

import player.Players;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BattingTeamTest {
    @Test
    public void shouldCheckPlayerOnStrikeAndNonStrike() throws Exception {

        ArrayList<String> team = new ArrayList<>();
        team.add("p1");
        team.add("p2");
        team.add("p3");

        Players players = Players.create(team);


        BattingTeam battingTeam = BattingTeam.create(players);

        assertEquals("p1", battingTeam.playerOnStrike().name());

        assertEquals("p2", battingTeam.playerOnNonStrike().name());


        ArrayList<Ball> balls = new ArrayList<>();

        Ball ball1 = new Ball("1");

        balls.add(ball1);

        battingTeam.update(null, new Ball("W"));

        assertEquals("p1", battingTeam.lastBatsmanGotOut().name());

        assertEquals("p3", battingTeam.playerOnStrike().name());
    }

    @Test
    public void shouldcheckThatIfABatsmanTookOddNumberOfRunsOnTheLastBallThenHeIsOnStrike() throws Exception {
        ArrayList<String> team = new ArrayList<>();
        team.add("p1");
        team.add("p2");
        team.add("p3");
        team.add("p4");
        team.add("p5");


        Players players = Players.create(team);


        BattingTeam battingTeam = BattingTeam.create(players);

        ArrayList<Ball> balls = new ArrayList<>();
        Ball ball1 = new Ball("1");

        balls.add(ball1);
        balls.add(ball1);
        balls.add(ball1);
        balls.add(ball1);
        balls.add(ball1);
        balls.add(ball1);

        assertEquals("p1", battingTeam.playerOnStrike().name());

        assertEquals("p2", battingTeam.playerOnNonStrike().name());

        battingTeam.update(null,ball1);
        battingTeam.update(null,ball1);
        battingTeam.update(null,ball1);
        battingTeam.update(null,ball1);
        battingTeam.update(null,ball1);
        battingTeam.update(null,ball1);


        assertEquals("p1", battingTeam.playerOnStrike().name());

        assertEquals("p2", battingTeam.playerOnNonStrike().name());


    }
    @Test
    public void shouldCheckThatIfABatsmanGotOutOnTheLastBallThenTheNonSteikerPlayerIsNowOnStriker() throws Exception {
        ArrayList<String> team = new ArrayList<>();
        team.add("p1");
        team.add("p2");
        team.add("p3");
        team.add("p4");
        team.add("p5");

        Players players = Players.create(team);

        ArrayList<Ball> balls = new ArrayList<>();
        Ball ball1 = new Ball("2");
        Ball ball2 = new Ball("W");

        balls.add(ball1);
        balls.add(ball1);
        balls.add(ball1);
        balls.add(ball1);
        balls.add(ball1);
        balls.add(ball2);


        BattingTeam battingTeam = BattingTeam.create(players);

        assertEquals("p1", battingTeam.playerOnStrike().name());

        assertEquals("p2", battingTeam.playerOnNonStrike().name());

        battingTeam.update(null,ball1);
        battingTeam.update(null,ball1);
        battingTeam.update(null,ball1);
        battingTeam.update(null,ball1);
        battingTeam.update(null,ball1);
        battingTeam.update(null,ball2);

        assertEquals("p2", battingTeam.playerOnStrike().name());
        assertEquals("p3", battingTeam.playerOnNonStrike().name());

    }

    @Test
    public void shouldCheckThatIfABatsmanTookEvenNumberOfRunsOnTheLastBallThenHeIsOnStrike() throws Exception {
        ArrayList<String> team = new ArrayList<>();
        team.add("p1");
        team.add("p2");
        team.add("p3");
        team.add("p4");
        team.add("p5");


        Players players = Players.create(team);


        BattingTeam battingTeam = BattingTeam.create(players);

        ArrayList<Ball> balls = new ArrayList<>();

        Ball ball2 = new Ball("2");

        balls.add(ball2);
        balls.add(ball2);
        balls.add(ball2);
        balls.add(ball2);
        balls.add(ball2);
        balls.add(ball2);

        assertEquals("p1", battingTeam.playerOnStrike().name());

        assertEquals("p2", battingTeam.playerOnNonStrike().name());

        battingTeam.update(null, ball2);
        battingTeam.update(null, ball2);
        battingTeam.update(null, ball2);
        battingTeam.update(null, ball2);
        battingTeam.update(null, ball2);
        battingTeam.update(null, ball2);


        assertEquals("p2", battingTeam.playerOnStrike().name());

        assertEquals("p1", battingTeam.playerOnNonStrike().name());
    }
}
