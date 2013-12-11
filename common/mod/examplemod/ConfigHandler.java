package mod.examplemod;

import java.io.File;

import net.minecraftforge.common.Configuration;

public class ConfigHandler {
	public static int blockThingID;
	public static int itemThingID;
	
	public static void init(File file) {
		Configuration config = new Configuration(file);
		try {
			config.load();
			
			blockThingID = config.getBlock("blockThing", 2000).getInt();
			itemThingID = config.getItem("itemThing", 10000).getInt();
		} catch (Exception e) {
			LogHandler.info("HALP!");
		} finally {
			config.save();
		}
	}
}
