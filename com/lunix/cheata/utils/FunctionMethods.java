/*
 * Copyright © 2015 - 2017 Lunix and contributors 
 * All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.lunix.cheata.utils;

import org.lwjgl.input.Keyboard;

import com.lunix.cheata.Client;
import com.lunix.cheata.mod.Mod;

public class FunctionMethods {
	
	public static void	onUpdate(){
		for(Mod mod : Client.getModManager().mods){
			if(mod.isEnabled()){
				mod.onUpdate();
			}
		}
	}
	
	public static void onRender(){
		for(Mod mod : Client.getModManager().mods){
			if(mod.isEnabled()){
				mod.onRender();
			}
		}
	}
	
	public static void onClickLeft(){
		for(Mod mod : Client.getModManager().mods){
			if(mod.isEnabled()){
				mod.onClickLeft();
			}
		}
	}
	
	public static void onClickRight(){
		for(Mod mod : Client.getModManager().mods){
			if(mod.isEnabled()){
				mod.onClickRight();
			}
		}
	}
	
	public static void onKeyPress(){
		for(Mod mod : Client.getModManager().mods){
			if(mod.hasBind){
				if(mod.hasBindMask){
					if(Keyboard.isKeyDown(mod.getBindMask())){
						if(Keyboard.isKeyDown(mod.getBind())){
							mod.toggle();
						}
					}
				}else{
					if(Keyboard.isKeyDown(mod.getBind())){
						mod.toggle();
					}
				}
			}
		}
	}
	
}
