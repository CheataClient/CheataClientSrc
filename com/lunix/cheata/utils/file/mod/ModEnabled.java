/*
 * Copyright © 2015 - 2017 Lunix and contributors 
 * All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.lunix.cheata.utils.file.mod;

import java.io.File;
import java.util.Map.Entry;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lunix.cheata.Client;
import com.lunix.cheata.gui.GuiMod;
import com.lunix.cheata.mod.Mod;
import com.lunix.cheata.utils.file.FileExtender;
import com.lunix.cheata.utils.file.FileManager;

public class ModEnabled extends FileExtender{

	private static String fileName = "enabled.chta";
	
	public ModEnabled() {
		super("enable");
	}

	public static void saveMods() {
		JsonObject json = new JsonObject();
		for(Mod mod : Client.getModManager().mods){
			if(!mod.getName().equalsIgnoreCase(Client.getModManager().getMod(GuiMod.class).getName())){
				json.addProperty(mod.getName(), mod.isEnabled());
				FileManager.WriteFile(fileName, json.toString());
			}
		}
	}

	public static void loadMods() {
		Client.getFileManager();
		if(!new File(FileManager.getDir(), fileName).exists()){
			FileManager.createFile(fileName);
			return;
		}
		if(FileManager.readFile(fileName).isEmpty()){
			return;
		}
		String fileContents = FileManager.readFile(fileName);
		try{
			JsonObject json = (JsonObject) new JsonParser().parse(fileContents);
			for(Entry<String, JsonElement> entry : json.entrySet()){
				for(Mod mod : Client.getModManager().mods){
					if(entry.getKey().equalsIgnoreCase(mod.getName())){
						mod.setEnabled(entry.getValue().getAsBoolean());
						Minecraft.logger.info("Set " + mod.getName() + " enabled to " + mod.isEnabled());
					}
				}
			}
			
		}catch (Exception e){
			e.printStackTrace();
		}
		
		
	}

}
