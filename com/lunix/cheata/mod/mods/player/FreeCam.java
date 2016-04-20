/*
 * Copyright © 2015 - 2017 Lunix and contributors 
 * All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.lunix.cheata.mod.mods.player;

import net.minecraft.client.entity.EntityOtherPlayerMP;

import com.lunix.cheata.mod.Mod;
import com.lunix.cheata.mod.mods.movement.Flight;
import com.lunix.cheata.utils.Category;

public class FreeCam extends Mod{

	public FreeCam(String name, Category category) {
		super(name, category);
	}
	
	double oldX;
	double oldY;
	double oldZ;
	EntityOtherPlayerMP fakePlayer;
	
	@Override
	public void onEnable() {
		fakePlayer = new EntityOtherPlayerMP(mc.theWorld, mc.thePlayer.getGameProfile());
		if(mc.inGameHasFocus){
			oldX = mc.thePlayer.posX;
			oldY = mc.thePlayer.posY;
			oldZ = mc.thePlayer.posZ;
			fakePlayer.setEntityId(-1881);
			fakePlayer.clonePlayer(mc.thePlayer, true);
			fakePlayer.copyLocationAndAnglesFrom(mc.thePlayer);
			fakePlayer.rotationYawHead = mc.thePlayer.rotationYawHead;
			mc.theWorld.addEntityToWorld(fakePlayer.getEntityId(), fakePlayer);
		}
	}
	
	@Override
	public void onUpdate() {
		mc.thePlayer.motionX = 0;
		mc.thePlayer.motionY = 0;
		mc.thePlayer.motionZ = 0;
		mc.thePlayer.jumpMovementFactor = (float) Flight.flySpeed / 75;
		
		if(mc.gameSettings.keyBindJump.pressed){
			mc.thePlayer.motionY += Flight.flySpeed / 25;
		}
		if(mc.gameSettings.keyBindSneak.pressed){
			mc.thePlayer.motionY -= Flight.flySpeed / 25;
		}
	}
	
	@Override
	public void onDisable() {
		if(mc.inGameHasFocus){
			mc.thePlayer.setLocationAndAngles(oldX, oldY, oldZ, mc.thePlayer.rotationYaw, mc.thePlayer.rotationPitch);
			mc.theWorld.removeEntityFromWorld(fakePlayer.getEntityId());
		}
	}
}
