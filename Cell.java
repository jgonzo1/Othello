public class Cell {

    private int cellvalue;
    private char cellcolor;
    private char bordervalue;
    private char WHITE = 'W';
    private char BLACK = 'B';
    private int ME = 1;
    private int OPPONENT = -1;
    private int EMPTY = 0;
    private int row;
    private int column;
    private boolean border;

    public Cell() {
        cellvalue = 0;
        border = false;
        cellcolor = '0';
        row = 0;
        column = 0;
    }

    public int getCellvalue() {
        return cellvalue;
    }

    public void setCellvalue(int cellvalue) {
        this.cellvalue = cellvalue;
    }

    public void setWHITE() {
        cellcolor = WHITE;
    }

    public void setBLACK() {
        cellcolor = BLACK;
    }

    public void setColor(String color) {
        cellcolor = color.charAt(0);
    }

    public void setME(String color) {
        cellvalue = ME;
        setColor(color);
    }

    public void setOPPONENT(String color) {
        cellvalue = OPPONENT;
        setColor(color);
    }

    public void setEMPTY() {
        cellvalue = EMPTY;
    }

    public boolean isBorder() {
        return border;
    }

    public void setBorder(char input) {
        border = true;
        bordervalue = input;
    }

    @Override
    public String toString() {
        if (border) {
            return String.valueOf(bordervalue);
        }
        return String.valueOf(cellcolor);
    }
}
