package battleship.model;

public class ShipPlacementAction extends TurnAction{

    public final ShipType type;

    public ShipPlacementAction(final Player player, final ShipType type){
        super(player);
        this.type = type;

    }

    @Override
    public Boolean apply(EventAndState t) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
