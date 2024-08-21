package battelship.model;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.List;
public class Game {
    private final List<Event> events = new ArrayList<>();
   public void addEvent(final Event event) {
        events.add(event);
    }

    public Set<Coordinate> getActualShotCoordianates(final Player hitPlayer) {
   return events.stream()
           //filtern der Events nach ShotEvents von dem nicht getroffenen Spieler
           .filter(event -> event.isShotEvent(hitPlayer.inverse()))
           //Mappen die Events von Shot events nach den Coordinaten von den Shots
           .map( event -> ((Shot) event).coordinate)
           //collecten die Coordinaten in den Stream
           .collect(Collectors.toSet());
    }


public Stream<Event> getEvents(){
        return events.stream();

}

public Stream<Event> getEventsByPlayer(final Player player){
        return events.stream().filter(event -> event.isShotEvent(player) || event.isShipPlacementEvent(player));
}

}
