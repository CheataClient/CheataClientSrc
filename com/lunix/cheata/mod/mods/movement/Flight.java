/*
 * Copyright © 2015 - 2017 Lunix and contributors 
 * All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.lunix.cheata.mod.mods.movement;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.network.play.client.CPacketPlayer;

import com.lunix.cheata.Client;
import com.lunix.cheata.mod.Mod;
import com.lunix.cheata.utils.Category;

public class Flight extends Mod{

	public Flight(String name, int bind, Category category) {
		super(name, bind, category);
	}
	
	public static double flySpeed = (20.0F / 25);

	boolean wasFlying;
	boolean canFly;
	
	@Override
	public void onUpdate() {
		flySpeed = Client.getValueManager().getValueByName("FlightSpeed").getValueDouble();
		mc.thePlayer.sendQueue.addToSendQueue(new CPacketPlayer(true));
		mc.thePlayer.motionY = 0;
		mc.thePlayer.isAirBorne = false;
		if(mc.gameSettings.keyBindJump.isKeyDown()){
			mc.thePlayer.motionY += (flySpeed / 25);
		}
		if(mc.gameSettings.keyBindSneak.isKeyDown()){
			mc.thePlayer.motionY -= (flySpeed / 25);
		}
		mc.thePlayer.capabilities.setFlySpeed((float) (flySpeed/75));
		mc.thePlayer.jumpMovementFactor = ((float) (flySpeed/75));
	}
	
	@Override
	public void onEnable(){
		if(mc.inGameHasFocus){
			if(mc.thePlayer.capabilities.isFlying){
				wasFlying = true;
			}else{
				wasFlying = false;
			}
			if(mc.thePlayer.capabilities.allowFlying){
				canFly = true;
			}else{
				canFly = false;
			}
			mc.thePlayer.capabilities.setFlySpeed((float) (flySpeed/100));
		}
	}
	
	@Override
	public void onDisable() {
		if(mc.inGameHasFocus){
			if(wasFlying){
				if(!mc.thePlayer.isAirBorne){
					mc.thePlayer.motionY = 0.05;
				}
				mc.thePlayer.capabilities.isFlying = true;
			}else{
				mc.thePlayer.capabilities.isFlying = false;
			}
			if(canFly){
				mc.thePlayer.capabilities.allowFlying = true;
			}else{
				mc.thePlayer.capabilities.allowFlying = false;
			}
			mc.thePlayer.capabilities.setFlySpeed(0.05F);
		}
	}
}
