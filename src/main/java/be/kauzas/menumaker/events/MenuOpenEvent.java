package be.kauzas.menumaker.events;

import be.kauzas.menumaker.AbstractMenu;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;

/**
 * Event called when a player want to open a menu.
 * This event implements {@link Cancellable} and then can be cancelled.
 */
public class MenuOpenEvent extends AbstractEvent implements Cancellable {

    private boolean cancelled;
    private final AbstractMenu menu;
    private final Player player;

    /**
     * Constructor of {@link MenuOpenEvent} asking for
     * the concerned {@link AbstractMenu} and Player.
     *
     * @param menu   {@link AbstractMenu} player try to access.
     * @param player Player who try to access.
     */
    public MenuOpenEvent(AbstractMenu menu, Player player) {
        this.menu = menu;
        this.player = player;
    }

    /**
     * Get the {@link AbstractMenu}.
     *
     * @return Concerned {@link AbstractMenu}.
     */
    public AbstractMenu getMenu() {
        return menu;
    }

    /**
     * Get the player.
     *
     * @return Concerned player.
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Check if event is cancelled.
     *
     * @return true if the event is cancelled, otherwise false.
     */
    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    /**
     * Define if the event is cancelled.
     *
     * @param b true if the event has te be cancelled, otherwise false.
     */
    @Override
    public void setCancelled(boolean b) {
        this.cancelled = b;
    }

}
