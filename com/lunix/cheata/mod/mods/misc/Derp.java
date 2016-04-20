/*
 * Copyright © 2015 - 2017 Lunix and contributors 
 * All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.lunix.cheata.mod.mods.misc;

import java.util.Random;

import net.minecraft.client.settings.KeyBinding;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketEntityAction.Action;
import net.minecraft.network.play.client.CPacketPlayer.C05PacketPlayerLook;

import com.lunix.cheata.Client;
import com.lunix.cheata.mod.Mod;
import com.lunix.cheata.utils.Category;

public class Derp extends Mod{


	public Derp(String name, Category category) {
		super(name, category);
	}

	public static boolean mode = false;
	
	@Override
	public void onUpdate() {
		mode = Client.getValueManager().getValueByName("DerpLegit").getValueBoolean();
		Random rand = new Random();
		int yaw = rand.nextInt((1000 - 0) + 1) + 0;
		int pitch = rand.nextInt((1000 - 0) + 1) + 0;
		if(mode){
			mc.thePlayer.rotationYaw = yaw;
			mc.thePlayer.rotationPitch = pitch;
			KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), false);
			KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
		}else{
			mc.thePlayer.sendQueue.addToSendQueue(new C05PacketPlayerLook(yaw, pitch, mc.thePlayer.onGround));
			mc.thePlayer.sendQueue.addToSendQueue(new CPacketEntityAction(mc.thePlayer, Action.STOP_SNEAKING));
			mc.thePlayer.sendQueue.addToSendQueue(new CPacketEntityAction(mc.thePlayer, Action.START_SNEAKING));
		}
	}
}
