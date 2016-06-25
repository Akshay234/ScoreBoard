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

    private String totalRunsTemplate(int balls) {
        return ">>> Total runs : " + runsTracker.totalUpto(balls);
    }

    private String totalWicketsTemplate(int balls) {
        return ">>> Wickets : " + wicketsTracker.totalUpto(balls);
    }

    private String playerOnStrikeStatistics(int balls) {
        Player playerOnStrike = battingTeam.playerOnStrike();
        return ">>> Player on the batting end is Mr. " + playerOnStrike.name() + ", he has played a total of " +playerOnStrike.ballsPlayed() + " scoring "+  playerOnStrike.scored() +" runs.";
    }

    private String playerOnNonStrikeStatistics(int balls) {
        Player playerOnNonStrike = battingTeam.playerOnNonStrike();
        return ">>> On the non-striker’s end is Mr. " + playerOnNonStrike.name() + ", he has played a total of " + playerOnNonStrike.ballsPlayed() + " scoring "+  playerOnNonStrike.scored() +" runs.";
    }

    private String lastBatsmanOutStatistics() {
        Player batsmanGotOut = battingTeam.lastBatsmanGotOut();
        return ">>> Mr "+ batsmanGotOut.name() +" got out playing a total of "+ batsmanGotOut.ballsPlayed()+" balls scoring "+batsmanGotOut.scored()+" runs.";
    }

    public String displayUpto(int balls) {
        StringBuilder statistics = new StringBuilder();
        return String.valueOf(statistics.append(totalRunsTemplate(balls)).
                append("\n").append(totalWicketsTemplate(balls)).
                append("\n").append(playerOnStrikeStatistics(balls)).
                append("\n").append(playerOnNonStrikeStatistics(balls)).
                append("\n").append(lastBatsmanOutStatistics()).
                append(lastBowlerCreditWithWicketTemplate())
        );
    }

    private String lastBowlerCreditWithWicketTemplate() {
        Player lastWicketTaker = bowlingTeam.lastWicketTaker();
        return " Bowler "+lastWicketTaker.name()+" is credited with his wicket!";
    }
}