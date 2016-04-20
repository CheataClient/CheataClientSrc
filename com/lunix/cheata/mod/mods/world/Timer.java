/*
 * Copyright © 2015 - 2017 Lunix and contributors 
 * All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.lunix.cheata.mod.mods.world;

import com.lunix.cheata.Client;
import com.lunix.cheata.mod.Mod;
import com.lunix.cheata.utils.Category;

public class Timer extends Mod{

	public Timer(String name, Category category) {
		super(name, category);
	}
	
	public static double speed = 2;
	
	@Override
	public void onEnable() {
		mc.timer.timerSpeed = (float) speed;
	}
	
	@Override
	public void onUpdate() {
		speed = (float) Client.getValueManager().getValueByName("TimerSpeed").getValueDouble();
		if(!(mc.timer.timerSpeed == speed)){
			mc.timer.timerSpeed = (float) speed;
		}
	}
	
	@Override
	public void onDisable() {
		mc.timer.timerSpeed = 1F;
	}

}
