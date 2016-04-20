/*
 * Copyright © 2015 - 2017 Lunix and contributors 
 * All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.lunix.cheata.mod.mods.movement;

import net.minecraft.network.play.client.CPacketEntityAction;

import com.lunix.cheata.Client;
import com.lunix.cheata.mod.Mod;
import com.lunix.cheata.utils.Category;

public class BunnyHop extends Mod{

	public BunnyHop(String name, Category category) {
		super(name, category);
	}

	public static double height = 1;
	public static boolean jump = false;

	@Override
	public void onUpdate() {
		height = Client.getValueManager().getValueByName("BhopHeight").getValueDouble();
		jump = Client.getValueManager().getValueByName("BhopLegit").getValueBoolean();
		if(mc.thePlayer.onGround && mc.thePlayer.moveForward > 0 && !mc.thePlayer.isInWater() && !mc.thePlayer.isInLava()){
			if(jump){
				mc.thePlayer.jump();
			}else{
				mc.thePlayer.motionY = height;
			}
		}
	}
}
