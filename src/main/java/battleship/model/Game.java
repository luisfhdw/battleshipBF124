package battleship.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Game {
    private List<Event> events = new ArrayList<Event>();

    public void addEvent(final Event event) {
        events.add(event);
    }

    public Set<Coordinate> getActualShotCoordinates(final Player hitPlayer) {
        return events.stream()
                .filter(event -> event.isShotEvent(hitPlayer.inverse()))
                .map(event -> ((Shot) event).coordinate)
                .collect(Collectors.toSet());
    }

    public Stream<Event> getEvents() {
        return events.stream();
    }

    public Stream<Event> getEventsByPlayer(final Player player) {
        return events.stream().filter(event -> event.isShotEvent(player) || event.isShipPlacementEvent(player));
    }

    public Set<Coordinate> getShipCoordinates(final Player player) {
        return this.events.stream()
                .filter(event -> event.isShipPlacementEvent(player))
                .flatMap(event -> ((ShipPlacement) event).toCoordinates())
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
}
