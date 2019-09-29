import java.util.Scanner;

public class Othello {



    public static void main(String [] args) {
        Scanner scan = new Scanner(System.in);
        Gameboard board = new Gameboard();

        String input;
        String oppinput;

        System.out.println("C Enter Mycolor");
        input = "I W";
        board.initialize(input);

        if (input.compareTo("I W") == 0) {
            System.out.println("C opponent's turn");
            oppinput = "B c 4";
            oppinput = oppinput.replaceAll("\\s+","");
            board.playOpponentMove((int) oppinput.charAt(1) - 96, Character.getNumericValue(oppinput.charAt(2)));

        }


    }

}
