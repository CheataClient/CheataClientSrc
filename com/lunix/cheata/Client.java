/*
 * Copyright © 2015 - 2017 Lunix and contributors 
 * All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.lunix.cheata;

import net.minecraft.client.Minecraft;

import org.darkstorm.minecraft.gui.theme.simple.SimpleTheme;
import org.darkstorm.minecraft.gui.util.GuiManagerDisplayScreen;
import org.lwjgl.opengl.Display;

import com.lunix.cheata.gui.GuiManager;
import com.lunix.cheata.mod.ModManager;
import com.lunix.cheata.utils.FunctionMethods;
import com.lunix.cheata.utils.file.FileManager;
import com.lunix.cheata.utils.file.mod.ModEnabled;
import com.lunix.cheata.utils.file.mod.ModSettings;
import com.lunix.cheata.utils.mod.ModValueManager;

public class Client {

	private static String name = "Cheata";
	private static String ver = "Pre";
	private static String auth = "LUNiX";
	
	private static ModManager modManager;
	private static FileManager fileManager;
	private static ModValueManager valueManager;
	private static FunctionMethods funcMethods;
	private static GuiManager guiManager;
	private static GuiManagerDisplayScreen gui;
	
	private static boolean isInGame;
	
	public static void load(){
		Display.setTitle(name + " - " + ver);

		Client.getFileManager().setup();
		Client.getModManager().setup();
		Client.getValueManager().setup();
		
		ModEnabled.loadMods();
		ModSettings.loadMods();
		
		Runtime.getRuntime().addShutdownHook(new Thread()
		{
		    @Override
		    public void run()
		    {
		    	Client.getFileManager().saveMods();
		    	Client.getFileManager().saveModSettigs();
		    }
		});
	}
	
	public static GuiManager getGuiManager(){
		if(guiManager == null){
			guiManager = new GuiManager();
			guiManager.setTheme(new SimpleTheme());
			guiManager.setup();
			guiManager.update();
		}
		return guiManager;
	}
	
	public static GuiManagerDisplayScreen getGui(){
		if(gui == null){
			gui = new GuiManagerDisplayScreen(getGuiManager());
		}
		return gui;
	}

	public static String getName() {
		return name;
	}

	public static String getVer() {
		return ver;
	}

	public static String getAuth() {
		return auth;
	}

	public static ModManager getModManager() {
		return modManager;
	}

	public static FunctionMethods getFunctionMethods() {
		return funcMethods;
	}
	
	public static FileManager getFileManager(){
		return fileManager;
	}
	
	public static ModValueManager getValueManager(){
		return valueManager;
	}

	public static boolean isInGame() {
		return isInGame;
	}

	public static void setInGame(boolean isInGame) {
		Client.isInGame = isInGame;
	}
}
