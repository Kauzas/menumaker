package be.kauzas.menumaker.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Represent a custom bukkit event.
 */
public abstract class AbstractEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    /**
     * Get event handler list.
     *
     * @return Event handler list.
     */
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    /**
     * Get event handler list.
     *
     * @return Event handler list.
     */
    public static HandlerList getHandlerList() {
        return handlers;
    }

}
