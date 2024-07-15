package battleship.model;

import java.util.UUID;

public abstract class Event implements Comparable<Event> {
    private final UUID id;
    private final long timestamp;

    public Event() {
        this.id = UUID.randomUUID();
        this.timestamp = System.currentTimeMillis();
    }

    public Event(UUID id, long timestamp) {
        this.id = id;
        this.timestamp = timestamp;
    }

    @Override
    public int compareTo(Event o) {
        if (this.timestamp > o.timestamp) {
            return 1;
        } else if (this.timestamp < o.timestamp) {
            return -1;
        } else {
            return this.id.compareTo(o.id);
        }
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
        return id.hashCode();
    }

    public abstract boolean isShipPlacementEvent(Player player);

    public abstract boolean isShotEvent(Player player);

}
