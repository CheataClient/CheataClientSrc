/*
 * Copyright © 2015 - 2017 Lunix and contributors 
 * All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.lunix.cheata.mod.mods.movement;

import com.lunix.cheata.Client;
import com.lunix.cheata.mod.Mod;
import com.lunix.cheata.utils.Category;

public class Glide extends Mod{

	public Glide(String name, Category category) {
		super(name, category);
	}
	
	public static double speed = 0.125;
	
	@Override
	public void onUpdate() {
		speed = Client.getValueManager().getValueByName("GlideSpeed").getValueDouble();
		if(mc.thePlayer.fallDistance != 0 && mc.thePlayer.motionY != 0){
			mc.thePlayer.motionY = -speed;
		}
	}
}
