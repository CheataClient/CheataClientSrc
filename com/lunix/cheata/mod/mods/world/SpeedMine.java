/*
 * Copyright © 2015 - 2017 Lunix and contributors 
 * All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.lunix.cheata.mod.mods.world;

import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

import com.lunix.cheata.mod.Mod;
import com.lunix.cheata.utils.Category;

public class SpeedMine extends Mod {

	public SpeedMine(String name, Category category) {
		super(name, category);
	}

	@Override
	public void onUpdate() {
		mc.thePlayer.addPotionEffect(new PotionEffect(Potion.getPotionFromResourceLocation("haste"), Integer.MAX_VALUE, 0));
		mc.playerController.blockHitDelay = Integer.MIN_VALUE;
	}
}
