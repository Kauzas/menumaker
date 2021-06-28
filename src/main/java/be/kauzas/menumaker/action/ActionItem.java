package be.kauzas.menumaker.action;

import be.kauzas.menumaker.AbstractMenu;
import org.bukkit.inventory.ItemStack;

/**
 * Object that represent an item in an {@link AbstractMenu} or
 * particularly an {@link ActionMenu} and that have a linked {@link MenuAction}
 * to execute on click.
 */
public class ActionItem {

    private final int slot;
    private final MenuAction action;
    private final ItemStack itemStack;

    /**
     * Constructor of {@link ActionItem} asking for the item,
     * the slot and the {@link MenuAction} to execute on click.
     *
     * @param slot      Slot where the item must be placed.
     * @param action    Action to execute on click.
     * @param itemStack Itemstack to place in the menu.
     */
    public ActionItem(int slot, MenuAction action, ItemStack itemStack) {
        this.slot = slot;
        this.action = action;
        this.itemStack = itemStack;
    }

    /**
     * Get the slot where the item
     * must be placed.
     *
     * @return Slot to place the item at.
     */
    public int getSlot() {
        return slot;
    }

    /**
     * Get the action to execute on click
     * on the item.
     *
     * @return Action to execute on click.
     */
    public MenuAction getAction() {
        return action;
    }

    /**
     * Get the itemstack to place in the menu.
     *
     * @return Itemstack to place on the menu.
     */
    public ItemStack getItemStack() {
        return itemStack;
    }

}
