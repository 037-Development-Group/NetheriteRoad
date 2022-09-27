package com.groupzts.netheriteroad.blocks;

import com.groupzts.netheriteroad.NetheriteRoad;
import com.groupzts.netheriteroad.init.ModBlocks;
import com.groupzts.netheriteroad.init.ModItems;
import com.groupzts.netheriteroad.utils.IHasModel;
import com.groupzts.netheriteroad.utils.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

import java.util.Objects;

public class BlockBase extends Block implements IHasModel {
    public BlockBase(String name, CreativeTabs tab, Material material) {
        super(material);
        setTranslationKey(Reference.MOD_ID + "." + name).setRegistryName(Reference.MOD_ID, name);
        setCreativeTab(tab);
        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(Objects.requireNonNull(this.getRegistryName())));
    }

    @Override
    public void registerModels() {
        NetheriteRoad.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }

}