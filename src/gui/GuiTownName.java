package colonies.lohikaarme.src;

import java.util.Iterator;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import colonies.src.ColoniesMain;
import colonies.anglewyrm.src.ContainerColoniesChest;
import colonies.anglewyrm.src.TileEntityTownHall;
import colonies.src.TileEntityColoniesChest;
import net.minecraft.src.Block;
import net.minecraft.src.ChatAllowedCharacters;
import net.minecraft.src.Container;
import net.minecraft.src.Gui;
import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiContainer;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.GuiTextField;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.NetClientHandler;
import net.minecraft.src.Packet130UpdateSign;
import net.minecraft.src.StatCollector;
import net.minecraft.src.TileEntityRenderer;
import net.minecraft.src.TileEntitySign;

public class GuiTownName extends GuiContainer {
    /**
     * This String is just a local copy of the characters allowed in text rendering of minecraft.
     */
    private static final String allowedCharacters = ChatAllowedCharacters.allowedCharacters;

    /** The title string that is displayed in the top-center of the screen. */
    protected String screenTitle = "Give name to your town:";

    /** Reference to the chest object. */
    private TileEntityTownHall chest;

    /** Counts the number of screen updates. */
    private int updateCounter;
    
    /** Name entry field */
    protected GuiTextField inputField;
    
    public GuiTownName(TileEntityColoniesChest par1TileEntityColonieChest,InventoryPlayer inventory)
    {
    	super(new ContainerColoniesChest(inventory, par1TileEntityColonieChest));
        this.chest = (TileEntityTownHall) par1TileEntityColonieChest;
        this.xSize *= -1;
        this.ySize *= -1;
    }

    /**
     * Adds the buttons (and other controls) to the screen in question.
     */
    public void initGui()
    {
    	super.initGui();
        this.controlList.clear();
        Keyboard.enableRepeatEvents(true);
        this.controlList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 65, "Done"));
        this.inputField = new GuiTextField(this.fontRenderer,2, this.height/4 + 50, this.width - 3, 12);
        this.inputField.setMaxStringLength(70);
        this.inputField.setFocused(true);
        this.inputField.setCanLoseFocus(false);
    }

    /**
     * Called when the screen is unloaded. Used to disable keyboard repeat events
     */
    public void onGuiClosed()
    {
        Keyboard.enableRepeatEvents(false);
//        NetClientHandler var1 = this.mc.getSendQueue(); //Maybe some day we need a Packet

//        if (var1 != null)
//        {
            chest.townName = inputField.getText();
            chest.closeChest();
//        }
    }

    /**
     * Called from the main game loop to update the screen.
     */
    public void updateScreen()
    {
        ++this.updateCounter;
        this.inputField.updateCursorCounter();
    }

    /**
     * Fired when a control is clicked. This is the equivalent of ActionListener.actionPerformed(ActionEvent e).
     */
    protected void actionPerformed(GuiButton par1GuiButton)
    {
        if (par1GuiButton.enabled)
        {
            if (par1GuiButton.id == 0)
            {
//            	if(!isNameUsed(inputField.getText())){
                  this.mc.displayGuiScreen((GuiScreen)null);
//            	}
//            	else{
//            	  screenTitle = "Name was alrady used";
//            	}
            }
        }
    }

    /**
     * Fired when a key is typed. This is the equivalent of KeyListener.keyTyped(KeyEvent e).
     */
    protected void keyTyped(char par1, int par2)
    {
      inputField.textboxKeyTyped(par1, par2);
    }

    /**
     * Draws the screen and all the components in it.
     */
    public void drawScreen(int par1, int par2, float par3)
    {
        drawRect(2, this.height - 14, this.width - 2, this.height - 2, Integer.MIN_VALUE);
        inputField.drawTextBox();
        
        super.drawScreen(par1, par2, par3);
    }
    
    /*
    private boolean isNameUsed(String name){
      if(TileEntityTownHall.towns!=null){
    	Iterator names = TileEntityTownHall.towns.keySet().iterator();
    	while(names.hasNext()){
    	  if(names.next() == name){
    		return true;
    	  }
    	}
      }
      return false;
    }
    */
    
	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2,int var3) {
	  fontRenderer.drawString(screenTitle,(width/4), (height/4) + 40, 0x999999);
	}
}
