package colonies.boycat97.src;

import net.minecraft.client.Minecraft;
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;
import colonies.anglewyrm.src.ClientProxy;
import colonies.anglewyrm.src.TileEntityTownHall;
import colonies.vector67.src.TileEntityColoniesChest;
import colonies.vector67.src.TileEntityColoniesChest;
import colonies.vector67.src.BlockColoniesChest;

public class BlockGuardHouse extends BlockColoniesChest {
	
	public TileEntityGuardHouse tileEntity;

	public BlockGuardHouse(int id) {
		super(id);
		setBlockName("block.guardhouse");
		setCreativeTab(CreativeTabs.tabDecorations);
	}
	
	@Override
	public String getTextureFile() {
		return ClientProxy.GUARDHOUSE_PNG;
	}
	
    @Override
    public TileEntity createNewTileEntity(World theWorld){
    	tileEntity = new TileEntityGuardHouse();
        return tileEntity;
     }
    
    @Override
    public boolean addBlockToTown(TileEntityColoniesChest _teGuardHouse){
    	if(TileEntityTownHall.playerTown != null){
    		TileEntityTownHall.playerTown.employersList.offer(_teGuardHouse);
    		Minecraft.getMinecraft().thePlayer.addChatMessage("New jobs available in " + TileEntityTownHall.playerTown.townName);
    		return true;
    	}
    	return false;
    }
	
}