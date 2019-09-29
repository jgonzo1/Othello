import java.util.Scanner;

public class Othello {

    public Othello() {

    }

    public void opponentTurn() {

    }

    public static void main(String [] args) {
        Scanner scan = new Scanner(System.in);
        Gameboard board = new Gameboard();

        String input;
        String oppinput;
        int endgame;

        System.out.println("C Enter Mycolor");
        input = "I W";
        board.initialize(input);

        //if I am white,opponent starts first
        if (board.getMyColor().compareTo("W") == 0) {
            System.out.println("C opponent's turn");
            oppinput = "B c 4";
            oppinput = oppinput.replaceAll("\\s+","");
            board.playOpponentMove((int) oppinput.charAt(1) - 96, Character.getNumericValue(oppinput.charAt(2)));
        }

        while (!board.isEndgame()) {
           board.getLegalmoves();
           board.playMyMove(board.getPlayablex(), board.getPlayabley());
            System.out.println("C opponent's turn");
            oppinput = scan.nextLine();
            oppinput = oppinput.replaceAll("\\s+","");
            board.playOpponentMove((int) oppinput.charAt(1) - 96, Character.getNumericValue(oppinput.charAt(2)));
        }



    }

}
