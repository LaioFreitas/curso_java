package chess.pieces;

import boardGame.Board;
import boardGame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

    private ChessMatch chessMatch;

    public King(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    private boolean canMove(Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p != null && p.getColor() != getColor();
    }

    public ChessMatch getChessMatch() {
        return chessMatch;
    }
    
    private boolean testRookCastling(Position position) {
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;
    }
    
    @Override
    public String toString() {
        return "K";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getCollumns()];
        
        Position p = new Position(0, 0);

        //above
        p.setValues(position.getRow() - 1, position.getCollumn());
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getCollumn()] = true;
        }

        //below
        p.setValues(position.getRow() + 1, position.getCollumn());
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getCollumn()] = true;
        }

        //left
        p.setValues(position.getRow(), position.getCollumn() - 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getCollumn()] = true;
        }

        //rigth
        p.setValues(position.getRow(), position.getCollumn() + 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getCollumn()] = true;
        }

        //left-above        
        p.setValues(position.getRow() - 1, position.getCollumn() - 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getCollumn()] = true;
        }

        //rigth-above
        p.setValues(position.getRow() - 1, position.getCollumn() + 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getCollumn()] = true;
        }

        //left-below
        p.setValues(position.getRow() + 1, position.getCollumn() - 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getCollumn()] = true;
        }

        //rigth-below
        p.setValues(position.getRow() + 1, position.getCollumn() + 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getCollumn()] = true;
        }

        // specialmove castling
        
        if (getMoveCount() == 0 && !chessMatch.getCheck()) {
            // castling kingside rook

            Position posT1 = new Position(position.getRow(), position.getCollumn() + 3);
            if (testRookCastling(posT1)) {
                Position p1 = new Position(position.getRow(), position.getCollumn() + 2);
                Position p2 = new Position(position.getRow(), position.getCollumn() + 1);
                if (getBoard().piece(p1) == null && getBoard().piece(p2) == null) {
                    mat[position.getRow()][position.getCollumn() + 2] = true;
                }
            }
            // castling queenside rook
            posT1.setValues(position.getRow(), position.getCollumn() - 4);
            if (testRookCastling(posT1)) {
                Position p1 = new Position(position.getRow(), position.getCollumn() - 2);
                Position p2 = new Position(position.getRow(), position.getCollumn() - 1);
                Position p3 = new Position(position.getRow(), position.getCollumn() - 3);
                if (getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null) {
                    mat[position.getRow()][position.getCollumn() - 2] = true;
                }
            }
            
        }

        return mat;
    }
}