package colonies.src.tileentity;

import net.minecraft.src.IInventory;
import colonies.src.ClientProxy;
import colonies.src.TileEntityColoniesChest;

public class TileEntityHouse extends TileEntityColoniesChest {

	public static TileEntityHouse house = new TileEntityHouse();
	
	public TileEntityHouse() {
		super();
	}

	@Override
    public String getInvName(){
        return "House";
    }
	
	@Override
	public String getTextureFile(){
		return ClientProxy.HOUSECHEST_PNG;
	}


}
