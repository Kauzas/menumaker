package be.kauzas.menumaker.options;

import be.kauzas.menumaker.AbstractMenu;
import org.bukkit.entity.Player;

/**
 * {@link AbstractMenu} option that add restrition
 * to the menu.
 */
public interface Restricted {

    /**
     * Method that define if the player has the permission.
     *
     * @param player Player to check permission.
     * @return true if the use has permission, otherwise false.
     */
    boolean hasPermission(Player player);

    /**
     * Method that is executed when a player try to
     * access the menu without the permission.
     *
     * @param player Player that tryed to access the menu.
     */
    void onPermissionDenied(Player player);

}
