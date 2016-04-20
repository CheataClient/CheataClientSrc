/*
 * Copyright © 2015 - 2017 Lunix and contributors 
 * All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.lunix.cheata.utils.packet;


import net.minecraft.client.Minecraft;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;

public class PacketUtils {

	public static void sendPacket(Packet packetIn) {
		Minecraft.getMinecraft().thePlayer.sendQueue.addToSendQueue(packetIn);
	}

	public static void sendPacketDirect(Packet packetIn) {
		NetworkPacket.networkManager.sendPacket(packetIn);
	}

	public static NetworkManager getNetworkManager(){
		return NetworkPacket.networkManager;
	}
}
