package colonies.anglewyrm.src;

import java.util.HashMap;

import colonies.src.ColoniesMain;

import net.minecraft.src.Item;
import net.minecraft.src.World;

public class EntityPriestess extends EntityCitizen{
	public EntityPriestess(World world){ 
		super(world);
		this.isMale = false;
		this.texture = ColoniesMain.skinPriestess;
	    
	    // add this type of employment to the jobTypes if necessary
	    boolean alreadyInList = false;
	    for(EntityCitizen job : jobTypes){
	    	if(job instanceof EntityPriestess){
	    		alreadyInList = true;
	    		break;
	    	}
	    }
	    if(!alreadyInList) jobTypes.add(this);
	    
	    // TODO: Would like miners to go hostile with a pickaxe if attacked
	}
	
	public String getTexture() {
		if(this.isInWater()){
			return ColoniesMain.skinPriestessSwimming;
		}
		return ColoniesMain.skinPriestess;
    }
    protected String getHurtSound(){
        return "colonies.f-ohyeah";
    }

	protected String getLivingSound(){
		if(citizenGreetings){
			if(Utility.getLootCategory()==3){
				return "colonies.f-hello";
			}
		}
		return "";
    }
	
    // Mob Loot for default Citizen
    protected int getDropItemId() {
    	int lootID=1;
    	switch(Utility.getLootCategory()){
    	case 1: // Common
    			switch(Utility.getLootCategory(3)){
    			case 1: return Item.appleRed.shiftedIndex;
    			case 2: return Item.arrow.shiftedIndex;
    			default:return Item.bow.shiftedIndex;
    			}
    	case 2: // Uncommon
    		return Item.emerald.shiftedIndex;
    	case 3: // Rare
    		return Item.ingotIron.shiftedIndex;
    	default: // Legendary
    		return Item.ingotGold.shiftedIndex;
    	}
    }

	public void onLivingUpdate()
	{
		// custom miner behaviors
		super.onLivingUpdate();
		
		// sparkle test
		   worldObj.spawnParticle("reddust", 
				   posX + (rand.nextDouble() - 0.5D) * (double)width, 
				   (posY + rand.nextDouble() * (double)height) - 0.25D, 
				   posZ + (rand.nextDouble() - 0.5D) * (double)width, 
				   Utility.rng.nextFloat()+0.35, Utility.rng.nextFloat()+0.35, Utility.rng.nextFloat()+0.35);
    }
	
}
