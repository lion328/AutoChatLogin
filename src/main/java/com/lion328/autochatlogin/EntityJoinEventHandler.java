package com.lion328.autochatlogin;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

public class EntityJoinEventHandler
{

    public static final EntityJoinEventHandler instance = new EntityJoinEventHandler();

    @SubscribeEvent
    public void onEntity(EntityJoinWorldEvent event)
    {
        if (!(event.entity instanceof EntityPlayerSP))
        {
            return;
        }

        String password = System.getProperty("com.lion328.autochatlogin.password");

        if (password == null)
        {
            return;
        }

        Minecraft.getMinecraft().thePlayer.sendChatMessage("/login " + password);

        MinecraftForge.EVENT_BUS.unregister(this);
    }
}
