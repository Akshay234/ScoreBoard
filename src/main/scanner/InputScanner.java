package main.scanner;

import ball.Balls;
import exceptions.InvalidOverDetailsException;
import exceptions.InvalidOverThresholdException;
import main.scoreBoard.ScoreBoard;
import parser.InputParser;
import parser.validate.OverDetailsValidator;
import parser.validate.OverThresholdValidator;
import parser.validate.Validators;
import player.Players;
import show.Displayer;
import teams.BattingTeam;
import teams.BowlingTeam;
import tracker.RunsTracker;
import tracker.WicketsTracker;

import java.util.ArrayList;
import java.util.Scanner;

public class InputScanner {

    private static void display(String oversDetail, double overBuffer) {
        Validators validators = new Validators();
        validators.add(new OverDetailsValidator(oversDetail));
        validators.add(new OverThresholdValidator(oversDetail, overBuffer));
        try {
            InputParser inputParser = InputParser.create(oversDetail, overBuffer, validators);
            process(inputParser);
        } catch (InvalidOverDetailsException exception) {
            printErrorMessage(exception.getMessage());
        } catch (InvalidOverThresholdException exception) {
            printErrorMessage(exception.getMessage());
        }
    }

    private static void printErrorMessage(String message) {
        System.out.println("\nError: ");
        System.out.println(message);
    }

    private static void process(InputParser inputParser) {
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
        System.out.println(displayer.display());
    }

    private static Players dummyBatsmans() {
        ArrayList<String> batsmansList = new ArrayList<>();
        batsmansList.add("Bat1");
        batsmansList.add("Bat2");
        batsmansList.add("Bat3");
        batsmansList.add("Bat4");
        batsmansList.add("Bat5");
        batsmansList.add("Bat6");
        batsmansList.add("Bat7");
        batsmansList.add("Bat8");
        batsmansList.add("Bat9");
        batsmansList.add("Bat10");
        batsmansList.add("Bat11");
        return Players.create(batsmansList);

    }

    private static Players dummyBowlers() {
        ArrayList<String> bowlersList = new ArrayList<>();
        bowlersList.add("Bow1");
        bowlersList.add("Bow2");
        bowlersList.add("Bow3");
        bowlersList.add("Bow4");
        bowlersList.add("Bow5");
        bowlersList.add("Bow6");
        bowlersList.add("Bow7");
        bowlersList.add("Bow8");
        bowlersList.add("Bow9");
        bowlersList.add("Bow10");
        bowlersList.add("Bow11");
        return Players.create(bowlersList);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Give overs input: ");

        String oversDetail = scanner.nextLine();

        System.out.print("How much overs scoreboard you want to see: ");

        double overBuffer = scanner.nextDouble();

        display(oversDetail, overBuffer);
    }
}

