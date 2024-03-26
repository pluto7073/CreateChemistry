package ml.pluto7073.createchem.config;

import java.util.Properties;
import java.util.function.Supplier;

public abstract class ChemConfig {

	protected final Properties properties;

	protected ChemConfig(Supplier<Properties> propSupplier) {
		this.properties = propSupplier.get();
	}

	public boolean getBoolean(String key) {
		return getBoolean(key, false);
	}

	public boolean getBoolean(String key, boolean defaultVal) {
		if (!this.properties.containsKey(key)) {
			this.properties.put(key, String.valueOf(defaultVal));
		}
		return Boolean.parseBoolean(String.valueOf(this.properties.get(key)));
	}

	public void setBoolean(String key, boolean val) {
		this.properties.put(key, String.valueOf(val));
	}

	public int getInt(String key, int defaultVal) {
		if (!this.properties.containsKey(key)) {
			this.properties.put(key, String.valueOf(defaultVal));
		}
		return Integer.parseInt(properties.getProperty(key));
	}

	public int getInt(String key) {
		return getInt(key, 0);
	}

	public void setInt(String key, int i) {
		properties.put(key, String.valueOf(i));
	}

	public float getFloat(String key, float defaultVal) {
		if (!properties.containsKey(key)) {
			properties.put(key, String.valueOf(defaultVal));
		}
		return Float.parseFloat(properties.getProperty(key));
	}

	public float getFloat(String key) {
		return getFloat(key, 0.0F);
	}

	public void setFloat(String key, float f) {
		properties.put(key, String.valueOf(f));
	}

	public String getString(String key, String defaultVal) {
		if (!properties.containsKey(key)) {
			properties.put(key, defaultVal);
		}
		return properties.getProperty(key);
	}

	public String getString(String key) {
		return getString(key, "");
	}

	public void setString(String key, String s) {
		properties.put(key, s);
	}

	public <T extends Enum<T>> T getEnum(String key, Class<T> enumClass, T defaultVal) {
		if (!properties.containsKey(key)) {
			properties.put(key, defaultVal.name());
		}
		return Enum.valueOf(enumClass, properties.getProperty(key));
    }

	public <T extends Enum<T>> void setEnum(String key, T val) {
		properties.put(key, val.name());
	}

	public abstract void saveProperties();

}
