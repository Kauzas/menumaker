package be.kauzas.menumaker.pagination;

import org.bukkit.inventory.ItemStack;

/**
 * Object that represent a pagination item for
 * a {@link PaginatedMenu}. That object can be instanciated in
 * a custom {@link Pagination} class to tell the menu
 * how to handle page change.
 */
public class PaginationItem {

    private final int slot;
    private final ItemStack itemStack;

    /**
     * Constructor of {@link PaginationItem} asking fot a slot
     * and an itemstack.
     *
     * @param slot      Slot where the item will be placed.
     * @param itemStack Itemstack that will represent the page item.
     */
    public PaginationItem(int slot, ItemStack itemStack) {
        this.slot = slot;
        this.itemStack = itemStack;
    }

    /**
     * Get the slot where the item must be placed.
     *
     * @return Slot to place the item at.
     */
    public int getSlot() {
        return slot;
    }

    /**
     * Get the itemstack that represent the page item.
     *
     * @return Page itemstack.
     */
    public ItemStack getItemStack() {
        return itemStack;
    }

}
