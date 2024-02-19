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
}
