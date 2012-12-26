package colonies.anglewyrm.src;

import java.util.LinkedList;

import net.minecraft.src.EntityAIBase;
import net.minecraft.src.ItemStack;

// AI is given a set of stock levels to maintain in their personal inventory
// They will check their place of employment to gather shortages
public class EntityAIMaintainInventoryLevels extends EntityAIBase 
{
	EntityCitizen citizen;
	static int INVENTORY_CHECK_FREQUENCY = 100; // about 5 seconds between scans
	int updateCounter = INVENTORY_CHECK_FREQUENCY;
	ItemStack objectOfDesire;
	
	public EntityAIMaintainInventoryLevels(EntityCitizen _citizen){
		citizen = _citizen;		
	}
   
	@Override
	public boolean shouldExecute() 
	{
		// reasons to idle this task
		if(citizen == null) return false;		
		
		if(--updateCounter > 0)	return false;
		updateCounter = INVENTORY_CHECK_FREQUENCY;

		return wantsSomething();
	}
	
	// Returns true if citizen has an item in desiredInventory,
	// but the citizen's inventory has less of that item.
	private boolean wantsSomething(){
		// check main inventory
		// check armor
		return false;
	}
	
	private boolean canGetSomething(){
		return false;
	}
}

