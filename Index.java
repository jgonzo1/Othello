public class Index {

    //hold a set of row and column
    private int row;
    private int column;


    public Index(int x, int y) {
        row = x;
        column = y;
    }

    public Index(Index index) {
        row = index.getRow();
        column = index.getColumn();
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    @Override
    public String toString() {
        return "row: " + row + " " + "column " + column;
    }
}
