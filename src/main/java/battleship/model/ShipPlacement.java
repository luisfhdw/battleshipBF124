package battleship.model;

import java.util.Optional;
import java.util.stream.Stream;

public class ShipPlacement extends Event {
    public final Direction direction;
    public final Player player;
    public final Coordinate start;
    public final ShipType type;

    public ShipPlacement(ShipType type, Coordinate start, Direction direction, Player player) {
        super();
        this.direction = direction;
        this.player = player;
        this.start = start;
        this.type = type;
    }

    public static Optional<Direction> toDirection(
            final ShipType type,
            final Coordinate start,
            final Coordinate end) {
        int distanceRow = start.row() - end.row();
        int distanceColumn = start.column() - end.column();

        // return empty if no distance or distance in both directions
        if (distanceRow == 0 && distanceColumn == 0 || distanceRow != 0 && distanceColumn != 0)
            return Optional.empty();

        if (distanceRow != 0) {
            // distance in the column direction
            // return empty if distance too big
            if (Math.abs(distanceColumn) >= type.length)
                return Optional.empty();

            // get specific direction
            if (distanceColumn < 0) {
                return Optional.of(Direction.EAST);
            } else
                return Optional.of(Direction.WEST);
        } else {
            // distance in the row direction
            // return empty if distance too big
            if (Math.abs(distanceRow) >= type.length)
                return Optional.empty();

            // get specific direction
            if (distanceRow < 0) {
                return Optional.of(Direction.SOUTH);
            } else
                return Optional.of(Direction.NORTH);
        }
    }

    @Override
    public boolean isShotEvent(Player player) {
        return false;
    }

    @Override
    public boolean isShipPlacementEvent(Player player) {
        return true;
    }

    public Stream<Coordinate> toCoordinates() {
        final Stream.Builder<Coordinate> result = Stream.builder();
        for (int i = 0; i < this.type.length; i++) {
            result.add(this.start.plus(i, this.direction));
        }
        return result.build();
    }

}
