package be.kauzas.menumaker.events;

import be.kauzas.menumaker.pagination.PaginatedMenu;
import org.bukkit.entity.Player;

/**
 * Event that is called when a player change page
 * on a {@link PaginatedMenu}.
 */
public class MenuPageChangedEvent extends AbstractEvent {

    private final Player player;
    private final PaginatedMenu menu;
    private final int previousPage;
    private final int currentPage;

    /**
     * Constructor of {@link MenuPageChangedEvent}.
     *
     * @param player       Player that clicked to change page.
     * @param menu         Menu displayed to the player.
     * @param previousPage Page where the player was before changing.
     * @param currentPage  Page where the player is after changing.
     */
    public MenuPageChangedEvent(Player player, PaginatedMenu menu, int previousPage, int currentPage) {
        this.player = player;
        this.menu = menu;
        this.previousPage = previousPage;
        this.currentPage = currentPage;
    }

    /**
     * Get the player.
     *
     * @return Player that changed of page.
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Get the displayed {@link PaginatedMenu}.
     *
     * @return Displayed menu.
     */
    public PaginatedMenu getMenu() {
        return menu;
    }

    /**
     * Get the page where the player was.
     *
     * @return Page where the player was before changing.
     */
    public int getPreviousPage() {
        return previousPage;
    }

    /**
     * Get the page where the player is.
     *
     * @return Page where the player is after changing.
     */
    public int getCurrentPage() {
        return currentPage;
    }

}
