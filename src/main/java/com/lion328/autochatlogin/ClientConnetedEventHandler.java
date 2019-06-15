package com.lion328.autochatlogin;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.FMLNetworkEvent;
import net.minecraftforge.common.MinecraftForge;

public class ClientConnetedEventHandler
{

    public static final ClientConnetedEventHandler instance = new ClientConnetedEventHandler();

    @SubscribeEvent
    public void onClientConnectedToServer(FMLNetworkEvent.ClientConnectedToServerEvent event)
    {
        MinecraftForge.EVENT_BUS.register(EntityJoinEventHandler.instance);
    }
}
