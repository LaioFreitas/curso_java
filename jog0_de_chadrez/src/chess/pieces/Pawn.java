package chess.pieces;

import boardGame.Board;
import boardGame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

    private ChessMatch chessMatch;

    public Pawn(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getCollumns()];

        Position p = new Position(0, 0);

        if (getColor() == Color.WHITE) {
            p.setValues(position.getRow() - 1, position.getCollumn());

            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                mat[p.getRow()][p.getCollumn()] = true;
            }
            p.setValues(position.getRow() - 2, position.getCollumn());
            Position p2 = new Position(position.getRow() - 1, position.getCollumn());
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
                mat[p.getRow()][p.getCollumn()] = true;
            }
            p.setValues(position.getRow() - 1, position.getCollumn() - 1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getCollumn()] = true;
            }
            p.setValues(position.getRow() - 1, position.getCollumn() + 1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getCollumn()] = true;
            }

            //enpassant
            if (position.getRow() == 3) {
                Position pEnPassant = new Position(position.getRow(), position.getCollumn() - 1);
                if (getBoard().positionExists(pEnPassant) && isThereOpponentPiece(pEnPassant) && getBoard().piece(pEnPassant) == chessMatch.getEnPassantVulnerable()) {
                    mat[pEnPassant.getRow() - 1][pEnPassant.getCollumn()] = true;
                }
                pEnPassant.setValues(position.getRow(), position.getCollumn() + 1);
                if (getBoard().positionExists(pEnPassant) && isThereOpponentPiece(pEnPassant) && getBoard().piece(pEnPassant) == chessMatch.getEnPassantVulnerable()) {
                    mat[pEnPassant.getRow() - 1][pEnPassant.getCollumn()] = true; 
                }
            }
        }
        else {
            p.setValues(position.getRow() + 1, position.getCollumn());

            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                mat[p.getRow()][p.getCollumn()] = true;
            }
            p.setValues(position.getRow() + 2, position.getCollumn());
            Position p2 = new Position(position.getRow() + 1, position.getCollumn());
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
                mat[p.getRow()][p.getCollumn()] = true;
            }
            p.setValues(position.getRow() + 1, position.getCollumn() - 1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getCollumn()] = true;
            }
            p.setValues(position.getRow() + 1, position.getCollumn() + 1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getCollumn()] = true;
            }
            // enpassant
            if (position.getRow() == 4) {
                Position pEnPassant = new Position(position.getRow(), position.getCollumn() - 1);
                if (getBoard().positionExists(pEnPassant) && isThereOpponentPiece(pEnPassant) && getBoard().piece(pEnPassant) == chessMatch.getEnPassantVulnerable()) {
                    mat[pEnPassant.getRow() + 1][pEnPassant.getCollumn()] = true;
                }
                pEnPassant.setValues(position.getRow(), position.getCollumn() + 1);
                if (getBoard().positionExists(pEnPassant) && isThereOpponentPiece(pEnPassant) && getBoard().piece(pEnPassant) == chessMatch.getEnPassantVulnerable()) {
                    mat[pEnPassant.getRow() + 1][pEnPassant.getCollumn()] = true; 
                }
            }
        }
        return mat;
    }

    @Override
    public String toString() {
        return "P";
    }
}
