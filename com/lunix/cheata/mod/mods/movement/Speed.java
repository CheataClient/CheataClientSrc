/*
 * Copyright © 2015 - 2017 Lunix and contributors 
 * All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.lunix.cheata.mod.mods.movement;

import net.minecraft.util.math.MathHelper;

import com.lunix.cheata.Client;
import com.lunix.cheata.mod.Mod;
import com.lunix.cheata.utils.Category;

public class Speed extends Mod{

	public Speed(String name, Category category) {
		super(name, category);
	}
	
	public static double speed = 2F;
	
	@Override
	public void onUpdate() {
		speed = Client.getValueManager().getValueByName("SpeedSpeed").getValueDouble();
		if(mc.gameSettings.keyBindForward.isKeyDown() && mc.thePlayer.onGround){
			float yaw = mc.thePlayer.rotationYaw * 0.017453292F;
			mc.thePlayer.motionX -= MathHelper.sin(yaw) * (speed/5);
			mc.thePlayer.motionZ += MathHelper.cos(yaw) * (speed/5);
		}
	}

}
