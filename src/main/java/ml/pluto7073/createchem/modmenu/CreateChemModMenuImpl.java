package ml.pluto7073.createchem.modmenu;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;

import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import ml.pluto7073.createchem.client.CreateChemistryClient;
import ml.pluto7073.createchem.config.ClientConfig;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class CreateChemModMenuImpl implements ModMenuApi {

	@Override
	public ConfigScreenFactory<?> getModConfigScreenFactory() {
		return parent -> {
			ConfigBuilder builder = ConfigBuilder.create()
					.setParentScreen(parent)
					.setTitle(Component.translatable("title.createchem.config"))
					.setSavingRunnable(CreateChemistryClient.INSTANCE.config::saveProperties)
					.setDefaultBackgroundTexture(new ResourceLocation("minecraft:textures/gui/options_background.png"));

			ConfigCategory category = builder.getOrCreateCategory(Component.translatable("title.createchem.config"));

			ConfigEntryBuilder entryBuilder = builder.entryBuilder();

			category.addEntry(entryBuilder.startEnumSelector(Component.translatable("option.createchem.display_name_preference"),
					ClientConfig.ItemNameType.class,
					CreateChemistryClient.INSTANCE.config.getDisplayNamePreference())
					.setDefaultValue(ClientConfig.ItemNameType.COMMON)
					.setTooltip(Component.translatable("option.createchem.display_name_preference.tooltip"))
					.setSaveConsumer(CreateChemistryClient.INSTANCE.config::setDisplayNamePreference)
					.build());

			return builder.build();
		};
	}
}
