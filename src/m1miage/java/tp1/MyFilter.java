package m1miage.java.tp1;

import java.io.File;
import java.io.FilenameFilter;

public class MyFilter implements FilenameFilter {
	
	public boolean accept(File dir, String name) {
		if(name.endsWith(".java") || name.endsWith(".class")) {
			return true;
		}
		return false;
	}
		
	
}
