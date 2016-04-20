/*
 * Copyright © 2015 - 2017 Lunix and contributors 
 * All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.lunix.cheata.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.ScaledResolution;

import com.lunix.cheata.Client;
import com.lunix.cheata.mod.Mod;
import com.lunix.cheata.mod.mods.misc.Panic;
import com.lunix.cheata.utils.Category;

public class GreanIngameGui extends GuiIngame{

	public GreanIngameGui(Minecraft mcIn) {
		super(mcIn);
	}
	
	@Override
	protected void func_184048_a(ScaledResolution p_184048_1_) {
		Client.getFunctionMethods().onRender();
		
		int countY = 1;
		
		for(Mod mod : Client.getModManager().mods){
			if(mod.isEnabled() && !mod.isCategory(Category.NONE) && !(mod.getClass() == Client.getModManager().getMod(Panic.class).getClass())){
				mod.onRender();
				drawString(Minecraft.getMinecraft().fontRendererObj, mod.getName(), 1, 12 * countY, 0x00FF0000);
				countY++;
			}
		}
		
		drawString(Minecraft.getMinecraft().fontRendererObj, Client.getName() + " - " + Client.getVer(), 1, 2, 0xFFFFFFFF);

		Client.getGuiManager().renderPinned();
				
		super.func_184048_a(p_184048_1_);
	}

}
