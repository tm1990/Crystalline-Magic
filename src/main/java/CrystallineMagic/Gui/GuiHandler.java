package CrystallineMagic.Gui;

import CrystallineMagic.Container.ContainerMagicalCharger;
import CrystallineMagic.Container.ContainerMagicalDeconstructor;
import CrystallineMagic.Container.ContainerMagicalInfuser;
import CrystallineMagic.Container.ContainerSpellCreation;
import CrystallineMagic.Container.ContainerWriting;
import CrystallineMagic.TileEntities.TileEntityMagicalDecontructor;
import CrystallineMagic.TileEntities.TileEntityMagicalEnergyRecharger;
import CrystallineMagic.TileEntities.TileEntityMagicalInfuser;
import CrystallineMagic.TileEntities.TileEntitySpellCreationTable;
import CrystallineMagic.TileEntities.TileEntitySpellWritingTable;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler {


    @Override

    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

        TileEntity tile_entity = world.getTileEntity(x, y, z);



        if(tile_entity instanceof TileEntityMagicalInfuser)
            return new ContainerMagicalInfuser(player.inventory, (TileEntityMagicalInfuser) tile_entity);



        if(tile_entity instanceof TileEntityMagicalEnergyRecharger)
            return new ContainerMagicalCharger(player.inventory, (TileEntityMagicalEnergyRecharger) tile_entity);



        if(tile_entity instanceof TileEntityMagicalDecontructor)
            return new ContainerMagicalDeconstructor(player.inventory, (TileEntityMagicalDecontructor) tile_entity);


        if(tile_entity instanceof TileEntitySpellCreationTable)
            return new ContainerSpellCreation(player.inventory, (TileEntitySpellCreationTable) tile_entity);


        if(tile_entity instanceof TileEntitySpellWritingTable)
            return new ContainerWriting(player.inventory, (TileEntitySpellWritingTable)tile_entity);



        return null;
    }



    @Override

    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

        TileEntity tile_entity = world.getTileEntity(x, y, z);



        if(tile_entity instanceof TileEntityMagicalInfuser)
            return new GuiMagicalInfuser(player.inventory, (TileEntityMagicalInfuser) tile_entity);



        if(tile_entity instanceof TileEntityMagicalEnergyRecharger)
            return new GuiMagicalCharger(player.inventory, (TileEntityMagicalEnergyRecharger) tile_entity);



        if(tile_entity instanceof TileEntityMagicalDecontructor)
            return new GuiMagicalDeconstructor(player.inventory, (TileEntityMagicalDecontructor) tile_entity);


        if(tile_entity instanceof TileEntitySpellCreationTable)
            return new GuiSpellCreationTable(player.inventory, (TileEntitySpellCreationTable) tile_entity);


        if(tile_entity instanceof TileEntitySpellWritingTable)
            return new GuiWritingTable(player.inventory, (TileEntitySpellWritingTable) tile_entity);


        if(ID == EnumGuis.Magic_Info.Id){
            return new GuiMagicInfo();
        }

        return null;

    }


}
