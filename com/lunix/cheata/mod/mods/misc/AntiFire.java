/*
 * Copyright © 2015 - 2017 Lunix and contributors 
 * All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.lunix.cheata.mod.mods.misc;

import net.minecraft.network.play.client.CPacketPlayer;

import com.lunix.cheata.mod.Mod;
import com.lunix.cheata.utils.Category;
import com.lunix.cheata.utils.packet.PacketUtils;

public class AntiFire extends Mod{

	public AntiFire(String name, Category category) {
		super(name, category);
	}

	@Override
	public void onUpdate() {
		if(!mc.thePlayer.capabilities.isCreativeMode){
			if(mc.thePlayer.isBurning() && mc.thePlayer.onGround){
				PacketUtils.sendPacket(new CPacketPlayer());
			}
		}
	}
}
