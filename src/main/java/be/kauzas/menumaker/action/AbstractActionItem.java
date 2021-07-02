package be.kauzas.menumaker.action;

import org.bukkit.inventory.ItemStack;

/**
 * Abstract class that represent an action item to
 * be displayed in a menu.
 */
public abstract class AbstractActionItem {

    /**
     * Get the slot where the item
     * must be placed.
     *
     * @return Slot to place the item at.
     */
    public abstract int getSlot();

    /**
     * Get the action to execute on click
     * on the item.
     *
     * @return Action to execute on click.
     */
    public abstract MenuAction getAction();

    /**
     * Get the itemstack to place in the menu.
     *
     * @return Itemstack to place on the menu.
     */
    public abstract ItemStack getItemStack();

}
