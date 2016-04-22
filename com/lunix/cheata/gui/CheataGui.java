/*
 * Copyright © 2015 - 2017 Lunix and contributors 
 * All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.lunix.cheata.gui;

import java.awt.Font;
import java.io.IOException;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiControls;
import net.minecraft.client.gui.GuiListWorldSelectionEntry;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiScreenWorking;
import net.minecraft.client.gui.GuiYesNo;
import net.minecraft.client.gui.GuiYesNoCallback;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.world.storage.ISaveFormat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.darkstorm.minecraft.gui.font.UnicodeFontRenderer;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.lunix.cheata.Client;
import com.lunix.cheata.utils.file.FileManager;

public class CheataGui extends GuiScreen implements GuiYesNoCallback {

	private static final Logger field_184868_g = LogManager.getLogger();
	protected GuiScreen returnGui;
	protected String mainText = "Cheata Menu";

	public CheataGui(GuiScreen p_i46592_1_) {
		this.returnGui = p_i46592_1_;
	}

	/**
	 * Adds the buttons (and other controls) to the screen in question. Called
	 * when the GUI is displayed and when the window resizes, the buttonList is
	 * cleared beforehand.
	 */
	public void initGui() {
		this.drawButtons();
	}

	public void drawButtons() {
		this.buttonList.add(new GuiButton(2, this.width - 2 - (82 * 3), this.height - 22, 78, 18, I18n.format("cheata.gui.button.reset", new Object[0])));
		this.buttonList.add(new GuiButton(1, this.width - 2 - (82 * 2), this.height - 22, 78, 18, I18n.format("cheata.gui.button.keybind", new Object[0])));
		this.buttonList.add(new GuiButton(0, this.width - 2 - (82 * 1), this.height - 22, 78, 18, I18n.format("cheata.gui.button.back", new Object[0])));
	}

	/**
	 * Called by the controls from the buttonList when activated. (Mouse pressed
	 * for buttons)
	 **/
	protected void actionPerformed(GuiButton button) throws IOException {
		if (button.enabled) {
			if (button.id == 0) {
				this.mc.displayGuiScreen(this.returnGui);
			}

			if (button.id == 1) {
				this.mc.displayGuiScreen(new GuiControls(this,
						new GameSettings()));
			}

			if (button.id == 2) {
				this.mc.displayGuiScreen(new GuiYesNo(new GuiYesNoCallback()
		        {
		            public void confirmClicked(boolean result, int id)
		            {
		                if (result)
		                {
		    				FileManager.deleteFile("settings.chta");
		    				mc.displayGuiScreen(new CheataGui(returnGui));
		                }
		            }
		        }, I18n.format("cheata.reset.title", new Object[0]), I18n.format("cheata.reset.question", new Object[0]), I18n.format("cheata.reset.reset", new Object[0]), I18n.format("cheata.reset.back", new Object[0]), 0));
			}
		}
	}

	/**
	 * Draws the screen and all the components in it. Args : mouseX, mouseY,
	 * renderPartialTicks
	 **/
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {

		/** Draws the tiled dirt **/
		this.drawDefaultBackground();

		/** Draws the Title **/
		this.drawCenteredString(this.fontRendererObj, this.mainText,
				this.width / 2, 20, Client.getColor());
		
		GL11.glPushMatrix();
		GL11.glScaled(4, 4, 4);
		this.drawCenteredString(this.fontRendererObj, "IDK WHAT TO", this.width / 8, this.height / 8 - 5, Client.getColor());
		this.drawCenteredString(this.fontRendererObj, "PUT HERE", this.width / 8, this.height / 8 + 5, Client.getColor());
		GL11.glPopMatrix();
		
		/** Strings for copyright **/
		/** Draws the copyright **/
		this.drawString(this.fontRendererObj, I18n.format("cheata.copyright.line1", new Object[0]), 2, this.height - 30,
				Client.getColor());
		this.drawString(this.fontRendererObj, I18n.format("cheata.copyright.line2", new Object[0]), 2, this.height - 20,
				Client.getColor());
		this.drawString(this.fontRendererObj, I18n.format("cheata.copyright.line3", new Object[0]), 2, this.height - 10,
				Client.getColor());

		/** String for body text **/
		String body1 = "";

		super.drawScreen(mouseX, mouseY, partialTicks);
	}

	/** Called when the mouse is clicked. Args : mouseX, mouseY, clickedButton **/
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton)
			throws IOException {
		super.mouseClicked(mouseX, mouseY, mouseButton);
	}

	/**
	 * * Called when a mouse button is released. Args : mouseX, mouseY,
	 * releaseButton
	 **/
	protected void mouseReleased(int mouseX, int mouseY, int state) {
		super.mouseReleased(mouseX, mouseY, state);
	}
}
