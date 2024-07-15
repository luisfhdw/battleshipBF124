package battleship.model;

public enum Player {
    FIRST, SECOND;

    public Player inverse() {
        return this == FIRST ? SECOND : FIRST;
    }
}
