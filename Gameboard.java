import java.util.ArrayList;
import java.util.List;

public class Gameboard {

    private Cell [][] board = new Cell[10][10];
    private String myColor;
    private String oppColor;
    private Index index;
    private int currenty;
    private int currentx;
    Direction dir;


    public Gameboard() {
        myColor = "C not set";
        oppColor = "C not set";
    }

    public String getMyColor() {
        return myColor;
    }

    public void setMyColor(String myColor) {
        this.myColor = myColor;
    }

    //return if the piece is ok to flip
    public boolean isValid(int x, int y) {
        if (board[y][x].getCellvalue() == 0) {
            return false;
        }
        return true;
    }

    public void candidateCheck(){

    }

    public void next(Direction d, int x, int y) {
        currentx = x;
        currenty = y;
        switch (d) {
            case NORTH:
                currenty--;
                break;
            case NORTH_EAST:
                currenty--;
                currentx++;
                break;
            case EAST:
                currentx++;
                break;
            case SOUTH_EAST:
                currenty++;
                currentx++;
                break;
                //return new Index(index.getColumnplus(),index.getRowplus());
            case SOUTH:
                currenty++;
                break;
                //return new Index(index.getColumnplus(),(index.getRow()));
            case SOUTH_WEST:
                currenty++;
                currentx--;
                break;
                //return new Index(index.getColumnplus(),index.getRowmin());
            case WEST:
                currentx--;
                break;
                //return new Index(index.getColumn(),index.getRowmin());
            case NORTH_WEST:
                currenty--;
                currentx--;
                break;
                //return new Index(index.getColumnmin(),index.getRowmin());
            default:
                break;
                //return new Index(0,0);
        }
    }

    public void flipPieces(int x, int y) {
        int player = board[y][x].getCellvalue();

        Direction [] direction = Direction.values();
        for (Direction d : direction) {
            next(d, x, y);

            while (isValid(currentx, currenty)) {
                //flip that piece of s
                if (board[currenty][currentx].getCellvalue() != player) {
                    if (player == -1) {
                        board[currenty][currentx].setOPPONENT(oppColor);
                    } else if (player == 1) {
                        board[currenty][currentx].setME(myColor);
                    }
                }
                //keep going on the same direction
                next(d, currentx, currenty);
            }


        }
    }

    public void playOpponentMove(int x, int y) {
        board[y][x].setOPPONENT(oppColor);
        printBoard();
        flipPieces(x, y);
        printBoard();
    }

    public void printBoard() {
        for (int i = 0; i < 10; i++ ) {
            System.out.println();
            System.out.print("C ");
            for (int j = 0; j < 10; j++ ) {
                System.out.print(board[i][j] + " ");
            }
        }
        System.out.println();
    }

    public void getLegalmoves() {
        //get my piece and check there
        for (int i = 0; i < 10; i++ ) {

        }
    }

    public void checkLegalmove(int x, int y) {

    }

    //initialize board
    public void initialize(String color) {

        //assign mycolors
        if (color.compareTo("I B") == 0) {
            myColor = "B";
            oppColor = "W";
        } else if (color.compareTo("I W") == 0) {
            myColor = "W";
            oppColor = "B";
        }

        int counter2 = 48;
        boolean vertical = false;
        for (int i = 0; i < 10; i++ ) {
            int counter = 97;
            if (i >= 1) {
                vertical = true;
                counter2++;
            }
            for (int j = 0; j < 10; j++ ) {
                board[i][j] = new Cell();

                //set borders
                if (i == 0 || j == 0 || i == 9 || j == 9) {
                    board[i][j].setBorder((char) counter);
                    counter++;
                    if ( (i == 0 && j == 0) || (i == 0 && j == 9) ||
                            (i == 9 && j == 0) || (i == 9 && j == 9) ) {
                        board[i][j].setBorder('#');
                        counter--;
                    }

                    if (vertical) {
                        board[i][j].setBorder((char) counter2);
                        if (j == 9 || (i == 9)) {
                            board[i][j].setBorder('#');
                        }
                    }

                }
            }

        }

        //initialize starting pieces
        if (myColor.compareTo("B") == 0) {
            board[4][4].setOPPONENT(oppColor);
            board[5][5].setOPPONENT(oppColor);
            board[4][5].setME(myColor);
            board[5][4].setME(myColor);
        } else if (myColor.compareTo("W") == 0) {
            board[4][4].setME(myColor);
            board[5][5].setME(myColor);
            board[4][5].setOPPONENT(oppColor);
            board[5][4].setOPPONENT(oppColor);
        }

        printBoard();
        System.out.print("R " + myColor);
        System.out.println();
    }



}
