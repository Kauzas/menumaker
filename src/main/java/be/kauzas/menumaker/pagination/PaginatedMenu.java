package be.kauzas.menumaker.pagination;

import be.kauzas.menumaker.AbstractMenu;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

import java.util.List;

/**
 * Extension of {@link AbstractMenu} that add pagination
 * support.
 *
 * @param <T> Generic type of the paginated items.
 */
public abstract class PaginatedMenu<T> extends AbstractMenu {

    private final Pagination pagination;
    private final List<T> items;
    private final int perPage;
    private int currentPage;

    /**
     * Constructor of {@link PaginatedMenu} asking for menu informations
     * and item list.
     *
     * @param uniqueId      Inventory unique identifier used to recognise the inventory in
     *                      the inventory click event.
     * @param title         Shown title of the inventory.
     * @param inventoryType Type type of the inventory from {@link InventoryType} enum.
     * @param pagination    Pagination policy with both pagination items.
     * @param items         List of items to paginate.
     * @param perPage       Amout of items per page.
     */
    public PaginatedMenu(String uniqueId, String title, InventoryType inventoryType, Pagination pagination, List<T> items, int perPage) {
        super(uniqueId, title, inventoryType);
        this.pagination = pagination;
        this.items = items;
        this.perPage = perPage;
        this.currentPage = 0;
    }

    /**
     * Constructor of {@link PaginatedMenu} asking for menu informations
     * and item list.
     *
     * @param uniqueId   Inventory unique identifier used to recognise the inventory in
     *                   the inventory click event.
     * @param title      Shown title of the inventory.
     * @param size       Size of the inventory.
     * @param pagination Pagination policy with both pagination items.
     * @param items      List of items to paginate.
     * @param perPage    Amout of items per page.
     */
    public PaginatedMenu(String uniqueId, String title, int size, Pagination pagination, List<T> items, int perPage) {
        super(uniqueId, title, size);
        this.pagination = pagination;
        this.items = items;
        this.perPage = perPage;
        this.currentPage = 0;
    }

    /**
     * Display the menu to a player at a certain page.
     *
     * @param player Player to show the menu.
     * @param page   Page to show to the player.
     */
    public void display(Player player, int page) {
        setCurrentPage(page);
        display(player);
    }

    /**
     * Update the inventory content without
     * re-opening it.
     * <p>
     * This method is calling the {@link #setContent(Player, Inventory)} method.
     *
     * @param player Player to update inventory.
     */
    @Override
    public void update(Player player) {
        super.update(player);
        Inventory inventory = super.getInventory();
        PaginationItem previous = pagination.getPreviousItem(this);
        PaginationItem next = pagination.getNextItem(this);
        inventory.setItem(previous.getSlot(), previous.getItemStack());
        inventory.setItem(next.getSlot(), next.getItemStack());
    }

    /**
     * Define the current page.
     *
     * @param currentPage New current meun page.
     */
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    /**
     * Get current menu page. Page index start at 0 and end at
     * {@link PaginatedMenu#getPageAmount()} -1.
     *
     * @return Current menu page.
     */
    public int getCurrentPage() {
        return currentPage;
    }

    /**
     * Get list of items.
     *
     * @return List of items.
     */
    public List<T> getItems() {
        return items;
    }

    /**
     * Get menu page amount.
     *
     * @return Amount of page.
     */
    public int getPageAmount() {
        return Math.round(items.size() / perPage) + 1;
    }

    /**
     * Get list of items for the current page.
     *
     * @return List of current page items.
     */
    public List<T> getPageItems() {
        int to = (currentPage + 1) * perPage;
        return items.subList(currentPage * perPage, to >= items.size() ? items.size() : to);
    }

    /**
     * Get the menu pagination policy.
     *
     * @return Pagination of the menu.
     */
    public Pagination getPagination() {
        return pagination;
    }

}
