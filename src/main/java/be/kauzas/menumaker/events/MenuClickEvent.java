package be.kauzas.menumaker.events;

import be.kauzas.menumaker.AbstractMenu;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

/**
 * Event called when a player click in a menu.
 */
public class MenuClickEvent extends AbstractEvent {

    private final Player player;
    private final int slot;
    private final ItemStack currentItem;
    private final AbstractMenu menu;
    private final InventoryClickEvent baseEvent;

    /**
     * Constructor of {@link MenuClickEvent}.
     *
     * @param player      Player that clicked on the {@link AbstractMenu}.
     * @param slot        Slot where the player clicked.
     * @param currentItem Item the player clicked on.
     * @param menu        Menu where the player was.
     * @param baseEvent   Base {@link InventoryClickEvent}.
     */
    public MenuClickEvent(Player player, int slot, ItemStack currentItem, AbstractMenu menu, InventoryClickEvent baseEvent) {
        this.player = player;
        this.slot = slot;
        this.currentItem = currentItem;
        this.menu = menu;
        this.baseEvent = baseEvent;
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
     * Get slot where the player clicked.
     *
     * @return Clicked slot.
     */
    public int getSlot() {
        return slot;
    }

    /**
     * Get item player clicked on.
     *
     * @return Clicked item.
     */
    public ItemStack getCurrentItem() {
        return currentItem;
    }

    /**
     * Get clicked menu.
     *
     * @return Clicked menu.
     */
    public AbstractMenu getMenu() {
        return menu;
    }

    /**
     * Get base event.
     *
     * @return Base event.
     */
    public InventoryClickEvent getBaseEvent() {
        return baseEvent;
    }

}
