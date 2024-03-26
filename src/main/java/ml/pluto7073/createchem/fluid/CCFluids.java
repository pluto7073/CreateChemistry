package ml.pluto7073.createchem.fluid;

import com.tterrag.registrate.Registrate;

import com.tterrag.registrate.builders.FluidBuilder;

import com.tterrag.registrate.fabric.SimpleFlowableFluid;

import com.tterrag.registrate.util.entry.FluidEntry;

import com.tterrag.registrate.util.entry.ItemEntry;

import ml.pluto7073.createchem.CreateChemistry;
import ml.pluto7073.createchem.item.CCItems;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariantAttributeHandler;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;

import java.util.ArrayList;

@SuppressWarnings("UnstableApiUsage")
public class CCFluids {

	public static ResourceLocation STILL_ID = new ResourceLocation("block/water_still");
	public static ResourceLocation FLOW_ID = new ResourceLocation("block/water_flow");

	public static FluidEntry<SimpleFlowableFluid.Flowing> HCL;

	public static ItemEntry<BucketItem> HCL_BUCKET;

	private static FluidBuilder<SimpleFlowableFluid.Flowing, Registrate> basicFluid(String name, int color, Registrate registrate) {
		return registrate.fluid(name, STILL_ID, FLOW_ID)
				.fluidAttributes(() -> new CreateAttributeHandler(name, 500, 500))
				.fluidProperties(p -> p.tickRate(5).blastResistance(100f))
				.source(SimpleFlowableFluid.Source::new);
	}

	public static void init(Registrate registrate) {
		var f = basicFluid("hcl", 0x8ac0d1, registrate);
		HCL_BUCKET = f.bucket().properties(p -> p.stacksTo(1).craftRemainder(Items.BUCKET)).register();
		HCL = f.register();
		CCItems.MULTIPLE_NAMES_LIST.add(HCL_BUCKET.get());
	}

	private record CreateAttributeHandler(Component name, int viscosity, boolean lighterThanAir) implements FluidVariantAttributeHandler {
		private CreateAttributeHandler(String key, int viscosity, int density) {
			this(Component.translatable(key), viscosity, density <= 0);
		}

		@Override
		public Component getName(FluidVariant fluidVariant) {
			return name.copy();
		}

		@Override
		public int getViscosity(FluidVariant variant, Level world) {
			return viscosity;
		}

		@Override
		public boolean isLighterThanAir(FluidVariant variant) {
			return lighterThanAir;
		}
	}

}
