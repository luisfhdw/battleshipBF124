package battleship.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Game {
    private List<Event> events = new ArrayList<Event>();

    g

    public Stream<Event> getEventsByPlayer(final Player player) {
        return Stream.empty();
    }

    public Set<Coordinate> getActualShotCoordinates(final Player hitPlayer) {
        return events.stream().filter(event -> event.isShotEvent(hitPlayer).map(event -> event.coordinate).collect(Collectors.toSet());
    }
}
