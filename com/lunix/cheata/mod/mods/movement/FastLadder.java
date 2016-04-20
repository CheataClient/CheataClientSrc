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
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockLadder;
import net.minecraft.block.BlockVine;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;

import com.lunix.cheata.Client;
import com.lunix.cheata.mod.Mod;
import com.lunix.cheata.mod.mods.world.Timer;
import com.lunix.cheata.utils.Category;

public class FastLadder extends Mod{

	public FastLadder(String name, Category category) {
		super(name, category);
	}
	
	public static boolean ncp = false;
	
	@Override
	public void onUpdate() {
		ncp = Client.getValueManager().getValueByName("FastLadderNCP").getValueBoolean();
		if(!isMoving()){
			if(!Client.getModManager().getMod(Timer.class).isEnabled()){
				mc.timer.timerSpeed = 1.0F;
			}
		}
		if(mc.thePlayer.isCollidedHorizontally & mc.thePlayer.isOnLadder()){
			if(ncp){
				if(!Client.getModManager().getMod(Timer.class).isEnabled()){
					mc.timer.timerSpeed = 1.1F;
				}else{
					mc.timer.timerSpeed = (float) Client.getValueManager().getValueByName("TimerSpeed").getValueDouble();
				}
				mc.thePlayer.setPosition(mc.thePlayer.posX, mc.thePlayer.posY + 0.169, mc.thePlayer.posZ);
			}else{
				mc.thePlayer.setPosition(mc.thePlayer.posX, mc.thePlayer.posY + (getLadderHeight(mc.thePlayer, 0) > 9.7 ? 9.7 : getLadderHeight(mc.thePlayer, 0)) + .22, mc.thePlayer.posZ);
			}
		}
	}
	
	@Override
	public void onDisable() {
		if(!Client.getModManager().getMod(Timer.class).isEnabled()){
			mc.timer.timerSpeed = 1.0F;
		}
	}
	
	@SuppressWarnings("unused")
	private int getLadderHeight(Entity e, int offset) {
		int ladders = 0;
		for(int i = (int) e.posY; i < 256; i++){
			Block var1 = mc.theWorld.getBlockState(new BlockPos(e.posX, i + offset, e.posZ)).getBlock();
			if(var1 instanceof BlockAir){
				break;
			}else if(var1 instanceof BlockLadder || var1 instanceof BlockVine){
				ladders++;
			}
			return ladders;
		}
		return -1;
	}
	
	private boolean isMoving(){
		if(mc.gameSettings.keyBindBack.isKeyDown() || mc.gameSettings.keyBindForward.isKeyDown() || mc.gameSettings.keyBindLeft.isKeyDown() || mc.gameSettings.keyBindRight.isKeyDown()){
			return true;
		}
		return false;
	}

}
