package ml.pluto7073.createchem.block;

import ml.pluto7073.createchem.CreateChemistry;
import ml.pluto7073.createchem.fluid.CCFluids;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

public class CCBlocks {


	private static void register(String id, Block block) {
		Registry.register(BuiltInRegistries.BLOCK, CreateChemistry.asId(id), block);
	}

	public static void init() {
	}

}
