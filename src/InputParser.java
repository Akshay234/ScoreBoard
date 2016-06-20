import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputParser {
    private String oversDetail;
    private int OVER_LENGTH = 6;

    public InputParser(String oversDetail) {
        this.oversDetail = oversDetail;
    }

    public ArrayList<Over> getOvers() {
        int oversLength = (int) Math.ceil(totalOvers());
        ArrayList<Over> overs = new ArrayList<>(oversLength);
        for (int i = 0; i < oversLength; i++) {
            overs.add(getDetailsOfOver(i));
        }
        return overs;
    }


//    public boolean isValid() {
//        return isValidBallValue() && isValidCharacters();
//    }

    private boolean isValidBallValue() {
        String[] separatedBallsData = oversDetail.split("\\s+");
        for (String ballValue : separatedBallsData) {
            if (ballValue.toString().length() != 1) {
                return false;
            }
        }
        return true;
    }

    public double totalOvers() {
        int totalBalls = formattedData().length;
        int ballsLeftOfIncompleteOver = totalBalls % OVER_LENGTH;
        int completedOvers = (int) Math.floor(totalBalls / OVER_LENGTH);
        float totalCalculatedOvers = ((float) (completedOvers * 10 + ballsLeftOfIncompleteOver) / 10);
        return totalCalculatedOvers;
    }

    public Over getDetailsOfOver(int over) {
        if (totalOvers() > over) {
            return new Over(nthOverData(over));
        }
        char[] emptyArray = new char[0];
        return new Over(emptyArray);
    }

    private char[] formattedData() {
        return oversDetail.replace(" ", "").toCharArray();
    }

    private char[] nthOverData(int over) {
        char[] separatedBallsData = formattedData();
        int from = over * OVER_LENGTH;
        int to = from + OVER_LENGTH;
        if (to > separatedBallsData.length) {
            to = separatedBallsData.length;
        }
        char[] overData = Arrays.copyOfRange(separatedBallsData, from, to);
        return overData;
    }

    public boolean isValidCharacters() {
        if(isValidBallValue()){
            char[] validCharacters = {'1', '2', '3', '4', '5', '6', 'W','w'};
            String validCharactersList = new String(validCharacters);
            char[] oversData = formattedData();
            for (char ballValue : oversData) {
                if (validCharactersList.indexOf(ballValue) == -1) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

//    public void getOverOfNthWicket(String wicketNumber) {
//    }
}