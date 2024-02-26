package boardGame;

public class Position {

    private Integer row;
    private Integer collumn;

    public Position() {}

    public Position(Integer row, Integer collumn) {
        this.row = row;
        this.collumn = collumn;
    }

    public int getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public int getCollumn() {
        return collumn;
    }

    public void setcollums(Integer collumn) {
        this.collumn = collumn;
    }

    @Override
    public String toString() {
        return String.format("%d, %d", row, collumn);
    }
}