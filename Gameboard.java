import java.util.ArrayList;
import java.util.List;

public class Gameboard {

    private int HEIGHT = 10;
    private int WIDTH = 10;
    private Cell [][] board = new Cell[HEIGHT][WIDTH];
    private String myColor;
    private String oppColor;
    private int currenty;
    private int currentx;
    private int playablex;
    private int playabley;
    private int player;
    private boolean endgame = false;
    Direction dir;


    public Gameboard() {
        myColor = "C not set";
        oppColor = "C not set";
    }

    public boolean isEndgame() {
        return endgame;
    }

    public void endGame() {
        endgame = true;
    }

    public String getMyColor() {
        return myColor;
    }

    public void setMyColor(String myColor) {
        this.myColor = myColor;
    }

    //return if the piece is the edge
    public boolean isValid(int x, int y) {
        if (board[y][x].getCellvalue() == 0) {
            return false;
        }
        return true;
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

    public void inspectPiece(List<Index> candidate, int x, int y) {

        if (board[y][x].getCellvalue() == player) {

        }

    }

    public void flipPieces(int x, int y) {
        player = board[y][x].getCellvalue();

        Direction [] direction = Direction.values();
        for (Direction d : direction) {
            next(d, x, y);

            if (isValid(currentx, currenty)) {
                next(d, currentx, currenty);

                List<Index> candidates = new ArrayList<>();
                inspectPiece(candidates, currentx, currenty);
            }

            /*
            while (isValid(currentx, currenty)) {
                candidates = new ArrayList<>();
                //store candidates
                if (board[currenty][currentx].getCellvalue() != player) {
                    candidates.add(new Index(currentx, currenty));
                }

                if (board[currenty][currentx].isBorder()) {
                    break;
                }

                //keep going on the same direction
                next(d, currentx, currenty);
            }
            */


        }
    }

    public void playOpponentMove(int x, int y) {
        board[y][x].setOPPONENT(oppColor);
        System.out.println("flipping");
        flipPieces(x, y);
        printBoard();
    }

    public void playMyMove(int x, int y) {
        board[y][x].setME(myColor);
        System.out.println("flipping");
        flipPieces(x, y);
        printBoard();
    }

    public void printBoard() {
        for (int i = 0; i < HEIGHT; i++ ) {
            System.out.println();
            System.out.print("C ");
            for (int j = 0; j < WIDTH; j++ ) {
                System.out.print(board[i][j] + " ");
            }
        }
        System.out.println();
    }

    public int getPlayablex() {
        return playablex;
    }

    public int getPlayabley() {
        return playabley;
    }

    public void getLegalmoves() {
        //get my piece and check there
        for (int i = 0; i < HEIGHT; i++ ) {
            for (int j= 0; j < WIDTH; j++ ) {
                if (board[i][j].isMe()) {
                    int turnablePieces = 0;
                    Direction [] direction = Direction.values();

                    for (Direction d : direction) {
                        next(d, j, i);

                        while (isValid(currentx, currenty)) {
                            //keep going on the same direction
                            next(d, currentx, currenty);
                            if (board[currenty][currentx].getCellvalue() == 5) {
                                break;
                            }
                            if (board[currenty][currentx].getCellvalue() == 0) {
                                System.out.println("" + currentx + " " + currenty + " is a valid move");
                                playablex = currentx;
                                playabley = currenty;
                            }
                        }


                    }
                }
            }
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
        for (int i = 0; i < HEIGHT; i++ ) {
            int counter = 97;
            if (i >= 1) {
                vertical = true;
                counter2++;
            }
            for (int j = 0; j < WIDTH; j++ ) {
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
