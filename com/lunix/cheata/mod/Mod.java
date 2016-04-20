/*
 * Copyright © 2015 - 2017 Lunix and contributors 
 * All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.lunix.cheata.mod;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

import com.lunix.cheata.Client;
import com.lunix.cheata.utils.Category;

public class Mod {
	
	protected static Minecraft mc = Minecraft.getMinecraft();
	
	private String name;
	private int bind;
	private int bindMask;
	private Category category;
	private int color;
	private boolean isEnabled;
	public boolean hasBind;
	public boolean hasBindMask;
	
	public Mod(String name, Category category){
		this.name = name;
		this.category = category;
		this.hasBind = false;
		this.hasBindMask = false;
	}
	
	public Mod(String name, int bind, Category category){
		this.name = name;
		this.bind = bind;
		this.category = category;
		this.hasBind = true;
		this.hasBindMask = false;
	}
	
	public Mod(String name, int bind, int bindMask, Category category){
		this.name = name;
		this.bind = bind;
		this.bindMask = bindMask;
		this.category = category;
		this.hasBind = true;
		this.hasBindMask = true;
	}

	public int getBind() {
		return bind;
	}

	public int getBindMask() {
		return bindMask;
	}

	public void setBind(int bind){ 
		if(!this.hasBind){
			this.hasBind = true;
		}
		this.bind = bind;
	}

	public void setBindMask(int bindMask) {
		if(!this.hasBindMask){
			this.hasBindMask = true;
		}
		this.bindMask = bindMask;
	}

	public void removeBindMask(int bindMask) {
		this.hasBindMask = false;
		bindMask = 0;
	}

	public String getName() {
		return name;
	}

	public Category getCategory() {
		return category;
	}

	public int getColor() {
		return color;
	}

	public boolean isEnabled() {
		return isEnabled;
	}
	
	public void setEnabled(boolean state){
		if(Client.isInGame())
			onToggle();
		if(state){
			if(Client.isInGame())
				onEnable();
			this.isEnabled = true;
		}else{
			if(Client.isInGame())
				onDisable();
			this.isEnabled = false;
		}
	}
	
	public void toggle(){
		setEnabled(!this.isEnabled());
	}

	public void onEnable(){}
	public void onDisable(){}
	public void onToggle(){}
	public void onUpdate(){}
	public void onRender(){}
	public void onClickLeft(){}
	public void onClickRight(){}

	public boolean isCategory(Category isCategory) {
		if(isCategory == category)
			return true;
		return false;
	}

}
