package com.groupzts.netheriteroad.utils.handlers;

import com.groupzts.netheriteroad.init.ModBlocks;
import com.groupzts.netheriteroad.init.ModItems;
import com.groupzts.netheriteroad.init.ModSounds;
import com.groupzts.netheriteroad.utils.IHasModel;
import com.groupzts.netheriteroad.utils.Reference;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class RegistryHandler {
    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event){
        event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
    }

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
        TileEntityHandler.registerTileEntities();
    }
    @SubscribeEvent
    public static void onSoundRegister(RegistryEvent.Register<SoundEvent> event){
        event.getRegistry().registerAll(ModSounds.NETHERITE_ARMOR_SOUND.setRegistryName(Reference.MOD_ID, "netherite_armor_sound"));
    }
    @SubscribeEvent
    public static void onModelRegister( ModelRegistryEvent event )
    {
        for ( Item item : ModItems.ITEMS )
        {
            if ( item instanceof IHasModel )
            {
                ( (IHasModel) item).registerModels();
            }
        }
        for(Block block: ModBlocks.BLOCKS) {
            if(block instanceof IHasModel) {
                ( (IHasModel) block).registerModels();
            }
        }
    }

}
