package be.kauzas.menumaker.action;

import be.kauzas.menumaker.AbstractMenu;
import org.bukkit.event.inventory.InventoryClickEvent;

/**
 * Fonctional interface that can represent a click action
 * in an {@link AbstractMenu} and particularly in {@link ActionMenu}.
 */
@FunctionalInterface
public interface MenuAction {

    /**
     * Method that will be executed when the action
     * is called.
     *
     * @param abstractMenu {@link AbstractMenu} where the action is called.
     * @param event        Inventory click event of the action.
     */
    void execute(AbstractMenu abstractMenu, InventoryClickEvent event);

}
