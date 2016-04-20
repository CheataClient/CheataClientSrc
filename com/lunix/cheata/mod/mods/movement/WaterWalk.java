/*
 * Copyright © 2015 - 2017 Lunix and contributors 
 * All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.lunix.cheata.mod.mods.movement;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;

import com.lunix.cheata.Client;
import com.lunix.cheata.mod.Mod;
import com.lunix.cheata.mod.ModManager;
import com.lunix.cheata.mod.mods.player.NoWater;
import com.lunix.cheata.utils.Category;

public class WaterWalk extends Mod{

	public WaterWalk(String name, Category category) {
		super(name, category);
	}
	
	public static boolean legit = false;
	
	@Override
	public void onEnable() {
		if(Client.getModManager().getMod(NoWater.class).isEnabled()){
			Client.getModManager().getMod(NoWater.class).setEnabled(false);
		}
	}
	
	@Override
	public void onUpdate() {
		legit = Client.getValueManager().getValueByName("WaterWalkLegit").getValueBoolean();
		if(legit){
			if(mc.thePlayer.isInWater()){
				mc.gameSettings.keyBindJump.pressed = true;
			}else{
				mc.gameSettings.keyBindJump.pressed = false;
			}
		}else{
			if((mc.theWorld.getBlockState(new BlockPos(mc.thePlayer.posX, mc.thePlayer.posY - 0.1, mc.thePlayer.posZ)).getBlock() == Blocks.water) || (mc.theWorld.getBlockState(new BlockPos(mc.thePlayer.posX, mc.thePlayer.posY - 0.1, mc.thePlayer.posZ)).getBlock() == Blocks.lava)){
				mc.thePlayer.motionY = 0;
				mc.thePlayer.onGround = true;
			}
			if(mc.thePlayer.isInWater() || mc.thePlayer.isInLava()){
				mc.thePlayer.motionY = 0.1;
				mc.thePlayer.onGround = true;
			}
		}
	}
	
	@Override
	public void onDisable() {
		mc.gameSettings.keyBindJump.pressed = false;
	}

}
