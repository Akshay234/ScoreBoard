import java.util.Arrays;

public class Displayer {
    String[] details;// should be genric;
    private int totalRuns;
    // can pass multiple fields to displayer and show them in formated way , things like wicket taker , on strike player, on onstrike player,

    public Displayer(int totalRuns) {
        this.totalRuns = totalRuns;
    }

    @Override
    public String toString() {
        return "ScoreBoard {" + ", totalRuns=" + totalRuns + '}';
    }
}