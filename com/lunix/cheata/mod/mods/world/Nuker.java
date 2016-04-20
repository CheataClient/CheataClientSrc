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
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;

import com.lunix.cheata.mod.Mod;
import com.lunix.cheata.utils.Category;

public class Nuker extends Mod{

	public Nuker(String name, Category category) {
		super(name, category);
	}

	public static int size = 5;
	public static int sizeOther = Math.round(size / 2);
	
	@Override
	public void onUpdate() {
		if(mc.thePlayer.capabilities.isCreativeMode){
			for(int x = -size; x < size + sizeOther; x++){
				for(int z = -size; z < size + sizeOther; z++){
					for(int y = -size; y < size + sizeOther; y++){
						boolean shouldBreakBlock = true;
	        			int blockX = (int) (mc.thePlayer.posX + x);
	        			int blockY = (int) (mc.thePlayer.posY + y);
	        			int blockZ = (int) (mc.thePlayer.posZ + z);
	        			if (Block.getIdFromBlock(mc.theWorld.getBlockState(new BlockPos(blockX, blockY, blockZ)).getBlock()) != 0){
	        				mc.thePlayer.sendQueue.addToSendQueue(new CPacketPlayerDigging(CPacketPlayerDigging.Action.START_DESTROY_BLOCK, new BlockPos(blockX, blockY, blockZ), EnumFacing.UP));
	         			}
	 				}
	 			}
	 		}
		}
	}
}
