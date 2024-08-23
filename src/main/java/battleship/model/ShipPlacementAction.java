package battleship.model;

public class ShipPlacementAction extends TurnAction {
    public final ShipType type;

    public ShipPlacementAction(final Player player, final ShipType type) {
        super(player);
        this.type = type;
    }

    @Override
    public Boolean apply(final EventAndState t) {
        return t.rules().shipPlacement(t.game(), this.type, this.player, t.event());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ShipPlacementAction) {
            ShipPlacementAction spa = (ShipPlacementAction) obj;
            return this.player.equals(spa.player) && this.type.equals(spa.type);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return player.hashCode() * 3 + type.hashCode() * 5;
    }
}
