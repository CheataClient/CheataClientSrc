/*
 * Copyright © 2015 - 2017 Lunix and contributors 
 * All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.lunix.cheata.mod;

import java.util.ArrayList;
import java.util.Collections;

import org.lwjgl.input.Keyboard;

import com.lunix.cheata.gui.GuiMod;
import com.lunix.cheata.mod.mods.combat.*;
import com.lunix.cheata.mod.mods.misc.*;
import com.lunix.cheata.mod.mods.movement.*;
import com.lunix.cheata.mod.mods.player.*;
import com.lunix.cheata.mod.mods.world.*;
import com.lunix.cheata.utils.Category;

public class ModManager {
	public static ArrayList<Mod> mods = new ArrayList<Mod>();

	public static void setup(){
		mods.add(new GuiMod("Click Gui", Keyboard.KEY_RSHIFT, Category.NONE));
		
		/*
		 * Misc
		 */
		mods.add(new AntiFire("Anti-Fire", Category.MISC));
		mods.add(new AutoFish("AutoFish", Category.MISC));
		mods.add(new Derp("Derp", Category.MISC));
		mods.add(new Drop("Drop", Category.MISC));
		mods.add(new NoPumkin("NoPumkin", Category.MISC));
		mods.add(new Panic("Panic", Keyboard.KEY_P, Category.MISC));
		mods.add(new SkinDerp("SkinDerp", Category.MISC));
		
		/*
		 * Combat
		 */
		mods.add(new Aimbot("Aimbot", Category.COMBAT));
		mods.add(new KillAura("KillAura", Category.COMBAT));
		
		/*
		 * Player
		 */
		mods.add(new AntiAfk("Anti-Afk", Category.PLAYER));
		mods.add(new AutoRespawn("Auto-Respawn", Category.PLAYER));
		mods.add(new FastPlace("FastPlace", Category.PLAYER));
		mods.add(new FreeCam("FreeCam", Category.PLAYER));
		mods.add(new FullBright("FullBright",Keyboard.KEY_B, Category.PLAYER));
		mods.add(new NerdPole("NerdPole", Category.PLAYER));
		mods.add(new NoLava("NoLava", Category.PLAYER));
		mods.add(new NoWater("NoWater", Category.PLAYER));
		mods.add(new NoWeb("NoWeb", Category.PLAYER));
		
		/*
		 * Movement
		 */
		mods.add(new AutoWalk("Auto-Walk", Category.MOVEMENT));
		mods.add(new BunnyHop("BunnyHop", Category.MOVEMENT));
		mods.add(new FastFall("FastFall", Category.MOVEMENT));
		mods.add(new FastLadder("FastLadder", Category.MOVEMENT));
		mods.add(new Flight("Flight", Keyboard.KEY_R, Category.MOVEMENT));
		mods.add(new Glide("Glide", Category.MOVEMENT));
		mods.add(new Jetpack("Jetpack", Category.MOVEMENT));
		mods.add(new NoFall("NoFall", Category.MOVEMENT));
		mods.add(new Speed("Speed", Category.MOVEMENT));
		mods.add(new Spider("Spider", Category.MOVEMENT));
		mods.add(new Sprint("Sprint", Category.MOVEMENT));
		mods.add(new Step("Step", Category.MOVEMENT));
		mods.add(new WaterWalk("Water Walk", Category.MOVEMENT));
		
		/*
		 * World
		 */
		mods.add(new Nuker("Nuker", Category.WORLD));
		mods.add(new Timer("Timer", Category.WORLD));
	}
	
	public static ArrayList getMods(){
		return mods;
	}
	
	public static Mod getMod(Class<? extends Mod> modClass){
		for(Mod mod : mods){
			if(mod.getClass() == modClass){
				return mod;
			}
		}
		return null;
	}
	
	public static Mod getModByName(String modName){
		for(Mod mod : mods){
			if(mod.getName() == modName){
				return mod;
			}
		}
		return null;
	}
	
	public static Mod getModByClassName(String modClassName){
		for(Mod mod : mods){
			if(mod.getClass().getName().substring(26) == modClassName){
				return mod;
			}
		}
		return null;
	}
}
