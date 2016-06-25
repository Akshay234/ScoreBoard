package show;

import player.Player;
import teams.BattingTeam;
import teams.BowlingTeam;
import tracker.RunsTracker;
import tracker.WicketsTracker;

public class Displayer {

    private final BattingTeam battingTeam;
    private final BowlingTeam bowlingTeam;
    private final RunsTracker runsTracker;
    private final WicketsTracker wicketsTracker;

    public Displayer(BattingTeam battingTeam, BowlingTeam bowlingTeam, RunsTracker runsTracker, WicketsTracker wicketsTracker) {
        this.battingTeam = battingTeam;
        this.bowlingTeam = bowlingTeam;
        this.runsTracker = runsTracker;
        this.wicketsTracker = wicketsTracker;
    }

    private String totalRunsTemplate() {
        return ">>> Total runs : " + runsTracker.total();
    }

    private String totalWicketsTemplate() {
        return ">>> Wickets : " + wicketsTracker.total();
    }

    private String playerOnStrikeStatistics() {
        Player playerOnStrike = battingTeam.playerOnStrike();
        return ">>> Player on the batting end is Mr. " + playerOnStrike.name() + ", he has played a total of " + playerOnStrike.ballsPlayed()+ " balls" + " scoring " + playerOnStrike.scored() + " runs.";
    }

    private String playerOnNonStrikeStatistics() {
        Player playerOnNonStrike = battingTeam.playerOnNonStrike();
        return ">>> On the non-striker’s end is Mr. " + playerOnNonStrike.name() + ", he has played a total of " + playerOnNonStrike.ballsPlayed()+ " balls" + " scoring " + playerOnNonStrike.scored() + " runs.";
    }

    private String lastBatsmanOutStatistics() {
        Player batsmanGotOut = battingTeam.lastBatsmanGotOut();
        return ">>> Mr " + batsmanGotOut.name() + " got out playing a total of " + batsmanGotOut.ballsPlayed() + " balls scoring " + batsmanGotOut.scored() + " runs.";
    }

    private String lastBowlerCreditWithWicketTemplate() {
        Player lastWicketTaker = bowlingTeam.lastWicketTaker();
        return " Bowler " + lastWicketTaker.name() + " is credited with his wicket!";
    }

    public String display() {
        StringBuilder statistics = new StringBuilder();
        statistics = statistics.append(totalRunsTemplate()).
                append("\n").append(totalWicketsTemplate()).
                append("\n").append(playerOnStrikeStatistics()).
                append("\n").append(playerOnNonStrikeStatistics());
        if (bowlingTeam.lastWicketTaker() != null) {
            statistics = statistics.append("\n").append(lastBatsmanOutStatistics()).append(lastBowlerCreditWithWicketTemplate());
        }
        return String.valueOf(statistics);
    }
}