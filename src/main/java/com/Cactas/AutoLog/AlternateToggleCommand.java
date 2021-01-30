package com.Cactas.AutoLog;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

public class AlternateToggleCommand extends CommandBase {
    public EventHandle myEventHandler;
    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender){
        return true;
    }
    @Override
    public String getCommandName(){
        return "al";
    }

    @Override
    public String getCommandUsage(ICommandSender sender){
        return "Use to toggle automatic logout";
    }
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        if(args.length > 0){
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN + "AUTOLOG: UWU DONT TOUCH ME LIKE THAT"));
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN + "AUTOLOG: Correct usage has no arguments"));
        }
        else{
            myEventHandler.toggled = !myEventHandler.toggled;
            String cmdText = "off";
            if(myEventHandler.toggled){
                cmdText = "on";
            }
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN + "AUTOLOG: Autolog Toggled to " + cmdText));
        }
    }
}
