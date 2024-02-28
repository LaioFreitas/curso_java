package boardGame;

public class Board {

    private Integer rows;
    private Integer collumns;
    private Piece[][] pieces;

    public Board(Integer rows, Integer collumns) {
        this.rows = rows;
        this.collumns = collumns;
        pieces = new Piece[rows][collumns];
    }

    public int getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public int getCollumns() {
        return collumns;
    }

    public void setCollumns(Integer collumns) {
        this.collumns = collumns;
    }

    public Piece piece(Integer row, Integer collumn) {
        return pieces[row][collumn];
    }

    public Piece piece(Position position) {
        return pieces[position.getRow()][position.getCollumn()];
    }

    public void placePiece(Piece piece, Position position) {
        pieces[position.getRow()][position.getCollumn()] = piece;
        piece.position = position;
    }

    public Piece removePiece(Position position) {
        if (!positionExists(position)) {
            throw new BoardException("Position not on board.");
        }
        if (piece(position) == null) {
            return null;
        }

        Piece aux = piece(position);
        aux.position = null;
        pieces[position.getRow()][position.getCollumn()] = null;

        return aux;
    }
    
    private boolean positionExists(int row, int column) {
        return (row > 0 && row < rows) && (column >= 0 &&  column < collumns);
    }

    public boolean positionExists(Position position) {
        return positionExists(position.getRow(), position.getCollumn());
    }

    public boolean thereIsAPiece(Position position) {
        return piece(position) != null;
    }
}