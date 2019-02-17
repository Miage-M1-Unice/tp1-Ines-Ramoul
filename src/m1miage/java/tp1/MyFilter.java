package m1miage.java.tp1;

import java.io.File;
import java.io.FilenameFilter;

public class MyFilter implements FilenameFilter {
	
	protected String ext;
	
	public MyFilter(String ext) {
		this.ext = ext.toLowerCase();
	}
	
	@Override
	public boolean accept(File dir, String name) {
		return name.endsWith(ext);
	}


	}
