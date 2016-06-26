package player;

public class Player {

    private final String name;
    private int ballsPlayed;
    private int runs;
    private int totalBallsDelivered;


    public Player(String name) {
        this.name = name;
        this.runs = 0;
        this.ballsPlayed = 0;
        this.totalBallsDelivered = 0;
    }

    public void updateRuns(int runs) {
        this.runs += runs;
    }

    public void incrementBallsPlayed() {
        ballsPlayed += 1;
    }

    public void incrementBallsDelivery() {
        totalBallsDelivered += 1;
    }

    public boolean isOverCompleted() {
        return totalBallsDelivered >= 6;
    }

    public String name(){
        return name;
    }

    public int ballsPlayed() {
        return ballsPlayed;
    }

    public int scored() {
        return runs;
    }
}