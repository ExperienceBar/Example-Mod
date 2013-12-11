package mod.examplemod;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = ExampleMod.MOD_ID, name = ExampleMod.MOD_NAME, version = ExampleMod.MOD_VERSION)
public class ExampleMod {
	public static final String MOD_ID = "ExampleMod";
	public static final String MOD_NAME = "Example Mod";
	public static final String MOD_VERSION = "1.0.0";
	
	public static Item itemThing;
	public static Block blockThing;
	
	public static CreativeTabs tabEM = new CreativeTabs(CreativeTabs.getNextID(), MOD_ID) {
		@Override
		public ItemStack getIconItemStack() {
			return new ItemStack(Block.bedrock);
		}
	};
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		LogHandler.init();
		ConfigHandler.init(event.getSuggestedConfigurationFile());
		
		blockThing = new BlockThing(ConfigHandler.blockThingID);
		GameRegistry.registerBlock(blockThing, "blockThing");
		
		itemThing = new ItemThing(ConfigHandler.itemThingID);
		GameRegistry.registerItem(itemThing, "itemThing");
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		TickRegistry.registerTickHandler(new TickHandler(), Side.SERVER);
		
		GameRegistry.addShapelessRecipe(new ItemStack(Block.blockDiamond), new Object[]{blockThing, Item.diamond});
		
		GameRegistry.addShapedRecipe(new ItemStack(Item.diamond), new Object[]{"XXX", "XXX", "XXX", 'X', itemThing});
	}
}
