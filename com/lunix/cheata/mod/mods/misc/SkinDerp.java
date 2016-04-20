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

import net.minecraft.entity.player.EnumPlayerModelParts;

import com.lunix.cheata.mod.Mod;
import com.lunix.cheata.utils.Category;
import com.lunix.cheata.utils.Timer;

public class SkinDerp extends Mod{

	public SkinDerp(String name, Category category) {
		super(name, category);
	}
	
	Timer timer = new Timer();
	
	@Override
	public void onUpdate() {
		if(timer.check(1000)){
			mc.gameSettings.setModelPartEnabled(EnumPlayerModelParts.HAT, new Random().nextBoolean());
			mc.gameSettings.setModelPartEnabled(EnumPlayerModelParts.JACKET, new Random().nextBoolean());
			mc.gameSettings.setModelPartEnabled(EnumPlayerModelParts.LEFT_PANTS_LEG, new Random().nextBoolean());
			mc.gameSettings.setModelPartEnabled(EnumPlayerModelParts.LEFT_SLEEVE, new Random().nextBoolean());
			mc.gameSettings.setModelPartEnabled(EnumPlayerModelParts.RIGHT_PANTS_LEG, new Random().nextBoolean());
			mc.gameSettings.setModelPartEnabled(EnumPlayerModelParts.RIGHT_SLEEVE, new Random().nextBoolean());
			timer.reset();
		}
	}
}
