import ball.Balls;
import parser.InputParser;

import java.util.ArrayList;
import java.util.Scanner;

public class InputScanner {

    private static void display(String oversDetail, double overBuffer) throws Exception {

        InputParser inputParser = new InputParser(oversDetail, overBuffer);

        if (inputParser.isValid()) {

            BattingTeam battingTeam = BattingTeam.create(dummyBatsmans());
            BowlingTeam bowlingTeam = BowlingTeam.create(dummyBowlers());

            Balls balls = new Balls(inputParser.getBalls());
            RunsTracker runsTracker = new RunsTracker();
            WicketsTracker wicketsTracker = new WicketsTracker();
            ScoreBoard scoreBoard = new ScoreBoard();
            scoreBoard.addObserver(battingTeam);
            scoreBoard.addObserver(bowlingTeam);
            scoreBoard.addObserver(runsTracker);
            scoreBoard.addObserver(wicketsTracker);
            scoreBoard.update(balls);
            Displayer displayer = new Displayer(battingTeam, bowlingTeam, runsTracker, wicketsTracker);
            System.out.println(displayer.displayUpto(inputParser.ballsThreshold()));

        } else {
            throw new Exception("Given [ " + oversDetail + " ] are Invalid");
        }
    }

    private static Players dummyBatsmans() {
        ArrayList<String> batsmansList = new ArrayList<String>();
        batsmansList.add("W");
        batsmansList.add("X");
        batsmansList.add("Y");
        batsmansList.add("Z");
        return Players.create(batsmansList);

    }

    private static Players dummyBowlers() {
        ArrayList<String> bowlersList = new ArrayList<>();
        bowlersList.add("A");
        bowlersList.add("B");
        bowlersList.add("C");
        bowlersList.add("D");
        return Players.create(bowlersList);
    }

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Give overs input: ");

        String oversDetail = scanner.nextLine();

        System.out.print("How much overs scoreboard you want to see: ");

        double overBuffer = scanner.nextDouble();

        display(oversDetail, overBuffer);
    }
}

