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
import java.util.logging.Logger;

import net.minecraft.client.Minecraft;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lunix.cheata.Client;
import com.lunix.cheata.utils.file.FileExtender;
import com.lunix.cheata.utils.file.FileManager;
import com.lunix.cheata.utils.mod.ModValue;

public class ModSettings extends FileExtender{

	public ModSettings() {
			super("settings");
		}
	
	private static String fileName = "settings.chta";

	public static void saveMods() {
		JsonObject json = new JsonObject();
		for(ModValue value : Client.getValueManager().values){
			if(value.isBoolean()){
				json.addProperty(value.getValueName(), value.getValueBoolean());
				Minecraft.logger.info("Set " + value.getValueName() + " to " + value.getValueBoolean());
			}else{
				json.addProperty(value.getValueName(), value.getValueDouble());
				Minecraft.logger.info("Set " + value.getValueName() + " to " + value.getValueDouble());
			}
		}
		FileManager.WriteFile(fileName, json.toString());
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
				ModValue value = Client.getValueManager().getValueByName(entry.getKey());
				if(entry.getKey().equalsIgnoreCase(value.getValueName())){
					if(value.isBoolean()){
						Minecraft.logger.info("Set " + value.getValueName() + " to " + value.getValueBoolean());
						value.setValueBoolean(entry.getValue().getAsBoolean());
					}else{
						Minecraft.logger.info("Set " + value.getValueName() + " to " + value.getValueDouble());
						value.setValueDouble(entry.getValue().getAsDouble());
					}
				}
			}
			
		}catch (Exception e){
			e.printStackTrace();
		}
		
	}
}
