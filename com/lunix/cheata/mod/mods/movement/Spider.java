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

public class Spider extends Mod{

	public Spider(String name, Category category) {
		super(name, category);
	}
	
	public static double speed = 0.25;
	
	@Override
	public void onUpdate() {
		speed = Client.getValueManager().getValueByName("SpiderSpeed").getValueDouble();
		if(mc.thePlayer.isCollidedHorizontally){
			mc.thePlayer.motionY = speed;
		}
	}
}
