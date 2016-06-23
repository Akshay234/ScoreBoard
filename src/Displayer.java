public class Displayer {
    String[] details;// should be genric;
    private int totalRuns;
    private int totalWickets;
    private Players batsmans;
    private Players bowlers;
    // can pass multiple fields to displayer and show them in formated way , things like wicket taker , on strike player, on onstrike player.

    public Displayer(int totalRuns, int totalWickets, Players batsmans, Players bowlers) {
        this.totalRuns = totalRuns;
        this.totalWickets = totalWickets;
        this.batsmans = batsmans;
        this.bowlers = bowlers;
    }

    private String totalRunsTemplate() {
        return ">>> Total runs : " + totalRuns;
    }

    private String totalWicketsTemplate() {
        return ">>> Wickets : " + totalWickets;
    }

    private String playerOnStrikeStatistics() {
        return "Player on the batting end is Mr. " + batsmans.onStrike().getName() + ", he has played a total of " +batsmans.onStrike().getBallsPlayed() + " scoring "+  batsmans.onStrike().scored() +" runs.";
    }

    private String playerOnNonStrikeStatistics() {
        return "On the non-striker’s end is Mr. " + batsmans.onNonStrike().getName() + ", he has played a total of " +batsmans.onNonStrike().getBallsPlayed() + " scoring "+  batsmans.onNonStrike().scored() +" runs.";
    }


    @Override
    public String toString() {
        StringBuilder statistics = new StringBuilder();
        return String.valueOf(statistics.append(totalRunsTemplate()).append("\n").append(totalWicketsTemplate()).append("\n").append(playerOnStrikeStatistics()).append("\n").append(playerOnNonStrikeStatistics()));
    }
}