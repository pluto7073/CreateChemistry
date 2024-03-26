package ml.pluto7073.createchem.mixin;

import ml.pluto7073.createchem.client.CreateChemistryClient;
import ml.pluto7073.createchem.item.CCItems;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;

import net.minecraft.world.item.ItemStack;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
@Environment(EnvType.CLIENT)
public abstract class ItemMixin {

	@Shadow
	public abstract String getDescriptionId(ItemStack stack);

	@Inject(at = @At("RETURN"), method = "getName", cancellable = true)
	public void createchem$modifyDisplayNameForCompounds(ItemStack stack, CallbackInfoReturnable<Component> cir) {
		if (CCItems.MULTIPLE_NAMES_LIST.contains((Item) (Object) this)) {
			cir.setReturnValue(switch (CreateChemistryClient.INSTANCE.config.getDisplayNamePreference()) {
                case COMMON -> Component.translatable(this.getDescriptionId(stack));
                case FULLNAME -> Component.translatable("fullname." + this.getDescriptionId(stack));
                case FORMULA -> Component.translatable("formula." + this.getDescriptionId(stack));
            });
		}
	}

}
