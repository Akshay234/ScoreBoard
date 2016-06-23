public class Player {

    private final String name;
    private int position;
    private int ballsPlayed;
    private int runs;
    private int totalBallsDelivered;
    private int wicketsTaken;


    public Player(String name, int position) {
        this.name = name;
        this.position = position;
        this.runs = 0;
        this.ballsPlayed = 0;
        this.totalBallsDelivered = 0;
        this.wicketsTaken = 0;
    }

    public void updateRuns(int runs) {
        this.runs += runs;
    }

    public void incrementBallsPlayed() {
        ballsPlayed += 1;
    }

    public int upcomingPlayerPosition() {
        return position+1;
    }

    public void incrementBallsDelivery() {
        totalBallsDelivered += 1;
    }

    public boolean isOverCompleted() {
        return totalBallsDelivered >= 6;
    }

    public void creditWicket() {
        wicketsTaken += 1;
    }

    public String getName(){
        return name;
    }

    public int getBallsPlayed() {
        return ballsPlayed;
    }

    public int scored() {
        return runs;
    }
}