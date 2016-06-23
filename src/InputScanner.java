import java.util.ArrayList;
import java.util.Scanner;

public class InputScanner {

    private static void display(String oversDetail, double overBuffer) throws Exception {
        InputParser inputParser = new InputParser(oversDetail);

        if (inputParser.isValid()) {
            ScoreBoard scoreBoard = ScoreBoard.create(inputParser.getOvers(),dummyBatsmans(), dummyBowlers());
            Displayer displayer = scoreBoard.showUpTo(overBuffer);
            System.out.println(displayer);
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
        return Players.createBatsmans(batsmansList);

    }

    private static Players dummyBowlers() {
        ArrayList<String> bowlersList = new ArrayList<>();
        bowlersList.add("A");
        bowlersList.add("B");
        bowlersList.add("C");
        bowlersList.add("D");
        return Players.createBowlers(bowlersList);
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

