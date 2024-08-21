package battleship.rules;

import java.util.*;

import battleship.model.*;

public interface Rules {

    public static boolean isBetween(final int lowerBoundInclusive, final int number, final int upperBoundExclusive) {
        return false; //TODO
    }

    int getHorizontalLength();

    Set<Coordinate> getImpossibleCoordinatesAfterShot(
        final Player playerWhoShot,
        final Coordinate shot,
        final Game game
    );

    Optional<Turn> getNextTurn(final Game game);

    int getVerticalLength();

    Optional<Player> getWinner(final Game game);

    boolean placementConflict(final Coordinate first, final Coordinate second);

    default boolean shipPlacement(final Game game, final ShipType type, final Player player, final Event event) {
        if (event.isShipPlacementEvent(player)) {
            final ShipPlacement placement = (ShipPlacement)event;
            if (
                placement.type == type
                && this.validShipPlacement(placement, game.getShipCoordinates(placement.player))
            ) {
                game.addEvent(event);
                return true;
            }
        }
        return false;
    }

    default boolean shot(final Game game, final Player player, final Event event) {
        return false; // TODO
    }

    default boolean validCoordinate(final Coordinate coordinate) {
        return false; //TODO
    }

    default boolean validShipPlacement(final ShipPlacement placement, final Collection<Coordinate> shipCoordinates) {
        return false; //TODO
    }

}
