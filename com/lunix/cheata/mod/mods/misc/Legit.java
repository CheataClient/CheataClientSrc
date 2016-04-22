/*
 * Copyright © 2015 - 2017 Lunix and contributors 
 * All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.lunix.cheata.mod.mods.misc;

import java.util.ArrayList;

import org.lwjgl.opengl.Display;

import com.lunix.cheata.Client;
import com.lunix.cheata.gui.CheataIngameGui;
import com.lunix.cheata.mod.Mod;
import com.lunix.cheata.utils.Category;

public class Legit extends Mod{
	
	public Legit(String name, Category category) {
		super(name, category);
	}

	private final ArrayList<Mod> previousMods = new ArrayList();

	@Override
	public void onDisable() {
		CheataIngameGui.shouldRender = true;
		for (Mod mod : previousMods)
			mod.setEnabled(true);
		previousMods.clear();

		Display.setTitle(Client.getName() + " - " + Client.getVer());
	}

	@Override
	public void onEnable() {
		CheataIngameGui.shouldRender = false;
		previousMods.clear();
		for (Mod mod : Client.getModManager().mods)
			if (!mod.getClass().equals(this.getClass()) && mod.isEnabled()) {
				previousMods.add(mod);
				mod.setEnabled(false);
			}

		Display.setTitle("Minecraft 1.8");
	}
}
