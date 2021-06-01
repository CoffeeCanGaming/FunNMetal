package ccg.coffee.FunMetal;




import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

//The value here should match an entry in the META-INF/mods.toml file
@Mod("fm")
@Mod.EventBusSubscriber(modid = MetalMain.MOD_ID,bus = Bus.MOD)
public class MetalMain
{
	
	
	
	
// Directly reference a log4j logger.
public static final Logger LOGGER = LogManager.getLogger();
public static final String MOD_ID = "fm";
public static MetalMain instance;


public MetalMain() {
	 
	 final IEventBus Event = FMLJavaModLoadingContext.get().getModEventBus();
	 
   // Register the setup method for modloading
   Event.addListener(this::setup);
   
   // Register the doClientStuff method for modloading
   Event.addListener(this::doClientStuff);
   
  

   // Register ourselves for server and other game events we are interested in
   MinecraftForge.EVENT_BUS.register(this);
   instance = this;
}

private void setup(final FMLCommonSetupEvent event){
   // some preinit code
	 
}

private void doClientStuff(final FMLClientSetupEvent event) {
   // do something that can only be done on the client
}
@SubscribeEvent
public void onServerStarting(FMLServerStartingEvent event) {
   // do something when the server starts
}
@SubscribeEvent
public static void loadCompleteEvent(FMLLoadCompleteEvent event) {
	 //FMOreGen.generateOre();
}

public static class FMItemGroup extends ItemGroup{
	 
	 public static final FMItemGroup instance = new FMItemGroup(ItemGroup.TABS.length,"FMGroup");
	 
	 private FMItemGroup(int index ,String label) {
		 super(index,label);
	 }

	public ItemStack makeIcon() {
		return new ItemStack(Items.BAMBOO);
	}


}
}