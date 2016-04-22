/*
 * Copyright © 2015 - 2017 Lunix and contributors 
 * All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.lunix.cheata.mod.mods.combat;

import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.inventory.Slot;

import com.lunix.cheata.mod.Mod;
import com.lunix.cheata.utils.Category;
import com.lunix.cheata.utils.Timer;

public class ChestStealer extends Mod{

	public ChestStealer(String name, Category category) {
		super(name, category);
	}
	
	Timer timer = new Timer();
	public static double delay = 100;

	@Override
	public void onUpdate() {
		if(mc.thePlayer.openContainer != null){
			if(mc.thePlayer.openContainer instanceof ContainerChest){
				ContainerChest chest = (ContainerChest) mc.thePlayer.openContainer;
				int i;
				for(i = 0; i<chest.numRows*9;i++){
					if(mc.thePlayer.openContainer == null){
						break;
					}
					Slot slot =(Slot)chest.inventorySlots.get(i);
					if(slot.getStack() == null)
						continue;
					if(!timer.check((float)(delay == 0 ? 1 : delay))){
						return;
					}
					mc.playerController.func_187098_a(chest.windowId, i, 0, ClickType.QUICK_MOVE, mc.thePlayer);
				}
			}
		}
	}
}
