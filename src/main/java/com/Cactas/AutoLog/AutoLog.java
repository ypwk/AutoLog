package com.Cactas.AutoLog;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.awt.*;

@Mod(modid = AutoLog.MODID, version = AutoLog.VERSION)
public class AutoLog
{
    public static final String MODID = "auto_log";
    public static final String VERSION = "1.0";

    public static com.Cactas.AutoLog.EventHandle myEventHandler;
    @EventHandler
    public void preinit(FMLPreInitializationEvent event){
        try{
            myEventHandler = new EventHandle();
        }
        catch(AWTException exception){
            System.out.println("AWTException at eventHandler init");
        }
        MinecraftForge.EVENT_BUS.register(myEventHandler);
        try{
            ToggleCommand ctc = new ToggleCommand();
            ctc.myEventHandler = myEventHandler;
            ClientCommandHandler.instance.registerCommand(ctc);
        }
        catch(Exception e){
            System.out.println("Something happened in preInit (ToggleCommand init).");
            e.printStackTrace();
        }
    }
    @EventHandler
    public void init(FMLInitializationEvent event)
    {

    }
}
