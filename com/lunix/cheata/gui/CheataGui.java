/*
 * Copyright © 2015 - 2017 Lunix and contributors 
 * All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.lunix.cheata.gui;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiControls;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiYesNoCallback;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.settings.GameSettings;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.lunix.cheata.Client;

public class CheataGui extends GuiScreen implements GuiYesNoCallback{

	private static final Logger field_184868_g = LogManager.getLogger();
    protected GuiScreen field_184864_a;
    protected String mainText = "Cheata Menu";

    public CheataGui(GuiScreen p_i46592_1_)
    {
        this.field_184864_a = p_i46592_1_;
    }

    /**
     * Adds the buttons (and other controls) to the screen in question. Called when the GUI is displayed and when the
     * window resizes, the buttonList is cleared beforehand.
     */
    public void initGui()
    {
        this.drawButtons();
    }

    public void drawButtons()
    {
        this.buttonList.add(new GuiButton(1, this.width / 2 + 4, this.height - 28, 72, 20, I18n.format("Gui Keybind", new Object[0])));
        this.buttonList.add(new GuiButton(0, this.width / 2 + 82, this.height - 28, 72, 20, I18n.format("Back", new Object[0])));
    }

    /**
     * Called by the controls from the buttonList when activated. (Mouse pressed for buttons)
     */
    protected void actionPerformed(GuiButton button) throws IOException
    {
        if (button.enabled)
        {
        	if (button.id == 0){
                this.mc.displayGuiScreen(this.field_184864_a);
        	}
        	
        	if (button.id == 1){
        		this.mc.displayGuiScreen(new GuiControls(this, new GameSettings()));
        	}
        }
    }

    /**
     * Draws the screen and all the components in it. Args : mouseX, mouseY, renderPartialTicks
     */
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
    	this.drawDefaultBackground();
    	this.drawCenteredString(this.fontRendererObj, this.mainText, this.width / 2, 20, Client.getColor());
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    /**
     * Called when the mouse is clicked. Args : mouseX, mouseY, clickedButton
     */
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException
    {
        super.mouseClicked(mouseX, mouseY, mouseButton);
    }

    /**
     * Called when a mouse button is released.  Args : mouseX, mouseY, releaseButton
     */
    protected void mouseReleased(int mouseX, int mouseY, int state)
    {
        super.mouseReleased(mouseX, mouseY, state);
    }
}
