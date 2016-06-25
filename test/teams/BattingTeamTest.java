package teams;

import ball.Ball;
import ball.Balls;
import org.junit.Test;
import player.Player;
import player.Players;

import java.util.ArrayList;
import java.util.Observable;

import static org.junit.Assert.*;

public class BattingTeamTest {
    @Test
    public void shouldCheckPlayerOnStrikeAndNonStrike() throws Exception {

        ArrayList<String> team = new ArrayList<>();
        team.add("p1");
        team.add("p2");
        team.add("p3");
        team.add("p4");
        team.add("p5");

        Players players = Players.create(team);


        BattingTeam battingTeam = BattingTeam.create(players);

        assertEquals("p1", battingTeam.playerOnStrike().name());

        assertEquals("p2", battingTeam.playerOnNonStrike().name());

        battingTeam.update(null, new Ball(1, "W"));

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

        assertEquals("p1", battingTeam.playerOnStrike().name());

        assertEquals("p2", battingTeam.playerOnNonStrike().name());

        battingTeam.update(null, new Ball(6, "1"));


        assertEquals("p1", battingTeam.playerOnStrike().name());

        assertEquals("p2", battingTeam.playerOnNonStrike().name());


    }
    @Test
    public void shouldCheckThatIfABatsmanTookEvenNumberOfRunsOnTheLastBallThenHeIsOnStrike() throws Exception {
        ArrayList<String> team = new ArrayList<>();
        team.add("p1");
        team.add("p2");
        Players players = Players.create(team);


        BattingTeam battingTeam = BattingTeam.create(players);

        assertEquals("p1", battingTeam.playerOnStrike().name());

        assertEquals("p2", battingTeam.playerOnNonStrike().name());

        battingTeam.update(null, new Ball(2, "4"));


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


        BattingTeam battingTeam = BattingTeam.create(players);

        assertEquals("p1", battingTeam.playerOnStrike().name());

        assertEquals("p2", battingTeam.playerOnNonStrike().name());

        battingTeam.update(null, new Ball(6, "W"));

        assertEquals("p2", battingTeam.playerOnStrike().name());
        assertEquals("p3", battingTeam.playerOnNonStrike().name());

    }
}
