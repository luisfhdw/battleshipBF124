package battleship.model;

public class ShotAction extends TurnAction {
    public ShotAction(final Player player) {
        super(player);
    }

    @Override
    public Boolean apply(final EventAndState t) {
        return t.rules().shot(t.game(), this.player, t.event());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ShotAction) {
            ShotAction sa = (ShotAction) obj;
            return sa.player == this.player;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return player.hashCode();
    }
}
