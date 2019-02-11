package m1miage.java.tp1;
import java.io.File;
import m1miage.java.tp1.MyFilter;

public class RepoContent {
	
//	protected void ClasseInterne() {
//		Inner class = new Inner() {
//			
//		}
//	}
	
//	protected void part3(MyFilter filter) {
//		File folder = new File(".");
//		File[] files = folder.listFiles(filter);
//		for (File file : files){
//			System.out.println(file);
//		}   
//	}

	protected void part2(File folder) {
		File[] files = folder.listFiles();
		for (File file : files){
			System.out.println(file);
			if (file.isDirectory()) {
				System.out.println("pof");
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
		MyFilter filter = new MyFilter();
		RepoContent rc= new RepoContent();
		rc.part1();
		System.out.println("part2:");
		rc.part2(f);
//		System.out.println("le 3= ");
//		rc.part3(filter);
		

	}


}
