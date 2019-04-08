package m1miage.java.tp2;

/**
 * @version 1.00 23 Mars 2001
 * @author Michel Buffa
 * Inspiré par la classe Reflectiontest.java de
 * Cay S. Horstmann & Gary Cornell, publiée dans le livre Core Java, Sun Press
 */

import java.lang.reflect.*;
import java.io.*;

public class AnalyseurDeClasse {

  public static void analyseClasse(String nomClasse) throws ClassNotFoundException {
    // Récupération d'un objet de type Class correspondant au nom passé en paramètres
    Class cl = Class.forName(nomClasse);

    afficheEnTeteClasse(cl);

    System.out.println();
    afficheAttributs(cl);

    System.out.println();
    afficheConstructeurs(cl);

    System.out.println();
    afficheMethodes(cl);

    // L'accolade fermante de fin de classe !
    System.out.println("}");
  }


  /** Retourne la classe dont le nom est passé en paramètre */
  public static Class getClasse(String nomClasse) throws ClassNotFoundException {
	Class cl = Class.forName(nomClasse);
	return cl;
  }

  /** Cette méthode affiche par ex "public class Toto extends Tata implements Titi, Tutu {" */
  public static void afficheEnTeteClasse(Class cl) {
    //  Affichage du modifier et du nom de la classe
	String className= cl.getName();
    int i = cl.getModifiers();
    String str = Modifier.toString(i);
    
    System.out.printf("\n"+ str+" class "+ className);
    

   // Récupération de la superclasse si elle existe (null si cl est le type Object)
    Class supercl = cl.getSuperclass();

    // On ecrit le "extends " que si la superclasse est non nulle et
    // différente de Object
    if (supercl!=null && (supercl.getTypeName()!= "Object")) {
    	System.out.printf(" extends "+ supercl.getName());
    }

    // Affichage des interfaces que la classe implemente
    Class[] intfs= cl.getInterfaces();
    if (intfs.length != 0) {
    	for (Class intf:intfs) {
    		System.out.printf(" implements ");
    		System.out.printf(intf.getName());
    	}
    }

    // Enfin, l'accolade ouvrante !
    System.out.print(" {\n");
  }

  public static void afficheAttributs(Class cl) {
	  System.out.println("//Champs");
	  Field[] tas= cl.getDeclaredFields();
	  if (tas.length!=0) {
		  for (Field ta: tas) {
			  System.out.printf(Modifier.toString(ta.getModifiers())+" "+ta.getType().getSimpleName()+" ");
			  System.out.printf(ta.getName());
			  System.out.printf(";\n");

		  }
	  }
  }

  public static void afficheConstructeurs(Class cl) {
	  System.out.println("//Constructeurs");
     Constructor[] csts= cl.getConstructors();
     if (csts.length != 0) {
    	 for (Constructor cst : csts) {
    		 System.out.print(cst);
    		 System.out.printf(";\n");
    	 }
     }
      //System.out.println("{}");
    }


  public static void afficheMethodes(Class cl) {
	  System.out.println("//Methodes");
    Method[] mths = cl.getDeclaredMethods();
    if (mths.length != 0) {
   	 for (Method mth : mths) {
   		 System.out.print(mth);
   		System.out.printf(";\n");
   	 }
    }
    }
  

  public static String litChaineAuClavier() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      return br.readLine();
  }

  public static void main(String[] args) throws IOException {
    boolean ok = false;

    while(!ok) {
      try {
        System.out.print("Entrez le nom d'une classe (ex : java.util.Date): ");
        //String nomClasse = litChaineAuClavier();
        String nomClasse = "java.awt.Point";

        analyseClasse(nomClasse);

        ok = true;
      } catch(ClassNotFoundException e) {
        System.out.println("Classe non trouvée.");
      }
    }
  }
}