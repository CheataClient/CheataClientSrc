/*
 * Copyright © 2015 - 2017 Lunix and contributors 
 * All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.lunix.cheata.mod.mods.player;

import net.minecraft.block.Block;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.util.EnumHand;

import com.lunix.cheata.Client;
import com.lunix.cheata.mod.Mod;
import com.lunix.cheata.utils.Category;

public class NerdPole extends Mod {

	public NerdPole(String name, Category category) {
		super(name, category);
	}

	public static boolean fast = true;

	@Override
	public void onUpdate() {
		fast = Client.getValueManager().getValueByName("NerdPoleFast").getValueBoolean();
		if(mc.inGameHasFocus){
			if(!isHeldItem(Blocks.ladder) && 
					!isHeldItem(Blocks.vine)){
				mc.thePlayer.sendQueue.addToSendQueue(new CPacketPlayer(true));
				mc.thePlayer.setAngles(mc.thePlayer.cameraYaw, -90);
				if(fast){
					mc.rightClickDelayTimer = 0;
					mc.thePlayer.jump();
					if(isInteractable()){
						KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
					}
					KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), true);
					KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), false);
				}else if(mc.thePlayer.onGround){
					if(!Client.getModManager().getMod(FastPlace.class).isEnabled()){
						mc.rightClickDelayTimer = 4;
					}
					mc.thePlayer.jump();
					if(isInteractable()){
						KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
					}
					KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), true);
					KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), false);
				}
			}
		}
	}
	
	@Override
	public void onDisable() {
		if(!Client.getModManager().getMod(FastPlace.class).isEnabled()){
			mc.rightClickDelayTimer = 4;
		}
		KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), false);
	}

	private boolean isHeldItem(Block itemIn){
		if(!(mc.thePlayer.getHeldItemMainhand() == null)){
			if(Item.getIdFromItem(mc.thePlayer.getHeldItem(EnumHand.MAIN_HAND).getItem()) == Item.getIdFromItem(Item.getItemFromBlock(itemIn))){
				return true;
			}
		}
		return false;
	}
	
	private boolean isInteractable(){
		if(isHeldItem(Blocks.chest) || isHeldItem(Blocks.ender_chest) || 
				isHeldItem(Blocks.trapped_chest) ||
				isHeldItem(Blocks.noteblock) ||
				isHeldItem(Blocks.furnace) ||
				isHeldItem(Blocks.dispenser) ||
				isHeldItem(Blocks.crafting_table) ||
				isHeldItem(Blocks.chain_command_block) ||
				isHeldItem(Blocks.command_block) ||
				isHeldItem(Blocks.anvil) ||
				isHeldItem(Blocks.bed)  ||
				isHeldItem(Blocks.dropper) ||
				isHeldItem(Blocks.end_portal_frame)){
			return true;
		}
		return false;
	}
}
