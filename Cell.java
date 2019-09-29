public class Cell {

    private int cellvalue;
    private char cellcolor;
    private char bordervalue;
    private char WHITE = 'W';
    private char BLACK = 'B';
    private int ME = 1;
    private int OPPONENT = -1;
    private int EMPTY = 0;
    private boolean border;
    private boolean me;

    public Cell() {
        cellvalue = 0;
        border = false;
        cellcolor = '0';
        me = false;

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
        me = true;
        setColor(color);
    }

    public void setOPPONENT(String color) {
        cellvalue = OPPONENT;
        me = false;
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
        cellvalue = 5;
    }

    public boolean isMe() {
        return me;
    }

    @Override
    public String toString() {
        if (border) {
            return String.valueOf(bordervalue);
        }
        return String.valueOf(cellcolor);
    }
}
