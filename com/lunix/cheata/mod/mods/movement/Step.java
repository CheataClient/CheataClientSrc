/*
 * Copyright © 2015 - 2017 Lunix and contributors 
 * All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.lunix.cheata.mod.mods.movement;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;

import com.lunix.cheata.Client;
import com.lunix.cheata.mod.Mod;
import com.lunix.cheata.utils.Category;

public class Step extends Mod{

	public Step(String name, Category category) {
		super(name, category);
	}

	public static double height = 1F;
	public static boolean legit = false;
	
	@Override
	public void onUpdate() {
		height = Client.getValueManager().getValueByName("StepHeight").getValueDouble();
		legit = Client.getValueManager().getValueByName("StepLegit").getValueBoolean();
		if(mc.thePlayer.isInWater() && mc.thePlayer.isCollidedHorizontally){
			mc.thePlayer.motionY = 0.4;
		}else if(mc.thePlayer.isCollidedHorizontally && mc.thePlayer.onGround){
			if(legit){
				mc.thePlayer.jump();
			}else{
				mc.thePlayer.stepHeight = (float) height;
			}
		}else{
			mc.thePlayer.stepHeight = 0.5F;
		}
	}

}
