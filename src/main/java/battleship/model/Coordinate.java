package battleship.model;

public record Coordinate(int column, int row) {
    public Coordinate plus(final int length, final Direction direction) {
        return switch (direction) {
            case NORTH -> plusRow(-length);
            case SOUTH -> plusRow(length);
            case EAST -> plusColumn(column);
            case WEST -> plusColumn(-column);
        };
    }

    public Coordinate plusColumn(final int column) {
        return new Coordinate(this.column + column, row);
    }

    public Coordinate plusRow(final int row) {
        return new Coordinate(column, this.row + row);
    }
}
