/*
 * Copyright © 2015 - 2017 Lunix and contributors 
 * All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.lunix.cheata.mod.mods.misc;

import com.lunix.cheata.mod.Mod;
import com.lunix.cheata.utils.Category;
import com.lunix.cheata.utils.Timer;

public class AutoFish extends Mod{

	public AutoFish(String name, Category category) {
		super(name, category);
	}

	private boolean isFishing = false;
	private Timer timer = new Timer();
	
	@Override
	public void onUpdate() {
		if(mc.thePlayer.fishEntity != null && mc.thePlayer.fishEntity.motionY != 0.0D && !isFishing){
			isFishing = true;
			mc.rightClickMouse();
			timer.check(1000);
			mc.rightClickMouse();
			isFishing = false;
		}
	}
}
