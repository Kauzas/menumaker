package be.kauzas.menumaker.exceptions;

import be.kauzas.menumaker.AbstractMenu;

/**
 * Exception that is thrown when an {@link AbstractMenu}
 * with the same {@link AbstractMenu#getUniqueId()} is already registered.
 */
public class MenuAlreadyRegisteredException extends RuntimeException {

    /**
     * Constructor of {@link MenuAlreadyRegisteredException} exception asking
     * for the menu that caused the exception.
     *
     * @param menu {@link AbstractMenu} that caused the exception.
     */
    public MenuAlreadyRegisteredException(AbstractMenu menu) {
        super(String.format("Unable to register menu '%s'. A menu with the same unique id has already been registered.",
                menu.getClass().getSimpleName()));
    }

}
