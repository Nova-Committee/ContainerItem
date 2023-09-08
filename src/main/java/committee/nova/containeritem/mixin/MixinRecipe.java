package committee.nova.containeritem.mixin;

import committee.nova.containeritem.api.IHasContainerItem;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Recipe;
import net.minecraft.util.collection.DefaultedList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Recipe.class)
public abstract class MixinRecipe<T extends Inventory> {
    @Inject(method = "getRemainder", at = @At("HEAD"), cancellable = true)
    private void inject$getRemainder(T inventory, CallbackInfoReturnable<DefaultedList<ItemStack>> cir) {
        final DefaultedList<ItemStack> list = DefaultedList.ofSize(inventory.size(), ItemStack.EMPTY);
        for (int i = 0; i < list.size(); i++) {
            final ItemStack stack = inventory.getStack(i);
            final IHasContainerItem item = (IHasContainerItem) stack.getItem();
            if (item.hasContainerItem(stack)) list.set(i, item.getContainerItem(stack));
        }
        cir.setReturnValue(list);
    }
}
