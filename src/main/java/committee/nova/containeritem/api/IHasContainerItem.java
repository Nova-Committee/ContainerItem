package committee.nova.containeritem.api;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * An interface indicating the item implemented it has a container item
 */
public interface IHasContainerItem {
    /**
     * ItemStack sensitive version of {@link Item#hasRecipeRemainder()}
     *
     * @param currentStack The current item stack
     * @return True if this item has a 'container'
     */
    boolean hasContainerItem(ItemStack currentStack);

    /**
     * ItemStack sensitive version of {@link Item#getRecipeRemainder()}. Returns a full ItemStack
     * instance of the result.
     * <p>
     * If {@link IHasContainerItem#hasContainerItem(ItemStack)} is set to false, returns {@link ItemStack#EMPTY}
     *
     * @param currentStack The current ItemStack
     * @return The resulting ItemStack
     */
    ItemStack getContainerItem(ItemStack currentStack);
}
