package ml.pluto7073.createchem.item;

import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.entry.ItemEntry;

import com.tterrag.registrate.util.entry.RegistryEntry;

import com.tterrag.registrate.util.nullness.NonNullFunction;

import earth.terrarium.adastra.common.registry.ModItems;
import ml.pluto7073.createchem.CreateChemistry;
import ml.pluto7073.createchem.fluid.CCFluids;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CCItems {

	public static final ArrayList<Item> MULTIPLE_NAMES_LIST = new ArrayList<>();

	// Elements

	// Hydrogen - Ad Astra
	public static Item HELIUM_BUCKET = new Item(new Item.Properties().stacksTo(1));
	public static Item LITHIUM_INGOT = new Item(new Item.Properties());
	public static Item BERYLLIUM_INGOT = new Item(new Item.Properties());
	public static Item BORON = new Item(new Item.Properties());
	public static Item CARBON = new Item(new Item.Properties());
	public static Item LIQUID_NITROGEN_BUCKET = new Item(new Item.Properties().stacksTo(1));
	// Oxygen - Ad Astra
	public static Item FLUORINE_BUCKET = new Item(new Item.Properties().stacksTo(1));
	public static Item NEON_BUCKET = new Item(new Item.Properties().stacksTo(1));
	public static Item SODIUM_INGOT = new Item(new Item.Properties());
	public static Item MAGNESIUM_INGOT = new Item(new Item.Properties());
	public static Item ALUMINIUM_INGOT = new Item(new Item.Properties());
	public static Item SILICON_SHARD = new Item(new Item.Properties());
	public static Item WHITE_PHOSPHORUS = new Item(new Item.Properties());
	public static Item RED_PHOSPHORUS = new Item(new Item.Properties());
	public static Item SULFUR = new Item(new Item.Properties());
	public static Item CHLORINE_BUCKET = new Item(new Item.Properties().stacksTo(1));
	public static Item ARGON_BUCKET = new Item(new Item.Properties().stacksTo(1));
	public static Item POTASSIUM_INGOT = new Item(new Item.Properties());
	public static Item CALCIUM_INGOT = new Item(new Item.Properties());
	public static Item SCANDIUM_INGOT = new Item(new Item.Properties());
	public static Item TITANIUM_INGOT = new Item(new Item.Properties());
	public static Item VANADIUM_INGOT = new Item(new Item.Properties());
	public static Item CHROMIUM_INGOT = new Item(new Item.Properties());
	public static Item MANGANESE_INGOT = new Item(new Item.Properties());
	// Iron - Minecraft
	public static Item COBALT_INGOT = new Item(new Item.Properties());
	public static Item NICKEL_INGOT = new Item(new Item.Properties());
	// Copper - Minecraft
	// Zinc - Create

	// Compounds

	public static Item CAFFEINE = new Item(new Item.Properties());
	public static Item SODIUM_HYDROXIDE = new Item(new Item.Properties());
	public static Item SODIUM_CHLORIDE = new Item(new Item.Properties());

	private static Registrate REGISTRATE;

	public static void init(Registrate registrate) {
		// Elements
		REGISTRATE = registrate;
		register("helium_bucket", HELIUM_BUCKET);
		register("lithium_ingot", LITHIUM_INGOT);
		register("beryllium_ingot", BERYLLIUM_INGOT);
		register("boron", BORON);
		register("carbon", CARBON);
		register("liquid_nitrogen_bucket", LIQUID_NITROGEN_BUCKET);
		register("fluorine_bucket", FLUORINE_BUCKET);
		register("neon_bucket", NEON_BUCKET);
		register("sodium_ingot", SODIUM_INGOT);
		register("magnesium_ingot", MAGNESIUM_INGOT);
		register("aluminium_ingot", ALUMINIUM_INGOT);
		register("silicon_shard", SILICON_SHARD);
		register("white_phosphorus", WHITE_PHOSPHORUS);
		register("red_phosphorus", RED_PHOSPHORUS);
		register("sulfur", SULFUR);
		register("chlorine_bucket", CHLORINE_BUCKET);
		register("argon_bucket", ARGON_BUCKET);
		register("potassium_ingot", POTASSIUM_INGOT);
		register("calcium_ingot", CALCIUM_INGOT);
		register("scandium_ingot", SCANDIUM_INGOT);
		register("titanium_ingot", TITANIUM_INGOT);
		register("vanadium_ingot", VANADIUM_INGOT);
		register("chromium_ingot", CHROMIUM_INGOT);
		register("manganese_ingot", MANGANESE_INGOT);
		register("cobalt_ingot", COBALT_INGOT);
		register("nickel_ingot", NICKEL_INGOT);

		// Compounds
		register("caffeine", CAFFEINE, true);
		register("sodium_chloride", SODIUM_CHLORIDE, true);
		register("sodium_hydroxide", SODIUM_HYDROXIDE, true);
		MULTIPLE_NAMES_LIST.add(Items.WATER_BUCKET);
	}

	private static void register(String id, Item item) {
		register(id, item, false);
	}

	private static void register(String id, Item item, boolean hasManyNames) {
		REGISTRATE.item(id, p -> item).register();
		if (hasManyNames) MULTIPLE_NAMES_LIST.add(item);
	}

	static {

	}

}
