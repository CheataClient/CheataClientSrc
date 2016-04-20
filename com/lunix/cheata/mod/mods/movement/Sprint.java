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

public class Sprint extends Mod {

	public Sprint(String name, Category category) {
		super(name, category);
	}
	
	public static boolean legit = true;

	@Override
	public void onUpdate() {
		legit = Client.getValueManager().getValueByName("SprintLegit").getValueBoolean();
		if(legit){
			if (canSprint()) {
				mc.thePlayer.setSprinting(true);
			}else{
				mc.thePlayer.setSprinting(false);
			}
		}else{
			mc.thePlayer.sendQueue.addToSendQueue(new CPacketEntityAction(mc.thePlayer, CPacketEntityAction.Action.START_SPRINTING));
		}
	}
	
	@Override
	public void onDisable() {
		if(mc.inGameHasFocus){
			mc.thePlayer.setSprinting(false);
			mc.thePlayer.sendQueue.addToSendQueue(new CPacketEntityAction(mc.thePlayer, CPacketEntityAction.Action.START_SPRINTING));
		}
	}

	public boolean canSprint() {
		if (!mc.thePlayer.isCollidedHorizontally
				&& mc.thePlayer.moveForward > 0 && !mc.thePlayer.isOnLadder()
				&& !mc.thePlayer.isDead && !mc.thePlayer.isRiding()) {
			return true;
		}
		return false;
	}

}
