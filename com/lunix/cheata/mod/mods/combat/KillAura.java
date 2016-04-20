/*
 * Copyright © 2015 - 2017 Lunix and contributors 
 * All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.lunix.cheata.mod.mods.combat;

import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.MathHelper;

import com.lunix.cheata.mod.Mod;
import com.lunix.cheata.utils.Category;

public class KillAura extends Mod{

	public KillAura(String name, Category category) {
		super(name, category);
	}
	
	public void onUpdate() {
		killaura();
	}

	int delay;

	private void killaura() {
		List list = mc.theWorld.playerEntities;
		delay++;

		for (int k = 0; k < list.size(); k++) {
			if (((EntityPlayer) list.get(k)).getName() == mc.thePlayer.getName()) {
				continue;
			}

			EntityPlayer entityplayer = (EntityPlayer) list.get(1);

			if (mc.thePlayer.getDistanceToEntity(entityplayer) > mc.thePlayer.getDistanceToEntity((Entity) list.get(k))) {
				entityplayer = (EntityPlayer) list.get(k);
			}

			float f = mc.thePlayer.getDistanceToEntity(entityplayer);

			if (f < 4F && mc.thePlayer.canEntityBeSeen(entityplayer) && delay > 8) {
				Aimbot.faceEntity(entityplayer);
				mc.playerController.attackEntity(mc.thePlayer, entityplayer);
				mc.thePlayer.swingArm(EnumHand.MAIN_HAND);
				delay = 0;
				continue;
			}
		}
	}
}
