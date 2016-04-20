/*
 * Copyright © 2015 - 2017 Lunix and contributors 
 * All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.lunix.cheata.mod.mods.movement;

import net.minecraft.client.settings.KeyBinding;

import com.lunix.cheata.Client;
import com.lunix.cheata.mod.Mod;
import com.lunix.cheata.utils.Category;

public class Jetpack extends Mod{

	public Jetpack(String name, Category category) {
		super(name, category);
	}
	
	@Override
	public void onUpdate() {
		if(mc.gameSettings.keyBindJump.pressed){
			mc.thePlayer.jump();
		}
	}
}
