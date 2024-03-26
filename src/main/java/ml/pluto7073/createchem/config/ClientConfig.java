package ml.pluto7073.createchem.config;

import ml.pluto7073.createchem.CreateChemistry;
import net.fabricmc.loader.api.FabricLoader;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.function.Supplier;

public class ClientConfig extends ChemConfig {

	private static final String CLIENT_CONFIG_FILE = "create_chem_client.properties";

	public ClientConfig() {
		super(() -> {
			Properties p = new Properties();
			if (!new File(FabricLoader.getInstance().getConfigDir().toFile(), CLIENT_CONFIG_FILE).exists()) {
				return p;
			}
            try {
                p.load(new FileReader(new File(FabricLoader.getInstance().getConfigDir().toFile(), CLIENT_CONFIG_FILE)));
				return p;
            } catch (IOException e) {
				CreateChemistry.LOGGER.error("Couldn't load CreateChem Config", e);
				return new Properties();
            }
        });
	}

	public ItemNameType getDisplayNamePreference() {
		return getEnum("display_name_preference", ItemNameType.class, ItemNameType.COMMON);
	}

	public void setDisplayNamePreference(ItemNameType preference) {
		setEnum("display_name_preference", preference);
	}

	@Override
	public void saveProperties() {
		if (!new File(FabricLoader.getInstance().getConfigDir().toFile(), CLIENT_CONFIG_FILE).exists()) {
            try {
                new File(FabricLoader.getInstance().getConfigDir().toFile(), CLIENT_CONFIG_FILE).createNewFile();
            } catch (IOException e) {
                CreateChemistry.LOGGER.error("Could not create config file for Create: Chemistry", e);
				return;
            }
        }
        try {
            properties.store(new FileWriter(new File(FabricLoader.getInstance().getConfigDir().toFile(), CLIENT_CONFIG_FILE)), "");
        } catch (IOException e) {
            CreateChemistry.LOGGER.error("Could not save config file for Create: Chemistry", e);
        }
    }

	public enum ItemNameType {
		COMMON, FULLNAME, FORMULA
	}

}
