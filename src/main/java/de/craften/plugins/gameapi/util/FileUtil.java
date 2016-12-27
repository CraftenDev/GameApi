package de.craften.plugins.gameapi.util;

import java.io.File;
import java.io.IOException;

import com.google.common.io.Files;

public class FileUtil {

	public static void copyFolder(File sourceFile, File destFile) throws IOException {
		
		if (!sourceFile.exists()) {
			return;
		}
		
		if (!destFile.exists()) {
			destFile.mkdirs();
		}
		
		for (File file : sourceFile.listFiles()) {
			
			if (file.isDirectory()) {
				copyFolder(file, new File(destFile, file.getName()));
			} else {
				Files.copy(file, new File(destFile, file.getName()));
			}
			
		}
		
	}
	
	public static boolean deleteFolder(File dir) {
		
		if (!dir.exists()) {
			return false;
		}
		
		for (File file : dir.listFiles()) {
			
			if (file.isDirectory()) {
				deleteFolder(file);
			} else {
				file.delete();
			}
			
		}
		
		 return dir.delete();
		
	}
	
}
