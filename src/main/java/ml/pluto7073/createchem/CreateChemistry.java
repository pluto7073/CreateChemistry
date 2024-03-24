package ml.pluto7073.createchem;

import com.tterrag.registrate.Registrate;

import ml.pluto7073.createchem.item.CCItems;
import net.fabricmc.api.ModInitializer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CreateChemistry implements ModInitializer {

	public static final String ID = "createchem";
	public static final Logger LOGGER = LogManager.getLogger("Create: Chemistry");

	@Override
	public void onInitialize() {
		Registrate registrate = Registrate.create(ID);

		CCItems.init(registrate);

		LOGGER.info("Time for some science");
	}

}
