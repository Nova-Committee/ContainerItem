package committee.nova.containeritem.mixin;

import committee.nova.containeritem.api.IHasContainerItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Item.class)
public abstract class MixinItem implements IHasContainerItem {
    @Shadow
    public abstract boolean hasRecipeRemainder();

    @Shadow
    @Nullable
    public abstract Item getRecipeRemainder();

    @Override
    public boolean hasContainerItem(ItemStack currentStack) {
        return hasRecipeRemainder();
    }

    @Override
    public ItemStack getContainerItem(ItemStack currentStack) {
        if (!hasContainerItem(currentStack)) return ItemStack.EMPTY;
        return new ItemStack(getRecipeRemainder());
    }
}
