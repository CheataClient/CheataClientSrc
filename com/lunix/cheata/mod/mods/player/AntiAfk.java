/*
 * Copyright © 2015 - 2017 Lunix and contributors 
 * All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.lunix.cheata.mod.mods.player;

import com.lunix.cheata.mod.Mod;
import com.lunix.cheata.utils.Category;

import com.lunix.cheata.utils.*;

public class AntiAfk extends Mod{

	public AntiAfk(String name, Category category) {
		super(name, category);
	}
	
	int tickCount = 1;
	int afkCount = 1;
	Timer timer = new Timer();
	Timer timer2 = new Timer();
	
	@Override
	public void onUpdate() {
		mc.gameSettings.keyBindForward.pressed = true;
		if(timer.check(500)){
			mc.thePlayer.rotationYaw = mc.thePlayer.rotationYaw -= 90;
			timer.reset();
		}
	}
	
	@Override
	public void onDisable() {
		mc.gameSettings.keyBindForward.pressed = false;
	}

}
