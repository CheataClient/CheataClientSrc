/*
 * Copyright © 2015 - 2017 Lunix and contributors 
 * All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.lunix.cheata.mod.mods.world;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.network.play.client.CPacketPlayerDigging.Action;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;

import com.lunix.cheata.mod.Mod;
import com.lunix.cheata.utils.Category;
import com.lunix.cheata.utils.packet.PacketUtils;

public class InstantMine extends Mod{

	public InstantMine(String name, Category category) {
		super(name, category);
	}
	
	public static boolean ncp = false;

	@Override
	public void onUpdate() {
		BlockPos var1 = mc.objectMouseOver.getBlockPos();

		if (mc.theWorld.getBlockState(var1).getMaterial() == Material.air)
			return;
		if (mc.playerController.isHittingBlock)
			if (ncp
					&& mc.gameSettings.keyBindAttack.isKeyDown())
				PacketUtils.sendPacket(new CPacketPlayerDigging(Action.STOP_DESTROY_BLOCK,
						mc.objectMouseOver.getBlockPos(), EnumFacing.getHorizontal(-1)));
			else {
				PacketUtils.sendPacket(new CPacketPlayerDigging(Action.START_DESTROY_BLOCK,
						mc.objectMouseOver.getBlockPos(), EnumFacing.getHorizontal(-1)));
				PacketUtils.sendPacket(new CPacketPlayerDigging(Action.STOP_DESTROY_BLOCK,
						mc.objectMouseOver.getBlockPos(), EnumFacing.getHorizontal(-1)));
			}
	}
}
