package colonies.lohikaarme.src;

import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.StatCollector;
import colonies.anglewyrm.src.GuiColoniesChest;
import colonies.src.TileEntityColoniesChest;

public class GuiHouse extends GuiColoniesChest {

	public GuiHouse(TileEntityColoniesChest teChest,InventoryPlayer _playerInventory) {
		super(teChest, _playerInventory);
	}
	
	
	@Override
	public void initGui(){
	  super.initGui();
	}
}
