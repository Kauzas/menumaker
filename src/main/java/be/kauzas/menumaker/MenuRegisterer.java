package be.kauzas.menumaker;

import be.kauzas.menumaker.exceptions.MenuAlreadyRegisteredException;
import be.kauzas.menumaker.listeners.MenuMakerListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that is used to register {@link AbstractMenu}
 * to allow them to be handled by the inventory click event of
 * the {@link MenuMakerListener}.
 */
public class MenuRegisterer implements Registerer<AbstractMenu> {

    private final List<AbstractMenu> menus;

    /**
     * Constructor of {@link MenuRegisterer}.
     */
    public MenuRegisterer() {
        this.menus = new ArrayList<>();
    }

    /**
     * Method that register an {@link AbstractMenu} to the internal
     * list of menus that will be used in the inventory click event.
     *
     * @param menu {@link AbstractMenu} to register.
     * @throws MenuAlreadyRegisteredException when a menu with the same
     *                                        unique id is already registered.
     */
    @Override
    public void register(AbstractMenu menu) {
        if (isRegistered(menu))
            throw new MenuAlreadyRegisteredException(menu);
        this.menus.add(menu);
    }

    /**
     * Get the list of registered menus.
     *
     * @return ArrayList of registered menus.
     */
    public List<AbstractMenu> getRegisteredItems() {
        return menus;
    }

    /**
     * Check if an {@link AbstractMenu} has already been registered.
     *
     * @param menu {@link AbstractMenu} to check if he is already registered.
     * @return true if the menu is already registered, otherwise false.
     */
    private boolean isRegistered(AbstractMenu menu) {
        return menus.stream().anyMatch(m -> m.getUniqueId().equalsIgnoreCase(menu.getUniqueId()));
    }

}
