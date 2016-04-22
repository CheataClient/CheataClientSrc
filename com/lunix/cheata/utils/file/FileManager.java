/*
 * Copyright © 2015 - 2017 Lunix and contributors 
 * All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.lunix.cheata.utils.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

import net.minecraft.client.Minecraft;

import org.apache.commons.io.FileUtils;

import com.lunix.cheata.Client;
import com.lunix.cheata.utils.file.mod.ModEnabled;
import com.lunix.cheata.utils.file.mod.ModSettings;

public class FileManager {
	private static File dir = new File(Minecraft.getMinecraft().mcDataDir.getAbsolutePath(), Client.getName());
	
	public static void createFile(String fileName){
		try{
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(dir.getAbsolutePath(), fileName)));
			writer.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void deleteFile(String fileName){
		try{
			File file = new File(dir.getAbsolutePath(), fileName);
			file.delete();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static File getDir(){
		return dir;
	}
	
	public static String readFile(String fileName){
		try {
			File file = new File(getDir().getAbsolutePath(), fileName);
			String fileContents;
			BufferedReader reader = new BufferedReader(new InputStreamReader(new DataInputStream(new FileInputStream(file))));
			fileContents = FileUtils.readFileToString(file);
			reader.close();
			return fileContents;
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return "";
	}
	
	public static void saveMods() {
		ModEnabled.saveMods();
	}

	public static void saveModSettigs() {
		ModSettings.saveMods();
	}
	
	public static void WriteFile(String fileName, String string){
		try{
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(getDir().getAbsolutePath(), fileName)));
			writer.write(string);
			writer.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void setup() {
		if (!getDir().exists())
			getDir().mkdirs();
	}
}
