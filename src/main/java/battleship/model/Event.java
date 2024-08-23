package battleship.model;

import java.util.*;

public abstract class Event implements Comparable<Event> {

    public final UUID id;

    public final long timestamp;

    public Event() {
        this(UUID.randomUUID(), System.currentTimeMillis());
    }

    public Event(final UUID id, final long timestamp) {
        this.id = id;
        this.timestamp = timestamp;
    }

    @Override
    public int compareTo(final Event other) {
        final int result = Long.compare(this.timestamp, other.timestamp);
        if (result == 0) {
            return this.id.compareTo(other.id);
        }
        return result;
    }

   @Override
    public boolean equals(Object obj) {
        // check for equality
        if (obj == this)
            return true;

        // check if obj is not an instance of Event
        if (!(obj instanceof Event))
            return false;

        // we now know obj is an Event
        Event e = (Event) obj;

        // check for same id
        return this.id.equals(e.id);
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    public abstract boolean isShipPlacementEvent(Player player);

    public abstract boolean isShotEvent(Player player);

}
