package ml.pluto7073.createchem.tags;

import ml.pluto7073.createchem.CreateChemistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.material.Fluid;

public class CCTags {

	public static final TagKey<Fluid> HCL = createFluid("hcl");


	private static TagKey<Fluid> createFluid(String name) {
		return TagKey.create(Registries.FLUID, CreateChemistry.asId(name));
	}

}
