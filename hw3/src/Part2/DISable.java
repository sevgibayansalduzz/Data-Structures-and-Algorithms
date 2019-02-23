
package Part2;

/**
 *This class stores information about item. If is_disable_item is true,that means item is disable,otherwise item is enable.
 */
public class DISable<E>{
    /**
     *This data field stores information about item`s disable statu.
     */
    private boolean is_disable_item;

    /**
     *This data field strore item that type is E.
     */
    private E item;

    /**
     *Constructor.
     *If only the item is entered as a parameter, the item is became enabled.
     */
    protected DISable(E item) {
        is_disable_item = false;
        this.item=item;
    }
    /**
     *Constructor .
     */
    protected DISable(E item,Boolean is_disable_item) {
        is_disable_item = is_disable_item;
        this.item=item;
    }
    /**
     *Getter for information about item`s disable status.
     *@return Returns boolean.
     */
    public boolean getIs_disable_item() {
        return is_disable_item;
    }

    /**
     * Setter for information about item`s disable status.
     * @param is_disable_item takes status as a parameter.
     */
    public void setIs_disable_item(boolean is_disable_item) {
        this.is_disable_item = is_disable_item;
    }

    /**
     * Getter for item.
     * @return Return type is generic.
     */
    public E getItem() {
        return item;
    }

    /**
     * Setter for item.
     * @param item takes item as a parameter.
     */
    public void setItem(E item) {
        this.item = item;
    }


}
