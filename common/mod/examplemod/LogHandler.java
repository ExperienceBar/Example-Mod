package mod.examplemod;

import java.util.logging.Level;
import java.util.logging.Logger;

import cpw.mods.fml.common.FMLLog;

public class LogHandler {
	private static Logger logger = Logger.getLogger(ExampleMod.MOD_ID);
	
	public static void init() {
		logger.setParent(FMLLog.getLogger());
	}
	
	public static void info(String message) {
		logger.log(Level.INFO, message);
	}
	
	public static void info(String message, Object... params) {
		info(String.format(message, params));
	}
}
