package com.Cactas.AutoLog;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import java.awt.*;

public class EventHandle {
    public static KeyBinding toggleLog;
    public boolean toggled = false;
    private FontRenderer renderer = Minecraft.getMinecraft().fontRendererObj;
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

    @SubscribeEvent
    public void renderGameOverlayEvent(RenderGameOverlayEvent.Post event){
        if(toggled && (event.type == RenderGameOverlayEvent.ElementType.EXPERIENCE || event.type == RenderGameOverlayEvent.ElementType.JUMPBAR)){
            renderWarning(false);
        }
    }

    public void renderWarning(boolean forcedRender){
        renderer = Minecraft.getMinecraft().fontRendererObj;
        String warning = "KICKING MODE ACTIVE!";
        int screenY = Minecraft.getMinecraft().displayHeight / 4 - renderer.FONT_HEIGHT / 2;
        int screenX = Minecraft.getMinecraft().displayWidth / 4 - renderer.getStringWidth(warning) / 2;
        System.out.println("X: " + screenX + ", Y: " + screenY);
        renderer.drawString(warning, screenX , screenY, 0x55FFFF, true);
    }
}
