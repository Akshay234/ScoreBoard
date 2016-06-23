import java.util.ArrayList;
import java.util.Arrays;

public class InputParser {
    private String oversDetail;
    private int OVER_LENGTH = 6;

    public InputParser(String oversDetail) {
        this.oversDetail = oversDetail;
    }

    private String[] formattedData() {
        return oversDetail.trim().replaceAll(" +", " ").split(" ");
    }

    private ArrayList<Ball> nthOverData(int over) {
        String[] separatedBallsData = formattedData();
        int from = over * OVER_LENGTH;
        int to = from + OVER_LENGTH;
        if (to > separatedBallsData.length) {
            to = separatedBallsData.length;
        }
        String[] overData = Arrays.copyOfRange(separatedBallsData, from, to);
        return convertIntoBalls(overData);
    }

    private double totalOvers() {
        int totalBalls = formattedData().length;
        int ballsLeftOfIncompleteOver = totalBalls % OVER_LENGTH;
        int completedOvers = (int) Math.floor(totalBalls / OVER_LENGTH);
        float totalCalculatedOvers = ((float) (completedOvers * 10 + ballsLeftOfIncompleteOver) / 10);
        return totalCalculatedOvers;
    }

    private Over getDetailsOfOver(int over) {
        if (totalOvers() > over) {
            return new Over(nthOverData(over));
        }
        return new Over(new ArrayList(0));
    }

    private ArrayList<Ball> convertIntoBalls(String[] overData) {
        ArrayList<Ball> balls = new ArrayList<>(overData.length);
        for (String ballValue : overData) {
            balls.add(new Ball(ballValue));
        }
        return balls;
    }

    public ArrayList<Over> getOvers() {
        int oversLength = (int) Math.ceil(totalOvers());
        ArrayList<Over> overs = new ArrayList<Over>(oversLength);
        for (int i = 0; i < oversLength; i++) {
            overs.add(getDetailsOfOver(i));
        }
        return overs;
    }

    public boolean isValid() {
        String validator = "[0-9]+|W|w";
        String[] oversData = formattedData();
        for (String ballValue : oversData) {
            if (!ballValue.matches(validator)) {
                return false;
            }
        }
        return true;
    }
}