package player;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {
    @Test
    public void shouldCountTheBallPlayedByPlayer() throws Exception {
        Player batsman = new Player("Test 1");
        batsman.ballsPlayed();

        assertEquals(0, batsman.ballsPlayed());

        batsman.incrementBallsPlayed();
        batsman.incrementBallsPlayed();
        batsman.incrementBallsPlayed();
        batsman.incrementBallsPlayed();
        batsman.incrementBallsPlayed();

        assertEquals("Test 1", batsman.name());
        assertEquals(5, batsman.ballsPlayed());

    }

    @Test
    public void shouldCountTheBallDeliveredByPlayer() throws Exception {
        Player bowler = new Player("Test 1");

        assertFalse(bowler.isOverCompleted());

        bowler.incrementBallsDelivery();
        bowler.incrementBallsDelivery();
        bowler.incrementBallsDelivery();
        bowler.incrementBallsDelivery();
        bowler.incrementBallsDelivery();
        bowler.incrementBallsDelivery();

        assertTrue(bowler.isOverCompleted());

    }

    @Test
    public void shouldCountTheRunScoredByPlayer() throws Exception {
        Player batsman = new Player("Test 1");
        assertEquals(0,batsman.scored());

        batsman.updateRuns(1);
        batsman.updateRuns(2);

        assertEquals(3,batsman.scored());

    }
}