package chess.pieces;

import boardGame.Board;
import boardGame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

    public King(Board board, Color color) {
        super(board, color);
    }

    private boolean canMove(Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p != null && p.getColor() != getColor();
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

        return mat;
    }
}