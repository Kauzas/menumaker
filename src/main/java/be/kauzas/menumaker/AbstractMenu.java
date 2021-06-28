package be.kauzas.menumaker;

import be.kauzas.menumaker.events.MenuOpenEvent;
import be.kauzas.menumaker.events.MenuPermissionDeniedEvent;
import be.kauzas.menumaker.options.Backable;
import be.kauzas.menumaker.options.Restricted;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

/**
 * Represent a inventory menu with
 * onClick and setContent abstract methods.
 */
public abstract class AbstractMenu {

    private final Inventory inventory;
    private final String uniqueId;
    private final int size;
    private final InventoryType inventoryType;
    private String title;

    /**
     * Constructor of {@link AbstractMenu} asking for an id, a title and the inventory type.
     *
     * @param uniqueId      Inventory unique identifier used to recognise the inventory in
     *                      the inventory click event.
     * @param title         Shown title of the inventory.
     * @param inventoryType Type type of the inventory from {@link InventoryType} enum.
     */
    public AbstractMenu(String uniqueId, String title, InventoryType inventoryType) {
        this.uniqueId = uniqueId;
        this.size = inventoryType.getDefaultSize();
        this.inventoryType = inventoryType;
        this.title = title;
        this.inventory = Bukkit.createInventory(new MenuHolder(this), inventoryType, title);
    }

    /**
     * Constructor of {@link AbstractMenu} asking for an id, a title and the slot amount.
     *
     * @param uniqueId Inventory unique identifier used to recognise the inventory in
     *                 the inventory click event.
     * @param title    Shown title of the inventory.
     * @param size     Slot amount of the inventory.
     */
    public AbstractMenu(String uniqueId, String title, int size) {
        if (size % 9 != 0)
            throw new IllegalArgumentException(String.format("Inventory size for '%s' must be divisible by 9.", this.getClass().getSimpleName()));
        this.uniqueId = uniqueId;
        this.size = size;
        this.inventoryType = InventoryType.CHEST;
        this.title = title;
        this.inventory = Bukkit.createInventory(new MenuHolder(this), size, title);
    }

    /**
     * Get menu unique identifier.
     *
     * @return Menu identifier.
     */
    public String getUniqueId() {
        return uniqueId;
    }

    /**
     * Get inventory size.
     *
     * @return Inventory size.
     */
    public int getSize() {
        return size;
    }

    /**
     * Get inventory type from {@link InventoryType} enum.
     *
     * @return Inventory type.
     */
    public InventoryType getInventoryType() {
        return inventoryType;
    }

    /**
     * Get inventory title.
     *
     * @return Inventory title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set inventory title.
     *
     * @param title New inventory title.
     */
    public void setTitle(String title) {
        if (title == null) title = "";
        this.title = title;
    }

    /**
     * Get the actual inventory.
     *
     * @return Inventory object.
     */
    public Inventory getInventory() {
        return inventory;
    }

    /**
     * Display the inventory to the player.
     *
     * @param player Player to show inventory.
     */
    public void display(Player player) {
        update(player);
        MenuOpenEvent event = new MenuOpenEvent(this, player);
        Bukkit.getPluginManager().callEvent(event);
        if (!event.isCancelled())
            player.openInventory(this.inventory);
    }

    /**
     * Update the inventory content without
     * re-opening it.
     * <p>
     * This method is calling the {@link #setContent(Player, Inventory)} method.
     *
     * @param player Player to update inventory.
     */
    public void update(Player player) {
        if (player == null) throw new IllegalArgumentException("Player cannot be null.");
        if (!handleRestrictions(player)) return;
        this.inventory.clear();
        setContent(player, this.inventory);
        if (this instanceof Backable) {
            Backable backable = (Backable) this;
            this.inventory.setItem(backable.getBackSlot(), backable.getBackItem());
        }
    }

    /**
     * Method that is executed when the inventory is opened for a player.
     *
     * @param player    Player for whom we open the inventory.
     * @param inventory The inventory that will be opened.
     */
    public abstract void setContent(Player player, Inventory inventory);

    /**
     * Code that will be executed on each inventory item click.
     *
     * @param event Concerned {@link InventoryClickEvent}.
     */
    public abstract void onClick(InventoryClickEvent event);

    /**
     * Check players restrictions for {@link Restricted} menus and
     * call {@link Restricted#onPermissionDenied(Player)} if player
     * does not pass the {@link Restricted#hasPermission(Player)} method.
     *
     * @param player Player that want to open menu.
     * @return true if player has permission, otherwise false.
     */
    private boolean handleRestrictions(Player player) {
        if (this instanceof Restricted) {
            Restricted restricted = (Restricted) this;
            if (!restricted.hasPermission(player)) {
                restricted.onPermissionDenied(player);
                Bukkit.getPluginManager().callEvent(new MenuPermissionDeniedEvent(this, player));
                return false;
            }
        }
        return true;
    }

}
