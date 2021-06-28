package be.kauzas.menumaker;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

/**
 * Inventory holder that is used to recognise
 * the opened menu in the inventory click event.
 */
public class MenuHolder implements InventoryHolder {

    private final AbstractMenu menu;

    /**
     * Constructor of {@link MenuHolder} asking for an
     * {@link AbstractMenu} instance.
     *
     * @param menu {@link AbstractMenu} the holder id attached to.
     */
    public MenuHolder(AbstractMenu menu) {
        this.menu = menu;
    }

    /**
     * Get inventory of the holder.
     *
     * @return Inventory of the holder.
     */
    public Inventory getInventory() {
        return menu.getInventory();
    }

    /**
     * Get attached {@link AbstractMenu} identifier.
     *
     * @return Attached menu identifier.
     */
    public String getUniqueId() {
        return menu.getUniqueId();
    }

    /**
     * Get attached {@link AbstractMenu}.
     *
     * @return Attached menu.
     */
    public AbstractMenu getMenu() {
        return menu;
    }

}
