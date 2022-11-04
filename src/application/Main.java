package application;
	
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;


import org.sikuli.script.Screen;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	

	  static Runnable task;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("index.fxml"));
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			Scene scene = new Scene(root,screenSize.getWidth()-500,screenSize.getHeight()-100);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
		
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		 
	}
	

	
	public static void main(String[] args) throws InterruptedException, FileNotFoundException, ParseException {
		  
		
		String username=System.getProperty("user.name");
		File fin=new File("C:\\Users\\"+username+"\\AppData\\Local\\Microsoft\\WindowsApps");
		File[] files = fin.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith("exe");
			}
		}); 
		 String ubuntu = null;
		for (int i = 0; i < files.length; i++) {
			
			if (files[i].getName().equals("ubuntu.exe")  ) {
				ubuntu="$\\Ubuntu";
			}else if (files[i].getName().equals("ubuntu2004.exe")  ) {
				ubuntu=".localhost\\Ubuntu-20.04";
			}
		}
		
		
		String path ="\\\\wsl"+ubuntu+"\\root\\cellbox\\Gromacs_Workplace";
		
	boolean f=	new File("/"+path).mkdirs();
	 System.out.println(f);
	/*	  File f=new File("Dela.mol");
	      
	       Scanner myReader = new Scanner(f);
	       String data=null;
	       while (myReader.hasNextLine()) {
	         data += myReader.nextLine()+"\n";
	       
	       }
	    //   System.out.println(data);
	       myReader.close();
	       System.loadLibrary("openbabel_java");
	       // Read molecule from SMILES string
	      OBConversion conv = new OBConversion();
	    OBMol mol = new OBMol();
	       conv.SetInFormat("mol");
	     
	     double  c = 3;
	      
	      
	 //    conv.AddOption("gen3D");
	     conv.AddOption("--gen3d");
	       conv.ReadString(mol, data);

	       // Print out some general information
	       conv.SetOutFormat("pdb");
	       
	       System.out.print("Canonical SMILES: " +
	         conv.WriteString(mol));
	       System.out.println("The molecular weight is "
	         + mol.GetMolWt());
	       for(OBAtom atom : new OBMolAtomIter(mol))
	           System.out.println("Atom " + atom.GetIdx()
	             + ": atomic number = " + atom.GetAtomicNum()
	             + ", hybridisation = " + atom.GetHyb());
	             


	     System.out.println();
	    
	 */ 
	 
	 
	 
	 
	 
	 
	
	 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyy/MM/dd HH:mm:ss"); 
	    LocalDateTime now = LocalDateTime.now();
	    String nowtime =  dtf.format(now);
	    SimpleDateFormat sdf = new SimpleDateFormat("yyy/MM/dd HH:mm:ss");
	    
	    String endTime = "2023/03/09 18:16:00";
   
	 //  **********************READ THIS ********************************* //
	  //mohammad khedmatgozar - @cellbox has witren this app
	 //please if u are decompile this app contact me...i will pay more :) - +989334499829 -+989151193112 - tel:@cellbox
	    
	    Date e = sdf.parse(endTime);
     Date n=  sdf.parse(nowtime);
     
  
    long elapsedend = n.getTime() -e.getTime();
	if (elapsedend<0) {
		//mohammad khedmatgozar - @cellbox has witren this app
		//please if u are decompile this app contact me...i will pay more :) - +989334499829 -+989151193112 - tel:@cellbox
		launch(args);
	}else {
		System.exit(0);
	}
		
		
		
			
		      
		        
		   
		
	
		  
		
	}
}
