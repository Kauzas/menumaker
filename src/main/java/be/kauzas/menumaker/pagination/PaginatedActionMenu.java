package be.kauzas.menumaker.pagination;

import be.kauzas.menumaker.action.ActionItem;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

import java.util.List;

/**
 * Extension of {@link PaginatedMenu} compatible with {@link ActionItem}.
 * The array of {@link ActionItem} given in the constructor will be placed on each
 * pages.
 * <p>
 * You can still place page items by overriding {@link #setContent(Player, Inventory)}
 * method and calling super method. Same for {@link #onClick(InventoryClickEvent)} method.
 *
 * @param <T> Generic type of the paginated items.
 */
public abstract class PaginatedActionMenu<T> extends PaginatedMenu<T> {

    private final ActionItem[] items;

    /**
     * Constructor of {@link PaginatedActionMenu} asking for menu informations
     * and item list.
     *
     * @param uniqueId      Inventory unique identifier used to recognise the inventory in
     *                      the inventory click event.
     * @param title         Shown title of the inventory.
     * @param inventoryType Type type of the inventory from {@link InventoryType} enum.
     * @param pagination    Pagination policy with both pagination items.
     * @param items         List of items to paginate.
     * @param perPage       Amout of items per page.
     * @param actionItems   List of {@link ActionItem} to display in the inventory.
     */
    public PaginatedActionMenu(String uniqueId, String title, InventoryType inventoryType, Pagination pagination, List<T> items, int perPage, ActionItem[] actionItems) {
        super(uniqueId, title, inventoryType, pagination, items, perPage);
        this.items = actionItems;
    }

    /**
     * Constructor of {@link PaginatedActionMenu} asking for menu informations
     * and item list.
     *
     * @param uniqueId    Inventory unique identifier used to recognise the inventory in
     *                    the inventory click event.
     * @param title       Shown title of the inventory.
     * @param size        Size of the inventory.
     * @param pagination  Pagination policy with both pagination items.
     * @param items       List of items to paginate.
     * @param perPage     Amout of items per page.s
     * @param actionItems List of {@link ActionItem} to display in the inventory.
     */
    public PaginatedActionMenu(String uniqueId, String title, int size, Pagination pagination, List<T> items, int perPage, ActionItem[] actionItems) {
        super(uniqueId, title, size, pagination, items, perPage);
        this.items = actionItems;
    }

    /**
     * Fill inventory with the {@link ActionItem} list.
     *
     * @param player    Player for whom we open the inventory.
     * @param inventory The inventory that will be opened.
     */
    @Override
    public void setContent(Player player, Inventory inventory) {
        for (ActionItem item : items) {
            inventory.setItem(item.getSlot(), item.getItemStack());
        }
    }

    /**
     * Bind the inventory click event to action of the
     * {@link ActionItem} list.
     *
     * @param event Concerned {@link InventoryClickEvent}.
     */
    @Override
    public void onClick(InventoryClickEvent event) {
        for (ActionItem item : items) {
            if (event.getSlot() == item.getSlot())
                item.getAction().execute(this, event);
        }
    }

}
