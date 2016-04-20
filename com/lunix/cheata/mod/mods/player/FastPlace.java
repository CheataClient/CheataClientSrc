/*
 * Copyright © 2015 - 2017 Lunix and contributors 
 * All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.lunix.cheata.mod.mods.player;

import com.lunix.cheata.Client;
import com.lunix.cheata.mod.Mod;
import com.lunix.cheata.utils.Category;

public class FastPlace extends Mod{

	public FastPlace(String name, Category category) {
		super(name, category);
	}
	
	public static double delay = 0;
	
	@Override
	public void onUpdate() {
		delay = (int) Client.getValueManager().getValueByName("PlaceDelay").getValueDouble();
		mc.rightClickDelayTimer = (int) delay;
	}
	
	@Override
	public void onDisable() {
		mc.rightClickDelayTimer = 4;
	}

}
