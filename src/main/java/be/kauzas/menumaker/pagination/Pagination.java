package be.kauzas.menumaker.pagination;

/**
 * Interface for a pagination policy.
 * This interface define the previous and the next items
 * and the slot where we want to place them in the {@link PaginatedMenu}.
 */
public interface Pagination {

    /**
     * Method that define the previous page item.
     *
     * @param paginatedMenu {@link PaginatedMenu} where the item will be placed.
     * @return Previous page item.
     */
    PaginationItem getPreviousItem(PaginatedMenu paginatedMenu);

    /**
     * Method that define the next page item.
     *
     * @param paginatedMenu {@link PaginatedMenu} where the item will be placed.
     * @return Next page item.
     */
    PaginationItem getNextItem(PaginatedMenu paginatedMenu);

}
