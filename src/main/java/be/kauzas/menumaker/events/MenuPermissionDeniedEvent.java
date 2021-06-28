package be.kauzas.menumaker.events;

import be.kauzas.menumaker.AbstractMenu;
import be.kauzas.menumaker.options.Restricted;
import org.bukkit.entity.Player;

/**
 * Event that is called when a player
 * try to access a {@link Restricted} {@link AbstractMenu} without
 * the permission.
 */
public class MenuPermissionDeniedEvent extends AbstractEvent {

    private final AbstractMenu menu;
    private final Player player;

    /**
     * Constructor of {@link MenuPermissionDeniedEvent} asking for
     * the concerned {@link AbstractMenu} and Player.
     *
     * @param menu   {@link AbstractMenu} player try to access.
     * @param player Player who try to access.
     */
    public MenuPermissionDeniedEvent(AbstractMenu menu, Player player) {
        this.menu = menu;
        this.player = player;
    }

    /**
     * Get the {@link AbstractMenu}.
     *
     * @return Concerned {@link AbstractMenu}.
     */
    public AbstractMenu getMenu() {
        return menu;
    }

    /**
     * Get the player.
     *
     * @return Concerned player.
     */
    public Player getPlayer() {
        return player;
    }

}
