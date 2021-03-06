package colonies.src.tileentity;

import net.minecraft.src.IInventory;
import colonies.src.ClientProxy;
import colonies.src.TileEntityColoniesChest;

public class TileEntityAlchemistShop extends TileEntityColoniesChest {

	public static TileEntityAlchemistShop alchemistShop = new TileEntityAlchemistShop();
	
	public TileEntityAlchemistShop() {
		super();
	}

	@Override
    public String getInvName(){
        return "container.alchemistShop";
    }
	
	@Override
	public String getTextureFile(){
		return ClientProxy.ALCHEMISTCHEST_PNG;
	}


}
