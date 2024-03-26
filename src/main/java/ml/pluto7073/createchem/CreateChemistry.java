package ml.pluto7073.createchem;

import com.tterrag.registrate.Registrate;

import ml.pluto7073.createchem.block.CCBlocks;
import ml.pluto7073.createchem.fluid.CCFluids;
import ml.pluto7073.createchem.item.CCItemGroup;
import ml.pluto7073.createchem.item.CCItems;
import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.ResourceLocation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CreateChemistry implements ModInitializer {

	public static final String ID = "createchem";
	public static final Logger LOGGER = LogManager.getLogger("Create: Chemistry");

	@Override
	public void onInitialize() {
		Registrate registrate = Registrate.create(ID);

		CCFluids.init(registrate);
		CCBlocks.init();
		CCItems.init(registrate);
		CCItemGroup.init();

		registrate.register();

		LOGGER.info("Time for some science");
	}

	public static ResourceLocation asId(String name) {
		return new ResourceLocation(ID, name);
	}

}
