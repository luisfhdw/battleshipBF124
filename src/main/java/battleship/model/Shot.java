package battleship.model;

public class Shot extends Event {
    private final Coordinate coordinate;
    private final Player player;

    public Shot(Coordinate coordinate, Player player) {
        super();
        this.coordinate = coordinate;
        this.player = player;
    }

    @Override
    public boolean isShotEvent(Player player) {
        return true;
    }

    @Override
    public boolean isShipPlacementEvent(Player player) {
        return false;
    }
}
