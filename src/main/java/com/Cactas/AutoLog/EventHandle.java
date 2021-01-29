package com.Cactas.AutoLog;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;
import java.awt.*;

public class EventHandle {
    public static KeyBinding toggleLog;
    public static boolean toggled = false;
    public EventHandle() throws AWTException{
        registerKeyBindings();
    }

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) throws InterruptedException{
        if(toggleLog.isPressed()){
            toggled = !toggled;
            String cmdText = "off";
            if(toggled){
                cmdText = "on";
            }
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN + "Autolog Toggled to " + cmdText));
        }

    }

    public static void registerKeyBindings(){
        toggleLog = new KeyBinding("key.categories.hud", Keyboard.KEY_V, "AutoLog");
        ClientRegistry.registerKeyBinding(toggleLog);
    }
}
