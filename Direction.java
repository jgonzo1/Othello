public enum Direction {
    NORTH, NORTH_EAST, EAST, SOUTH_EAST, SOUTH, SOUTH_WEST, WEST, NORTH_WEST;

    /*public void next(Gameboard board, int x, int y) {
        switch (this) {
            case NORTH:
                board[y - 1][x];
                return new Index(index.getColumnmin(), index.getRow());
            case NORTH_EAST:
                return new Index(index.getColumnmin(), index.getRowplus());
            case EAST:
                return new Index(index.getColumn(),index.getRowplus());
            case SOUTH_EAST:
                return new Index(index.getColumnplus(),index.getRowplus());
            case SOUTH:
                return new Index(index.getColumnplus(),(index.getRow()));
            case SOUTH_WEST:
                return new Index(index.getColumnplus(),index.getRowmin());
            case WEST:
                return new Index(index.getColumn(),index.getRowmin());
            case NORTH_WEST:
                return new Index(index.getColumnmin(),index.getRowmin());
            default:
                return new Index(0,0);
        }
    }
    */
}
