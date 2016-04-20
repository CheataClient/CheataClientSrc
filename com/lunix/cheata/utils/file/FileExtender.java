/*
 * Copyright © 2015 - 2017 Lunix and contributors 
 * All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.lunix.cheata.utils.file;

import java.io.File;


public class FileExtender {

	private static File file;
	private static String fileName;
	
	public static File getFile(){
		return file;
	}
	
	public static String getName(){
		return fileName;
	}
	
	public FileExtender(String fileName){
		this.fileName = fileName;
		file = new File(FileManager.getDir().getAbsolutePath(), fileName + ".chta");
		if(!file.exists()){
			System.out.println(fileName);
			FileManager.createFile(fileName + ".chta");
		}
	}
}
