package be.kauzas.menumaker.options;

import be.kauzas.menumaker.AbstractMenu;
import org.bukkit.inventory.ItemStack;

/**
 * {@link AbstractMenu} option that allow players
 * to go back to an other menu.
 */
public interface Backable {

    /**
     * Method that define the back button
     * itemstack.
     *
     * @return Back button itemstack.
     */
    ItemStack getBackItem();

    /**
     * Method that define the back button
     * slot in the menu.
     *
     * @return Back button slot.
     */
    int getBackSlot();

    /**
     * Method that define the destination menu.
     *
     * @return Destination menu.
     */
    AbstractMenu getBackDestination();

}
