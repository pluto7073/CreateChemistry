package ml.pluto7073.createchem.item;

import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.entry.ItemEntry;

import com.tterrag.registrate.util.entry.RegistryEntry;

import com.tterrag.registrate.util.nullness.NonNullFunction;

import earth.terrarium.adastra.common.registry.ModItems;
import ml.pluto7073.createchem.CreateChemistry;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CCItems {

	private static final Map<ResourceKey<CreativeModeTab>,List<ItemEntry<? extends Item>>> REG = new HashMap<>();

	// ItemGroup

	/**
	 * fuck you mojang mappings its an itemgroup not a fuckin "creative mode tab"
	 */
	public static final ResourceKey<CreativeModeTab> ELEMENTS_GROUP =
			ResourceKey.create(Registries.CREATIVE_MODE_TAB, new ResourceLocation(CreateChemistry.ID, "group"));

	// Elements

	// Hydrogen - Ad Astra
	public static ItemEntry<Item> HELIUM_BUCKET;

	public static void init(Registrate reg) {
		HELIUM_BUCKET = register(reg, "helium_bucket", Item::new, ELEMENTS_GROUP);

		Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, ELEMENTS_GROUP, FabricItemGroup.builder()
				.title(Component.translatable("itemGroup.chemistry.elements"))
				.icon(() -> ModItems.HYDROGEN_BUCKET.get().getDefaultInstance())
				.displayItems((p, out) -> {
					for (ItemEntry<? extends Item> item : REG.get(ELEMENTS_GROUP)) {
						out.accept(item.get());
					}
				})
				.build());
	}

	private static <T extends Item> ItemEntry<T> register(Registrate registrate, String id, NonNullFunction<Item.Properties, T> func, ResourceKey<CreativeModeTab> group) {
		ItemEntry<T> item = registrate.item(id, func).register();
		REG.get(group).add(item);
		return item;
	}

	static {
		REG.put(ELEMENTS_GROUP, new ArrayList<>());
	}

}
