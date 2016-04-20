/*
 * Copyright © 2015 - 2017 Lunix and contributors 
 * All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.lunix.cheata.mod.mods.movement;

import net.minecraft.client.settings.KeyBinding;
import net.minecraft.network.play.client.CPacketEntityAction;

import com.lunix.cheata.Client;
import com.lunix.cheata.mod.Mod;
import com.lunix.cheata.utils.Category;

public class Sneak extends Mod{

	public Sneak(String name, Category category) {
		super(name, category);
	}

	public static boolean legit;
	
	@Override
	public void onUpdate() {
		legit = Client.getValueManager().getValueByName("SneakLegit").getValueBoolean();
		if(legit){
			KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
		}else{
			mc.thePlayer.sendQueue.addToSendQueue(new CPacketEntityAction(mc.thePlayer, CPacketEntityAction.Action.START_SNEAKING));
		}
	}
	
	
	@Override
	public void onDisable() {
		KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), false);
		mc.thePlayer.sendQueue.addToSendQueue(new CPacketEntityAction(mc.thePlayer, CPacketEntityAction.Action.STOP_SNEAKING));
	}
}
