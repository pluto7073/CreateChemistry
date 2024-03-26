package ml.pluto7073.createchem.client;

import ml.pluto7073.createchem.config.ClientConfig;
import net.fabricmc.api.ClientModInitializer;

public class CreateChemistryClient implements ClientModInitializer {

	public static CreateChemistryClient INSTANCE;

	public ClientConfig config;

	@Override
	public void onInitializeClient() {
		INSTANCE = this;
		config = new ClientConfig();
	}

}
