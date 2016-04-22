/*
 * Copyright © 2015 - 2017 Lunix and contributors 
 * All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.lunix.cheata.mod.mods.combat;

import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.realms.RealmsBridge;

import com.lunix.cheata.gui.CheataMainMenu;
import com.lunix.cheata.mod.Mod;
import com.lunix.cheata.utils.Category;

public class AutoDisconect extends Mod{

	public AutoDisconect(String name, Category category) {
		super(name, category);
	}
	
	public static double leaveHealth = 4;
	
	@Override
	public void onUpdate() {
		if(mc.thePlayer.getHealth() <= leaveHealth){
			boolean flag = this.mc.isIntegratedServerRunning();
            boolean flag1 = this.mc.isConnectedToRealms();
            this.mc.theWorld.sendQuittingDisconnectingPacket();
            this.mc.loadWorld((WorldClient)null);

            if (flag)
            {
                this.mc.displayGuiScreen(new CheataMainMenu());
            }
            else if (flag1)
            {
                RealmsBridge realmsbridge = new RealmsBridge();
                realmsbridge.switchToRealms(new CheataMainMenu());
            }
            else
            {
                this.mc.displayGuiScreen(new GuiMultiplayer(new CheataMainMenu()));
            }
		}
	}
}
