package thelm.packagedastral;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import thelm.packagedastral.proxy.CommonProxy;

@Mod(
		modid = PackagedAstral.MOD_ID,
		name = PackagedAstral.NAME,
		version = PackagedAstral.VERSION,
		dependencies = PackagedAstral.DEPENDENCIES,
		guiFactory = PackagedAstral.GUI_FACTORY
		)
public class PackagedAstral {

	public static final String MOD_ID = "packagedastral";
	public static final String NAME = "PackagedAstral";
	public static final String VERSION = "1.12.2-1.0.0.0";
	public static final String DEPENDENCIES = "required-after:packagedauto@[1.12.2-1.0.5.17,1.12.2-2.0.0.0);required-after:astralsorcery;";
	public static final String GUI_FACTORY = "thelm.packagedastral.client.gui.GuiPackagedAstralConfigFactory";
	public static final CreativeTabs CREATIVE_TAB = new CreativeTabs("packagedastral") {
		@SideOnly(Side.CLIENT)
		@Override
		public ItemStack createIcon() {
			return new ItemStack(Items.AIR);
		}
	};
	@Instance
	public static PackagedAstral instance;
	@SidedProxy(clientSide = "thelm.packagedastral.proxy.ClientProxy", serverSide = "thelm.packagedastral.proxy.CommonProxy", modId = PackagedAstral.MOD_ID)
	public static CommonProxy proxy;
	public static ModMetadata metadata;

	@EventHandler
	public void firstMovement(FMLPreInitializationEvent event) {
		metadata = event.getModMetadata();
		metadata.autogenerated = false;
		metadata.version = VERSION;
		metadata.authorList.add("TheLMiffy1111");
		metadata.description = "A PackagedAuto addon that adds Astral Sorcery autocrafting.";

		proxy.register(event);
	}

	@EventHandler
	public void secondMovement(FMLInitializationEvent event) {
		proxy.register(event);
	}
}