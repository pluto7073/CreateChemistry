package ml.pluto7073.createchem.item;

import com.simibubi.create.AllItems;

import earth.terrarium.adastra.common.registry.ModItems;
import ml.pluto7073.createchem.CreateChemistry;
import ml.pluto7073.createchem.fluid.CCFluids;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class CCItemGroup {

	public static final ResourceKey<CreativeModeTab> ELEMENTS_GROUP = register("elements", new ItemStack(Items.CRAFTING_TABLE));
	public static final ResourceKey<CreativeModeTab> COMPOUNDS_GROUP = register("compounds", new ItemStack(Items.CRAFTING_TABLE));
	public static final ResourceKey<CreativeModeTab> CC_MISC_GROUP = register("cc_misc", new ItemStack(Items.CRAFTING_TABLE));

	private static ResourceKey<CreativeModeTab> register(String id, ItemStack icon) {
		ResourceKey<CreativeModeTab> key = ResourceKey.create(Registries.CREATIVE_MODE_TAB, CreateChemistry.asId(id));
		Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, key, FabricItemGroup.builder().icon(() -> icon)
				.title(Component.translatable("itemGroup.createchem." + id)).build());
		return key;
	}

	public static void init() {
		ItemGroupEvents.modifyEntriesEvent(ELEMENTS_GROUP).register(stacks -> {
			stacks.accept(new ItemStack(ModItems.HYDROGEN_BUCKET.get(), 1));
			stacks.accept(new ItemStack(CCItems.HELIUM_BUCKET, 1));
			stacks.accept(new ItemStack(CCItems.LITHIUM_INGOT, 1));
			stacks.accept(new ItemStack(CCItems.BERYLLIUM_INGOT, 1));
			stacks.accept(new ItemStack(CCItems.BORON, 1));
			stacks.accept(new ItemStack(CCItems.CARBON, 1));
			stacks.accept(new ItemStack(CCItems.LIQUID_NITROGEN_BUCKET, 1));
			stacks.accept(new ItemStack(ModItems.OXYGEN_BUCKET.get(), 1));
			stacks.accept(new ItemStack(CCItems.FLUORINE_BUCKET, 1));
			stacks.accept(new ItemStack(CCItems.NEON_BUCKET, 1));
			stacks.accept(new ItemStack(CCItems.SODIUM_INGOT, 1));
			stacks.accept(new ItemStack(CCItems.MAGNESIUM_INGOT, 1));
			stacks.accept(new ItemStack(CCItems.ALUMINIUM_INGOT, 1));
			stacks.accept(new ItemStack(CCItems.SILICON_SHARD, 1));
			stacks.accept(new ItemStack(CCItems.WHITE_PHOSPHORUS, 1));
			stacks.accept(new ItemStack(CCItems.RED_PHOSPHORUS, 1));
			stacks.accept(new ItemStack(CCItems.SULFUR, 1));
			stacks.accept(new ItemStack(CCItems.CHLORINE_BUCKET, 1));
			stacks.accept(new ItemStack(CCItems.ARGON_BUCKET, 1));
			stacks.accept(new ItemStack(CCItems.POTASSIUM_INGOT, 1));
			stacks.accept(new ItemStack(CCItems.CALCIUM_INGOT, 1));
			stacks.accept(new ItemStack(CCItems.SCANDIUM_INGOT, 1));
			stacks.accept(new ItemStack(CCItems.TITANIUM_INGOT, 1));
			stacks.accept(new ItemStack(CCItems.VANADIUM_INGOT, 1));
			stacks.accept(new ItemStack(CCItems.CHROMIUM_INGOT, 1));
			stacks.accept(new ItemStack(CCItems.MANGANESE_INGOT, 1));
			stacks.accept(new ItemStack(Items.IRON_INGOT, 1));
			stacks.accept(new ItemStack(CCItems.COBALT_INGOT, 1));
			stacks.accept(new ItemStack(CCItems.NICKEL_INGOT, 1));
			stacks.accept(new ItemStack(Items.COPPER_INGOT, 1));
			stacks.accept(new ItemStack(AllItems.ZINC_INGOT.get(), 1));
		});
		ItemGroupEvents.modifyEntriesEvent(COMPOUNDS_GROUP).register(stacks -> {
			stacks.accept(new ItemStack(Items.WATER_BUCKET, 1));
			stacks.accept(new ItemStack(CCItems.CAFFEINE, 1));
			stacks.accept(new ItemStack(CCItems.SODIUM_HYDROXIDE, 1));
			stacks.accept(new ItemStack(CCFluids.HCL_BUCKET, 1));
			stacks.accept(new ItemStack(CCItems.SODIUM_CHLORIDE, 1));
		});
		ItemGroupEvents.modifyEntriesEvent(CC_MISC_GROUP).register(stacks -> {

		});
	}



}
