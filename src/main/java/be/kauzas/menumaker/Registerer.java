package be.kauzas.menumaker;

import java.util.List;

/**
 * Generic interface for items
 * registering.
 *
 * @param <T> Generic type of the registerable item.
 */
public interface Registerer<T> {

    /**
     * Register an item.
     *
     * @param t Item to register.
     */
    void register(T t);

    /**
     * Get list of registered items.
     *
     * @return List of registered items.
     */
    List<T> getRegisteredItems();

}
