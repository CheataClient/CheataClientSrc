/*
 * Copyright © 2015 - 2017 Lunix and contributors 
 * All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.lunix.cheata.utils.packet;

import com.mojang.authlib.GameProfile;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.NetworkManager;

public class NetworkPacket extends NetHandlerPlayClient{

	public static NetworkManager networkManager;
	
	public NetworkPacket(Minecraft mcIn, GuiScreen p_i46300_2_,
			NetworkManager networkManagerIn, GameProfile profileIn) {
		super(mcIn, p_i46300_2_, networkManagerIn, profileIn);
		NetworkPacket.networkManager = netManager;
	}

	
}
