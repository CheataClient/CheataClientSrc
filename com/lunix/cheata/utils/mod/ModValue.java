/*
 * Copyright © 2015 - 2017 Lunix and contributors 
 * All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.lunix.cheata.utils.mod;

import com.lunix.cheata.mod.Mod;
import com.lunix.cheata.utils.Category;

public class ModValue {
	private String valueName;
	private double valueMin;
	private double valueMax;
	private double valueIncrement;
	private double valueDouble;
	private boolean valueBoolean;
	private boolean isBoolean;
	
	public ModValue(String name, double min, double max, double increment, double startDouble) {
		this.valueName = name;
		this.valueMin = min;
		this.valueMax = max;
		this.valueIncrement = increment;
		this.valueDouble = startDouble;
		this.isBoolean = false;
	}
	
	public ModValue(String name, boolean startBoolean) {
		this.valueName = name;
		this.valueBoolean = startBoolean;
		this.isBoolean = true;
	}
	
	public boolean isBoolean(){
		return isBoolean;
	}

	public String getValueName() {
		return valueName;
	}

	public double getValueMin() {
		return valueMin;
	}

	public double getValueMax() {
		return valueMax;
	}

	public double getValueIncrement() {
		return valueIncrement;
	}

	public double getValueDouble() {
		return valueDouble;
	}

	public void setValueDouble(double valueDouble) {
		this.valueDouble = valueDouble;
	}

	public boolean getValueBoolean() {
		return valueBoolean;
	}

	public void setValueBoolean(boolean valueBoolean) {
		this.valueBoolean = valueBoolean;
	}

	public void setValueIncrement(double valueIncrement) {
		this.valueIncrement = valueIncrement;
	}
	
	
}
