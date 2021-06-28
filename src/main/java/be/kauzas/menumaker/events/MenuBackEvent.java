package be.kauzas.menumaker.events;

import be.kauzas.menumaker.AbstractMenu;
import be.kauzas.menumaker.options.Backable;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.inventory.ItemStack;

/**
 * Event called when a player ge back to another
 * menu with {@link AbstractMenu} that implements {@link Backable}.
 * This event implements {@link Cancellable} and then can be cancelled.
 */
public class MenuBackEvent extends AbstractEvent implements Cancellable {

    private boolean cancelled;
    private final AbstractMenu origin;
    private final AbstractMenu destination;
    private final Player player;
    private final ItemStack clickedItem;
    private final int slot;

    /**
     * Constructor of {@link MenuBackEvent} asking for the origin {@link Backable} menu
     * and the player.
     *
     * @param menu   Origin {@link AbstractMenu} that implements {@link Backable}.
     * @param player Player who clicked.
     */
    public MenuBackEvent(Backable menu, Player player) {
        this.cancelled = false;

        this.origin = (AbstractMenu) menu;
        this.destination = menu.getBackDestination();
        this.player = player;
        this.clickedItem = menu.getBackItem();
        this.slot = menu.getBackSlot();
    }

    /**
     * Get origin menu.
     *
     * @return Origin menu.
     */
    public AbstractMenu getOrigin() {
        return origin;
    }

    /**
     * Get destination menu.
     *
     * @return Destination menu.
     */
    public AbstractMenu getDestination() {
        return destination;
    }

    /**
     * Get player who clicked.
     *
     * @return Player who clicked.
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Get {@link Backable#getBackItem()}.
     *
     * @return Clicked itemstack.
     */
    public ItemStack getClickedItem() {
        return clickedItem;
    }

    /**
     * Get {@link Backable#getBackSlot()}.
     *
     * @return Clicked slot.
     */
    public int getSlot() {
        return slot;
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
