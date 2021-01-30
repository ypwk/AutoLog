package com.Cactas.AutoLog;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import java.awt.*;

public class EventHandle {
    public static KeyBinding toggleLog;
    public boolean toggled = false;
    public EventHandle() throws AWTException{
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onEvent(ClientChatReceivedEvent event){
        if(toggled){
            if(event.message.getUnformattedText().contains("Sending to server")){
                Minecraft.getMinecraft().shutdown();
            }
        }
    }
}
