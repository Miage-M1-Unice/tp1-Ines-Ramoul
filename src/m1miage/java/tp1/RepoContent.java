package m1miage.java.tp1;
import java.io.File;
import java.io.FilenameFilter;

import m1miage.java.tp1.MyFilter;

public class RepoContent {

	//	protected void ClasseInterne() {
	//		Inner class = new Inner() {
	//			
	//		}
	//	}
	class MyFilter2 implements FilenameFilter{

		@Override
		public boolean accept(File dir, String name) {
			return name.endsWith(".java");
		}
		
	}
	
	protected void part3_1(File folder) {
		if (!folder.exists()){
			System.out.println(folder.getName() + "Directory doesn't exist");
		}
		File[] filteredFiles = folder.listFiles(new MyFilter2());
		File[] allFiles=folder.listFiles();
		//dans un premier temps on parcourt en profondeur le tableau allFiles pour voir si il y a d'autres folders dans le répertoire courant
		for (File f : allFiles){
			if ((f.isDirectory())){
				//si oui RECURRENCE
				part3_1(f);
			}
		}
		if (filteredFiles.length==0){
			//System.out.println(folder.getName() + " doesn't have any file with extension " + filter);
		}
		//on s'interesse au tableau de Files qui contiennt au moins un file .java
		else{
			for (File file : filteredFiles){
				System.out.println("File: " + folder.getName() + File.separator + file.getName());
			}
		}
	}
	
	protected void part3(File folder, String filter) {
		//File folder = new File(".");
		if (!folder.exists()){
			System.out.println(folder.getName() + "Directory doesn't exist");
		}
		File[] filteredFiles = folder.listFiles(new MyFilter(filter));
		File[] allFiles=folder.listFiles();
		//dans un premier temps on parcourt en profondeur le tableau allFiles pour voir si il y a d'autres folders dans le répertoire courant
		for (File f : allFiles){
			if ((f.isDirectory())){
				//si oui RECURRENCE
				part3(f, filter);
			}
		}
		if (filteredFiles.length==0){
			//System.out.println(folder.getName() + " doesn't have any file with extension " + filter);
		}
		//on s'interesse au tableau de Files qui contiennt au moins un file .java
		else{
			for (File file : filteredFiles){
				System.out.println("File: " + folder.getName() + File.separator + file.getName());
			}
		}
	}

	protected void part2(File folder) {
		File[] files = folder.listFiles();
		for (File file : files){
			System.out.println(file);
			if (file.isDirectory()) {
				part2(file);
			}
		}   
	}

	protected void part1() {
		File folder = new File(".");
		String[] files = folder.list();
		for (String file : files){
			System.out.println(file);
		}
	}


	public static void main(String[] args) {
		File f= new File(".");
		RepoContent rc= new RepoContent();
		System.out.println("Le contenu du répertoire: "+"\n");
		rc.part1();
		System.out.println("\n"+"Parcours en profondeur:"+"\n");
		rc.part2(f);
		System.out.println("\n"+"Parcours avec filtre version CLASSE EXTERNE:"+"\n");
		rc.part3(f,".java");
		System.out.println("\n"+ "Parcours avec filtre version CLASSE INTERNE"+"\n");
		rc.part3_1(f);
	}


}
