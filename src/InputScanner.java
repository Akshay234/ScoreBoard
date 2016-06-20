import java.util.Scanner;

public class InputScanner {

    private static void display(String oversDetail, double overBuffer) throws Exception {
        InputParser inputParser = new InputParser(oversDetail);
        if (inputParser.isValidCharacters()) {
            ScoreBoard scoreBoard = new ScoreBoard(inputParser.getOvers());
            Displayer displayer = scoreBoard.showUpTo(overBuffer);
            System.out.println(displayer);
        } else {
            throw new Exception("Given [ " + oversDetail + " ] are Invalid");
        }

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