package mod.examplemod;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemThing extends Item {
	public ItemThing(int id) {
		super(id);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon(ExampleMod.MOD_ID + ":" + getUnlocalizedName().substring(5));
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int metadata) {
		return itemIcon;
	}
}
