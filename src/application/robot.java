package application;

/*
import java.net.URL;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.sikuli.script.FindFailed;

import org.sikuli.script.Pattern;
import io.appium.java_client.windows.WindowsDriver;
*/
public class robot  {
	/*
	private static WindowsDriver discoverySession = null;
	 private	Screen s=new Screen();
	@BeforeClass
	public  void setUp() {
		try {
			
			 Runtime rt = Runtime.getRuntime();
     		Process pr = rt.exec(
     				"cmd.exe /c start cmd.exe /K \"cd C:\\Program Files (x86)\\Windows Application Driver && WinAppDriver.exe\"");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("app",

					"C:\\moe_2019.0102\\bin\\moe.exe");
			capabilities.setCapability("platformName", "Windows");
			capabilities.setCapability("deviceName", "WindowsPC");
			discoverySession = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
			discoverySession.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void cleanApp() {
		discoverySession.quit();
		setUp();
	}

	@AfterSuite
	public  void tearDown() {
		discoverySession.quit();
	}


 

	@Test
	public  void doowork() throws FindFailed, InterruptedException {
		  String ss=System.getProperty("user.name");
		 String workplace ="C:\\Users\\"+ss+"\\AppData\\Local\\Packages\\CanonicalGroupLimited.UbuntuonWindows_79rhkp1fndgsc\\LocalState\\rootfs\\root\\Gromacs_Workplace";
		discoverySession.findElementByName("Maximize").click();
		 
		
		
			
		
		Pattern f0 = new Pattern("C:\\Users\\Cellbox\\Desktop\\" + "file.PNG");
		Pattern f01 = new Pattern("C:\\Users\\Cellbox\\Desktop\\" + "open.PNG");
		Pattern f1 = new Pattern("C:\\Users\\Cellbox\\Desktop\\" + "address.PNG");
		Pattern f1half = new Pattern("C:\\Users\\Cellbox\\Desktop\\" + "tik.PNG");
		Pattern f2 = new Pattern("C:\\Users\\Cellbox\\Desktop\\" + "enter file.PNG");
		Pattern f3 = new Pattern("C:\\Users\\Cellbox\\Desktop\\" + "ok.PNG");
		Pattern f4 = new Pattern("C:\\Users\\Cellbox\\Desktop\\" + "ok.PNG");

		Pattern f5 = new Pattern("C:\\Users\\Cellbox\\Desktop\\" + "compute.PNG");
		Pattern f6 = new Pattern("C:\\Users\\Cellbox\\Desktop\\" + "prepare.PNG");
		Pattern f7 = new Pattern("C:\\Users\\Cellbox\\Desktop\\" + "quiqprep.PNG");
		Pattern f8 = new Pattern("C:\\Users\\Cellbox\\Desktop\\" + "ok.PNG");
		Pattern f9 = new Pattern("C:\\Users\\Cellbox\\Desktop\\" + "yes quiq.PNG");
		Pattern f10 = new Pattern("C:\\Users\\Cellbox\\Desktop\\" + "file.PNG");
		Pattern f11 = new Pattern("C:\\Users\\Cellbox\\Desktop\\" + "save.PNG");

		Pattern f12 = new Pattern("C:\\Users\\Cellbox\\Desktop\\" + "back.PNG");
		Pattern f13 = new Pattern("C:\\Users\\Cellbox\\Desktop\\" + "address.PNG");
		Pattern f14 = new Pattern("C:\\Users\\Cellbox\\Desktop\\" + "tik.PNG");
		Pattern f15 = new Pattern("C:\\Users\\Cellbox\\Desktop\\" + "enter file.PNG");
		Pattern f16 = new Pattern("C:\\Users\\Cellbox\\Desktop\\" + "type.PNG");
		Pattern f17 = new Pattern("C:\\Users\\Cellbox\\Desktop\\" + "pdbtype.PNG");
		Pattern f170 = new Pattern("C:\\Users\\Cellbox\\Desktop\\" + "mol2type.PNG");
		Pattern f18 = new Pattern("C:\\Users\\Cellbox\\Desktop\\" + "ok.PNG");
		//Pattern f19 = new Pattern("C:\\Users\\Cellbox\\Desktop\\" + "yes quiq.PNG");
		Pattern f20 = new Pattern("C:\\Users\\Cellbox\\Desktop\\" + "close.PNG");

		Pattern fcheck = new Pattern("C:\\Users\\Cellbox\\Desktop\\" + "check2.png");
		Pattern fcheck2 = new Pattern("C:\\Users\\Cellbox\\Desktop\\" + "sidetike.PNG");

		s.click(f0);

		s.click(f01);
		s.click(f12);
		s.click(f12);
		s.click(f12);
		s.click(f12);
		s.click(f12);
		s.click(f12);
		s.click(f12);
		s.click(f12);
		s.click(f12);
		s.click(f12);
		s.click(f12);
		s.click(f12);
		s.click(f12);
		s.click(f12);
		s.click(f1);
	
	   
	while (true) {
			if (s.exists(fcheck2.exact()) != null) {

				break;
			}

		}
	s.doubleClick(fcheck2);
	Thread.sleep(1000);
		 

		s.type("C:\\Users\\Cellbox\\Desktop");
		s.click(f1half);
		s.click(f2);
		s.type("LIG.pdb");
		s.click(f3);
		s.exists(f4.exact());
		s.click(f4);

		Thread.sleep(1000);
		for (int i = 0; i < 30; i++) {
			s.wheel(-1, 1);
		}

		s.click(f5);

		s.click(f6);
		s.click(f7);
		s.click(f8);
		s.click(f9);

		Thread.sleep(2000);

		s.click(f10);

		s.click(f11);

		s.click(f12);
		s.click(f12);
		s.click(f12);
		s.click(f12);
		s.click(f12);
		s.click(f12);
		s.click(f12);
		s.click(f12);
		s.click(f12);
		s.click(f12);
		s.click(f12);
		s.click(f12);
		s.click(f12);
		s.click(f12);
		s.click(f1);
		
		
		while (true) {
				if (s.exists(fcheck2.exact()) != null) {

					break;
				}

			}
		s.doubleClick(fcheck2);
		Thread.sleep(1000);
			 

		s.type(workplace);
		s.click(f14);

		s.click(f15);
		s.type("LIG");
		s.click(f16);
		s.click(f17);
		s.click(f18);

	//	s.click(f19);
////////////////////////////////////////////////////////
		Thread.sleep(2000);
		s.click(f10);
		s.click(f11);
		s.click(f12);
		s.click(f12);
		s.click(f12);
		s.click(f12);
		s.click(f12);
		s.click(f12);
		s.click(f12);
		s.click(f12);
		s.click(f12);
		s.click(f12);
		s.click(f12);
		s.click(f12);
		s.click(f12);
		s.click(f12);
		s.click(f1);
		
		   
		while (true) {
				if (s.exists(fcheck2.exact()) != null) {

					break;
				}

			}
		s.doubleClick(fcheck2);
		Thread.sleep(1000);
		s.type(workplace);
		s.click(f14);

		s.click(f15);
		s.type("LIG");
		s.click(f16);
		s.click(f170);
		s.click(f18);

////////////////////////////////////////////////////////////////////////////
		s.click(f20);
		
		/*
		s.click(f0);

		s.click(f01);
		s.click(f12);
		s.click(f12);
		s.click(f12);
		s.click(f12);
		s.click(f12);
		s.click(f12);
		s.click(f12);
		s.click(f12);
		s.click(f12);
		s.click(f12);
		s.click(f12);
		s.click(f12);
		s.click(f12);
		s.click(f12);
		
		s.click(f1);
		
		Thread.sleep(2000);
		while (true) {
				if (s.exists(fcheck2.exact()) != null) {

					break;
				}

			}
		s.doubleClick(fcheck2);
		Thread.sleep(1000);

		s.type("C:\\Users\\Cellbox\\Desktop");
		s.click(f1half);
		s.click(f2);
		s.type("receptor.pdb");
		s.click(f3);
		s.exists(f4.exact());
		s.click(f4);

		Thread.sleep(1000);
		for (int i = 0; i < 30; i++) {
			s.wheel(-1, 1);
		}

		s.click(f5);

		s.click(f6);
		s.click(f7);
		s.click(f8);
		s.click(f9);
		Thread.sleep(2000);
		while (true) {
			if (s.exists(fcheck.exact()) != null) {

				break;
			}

		}

		Thread.sleep(2000);

		s.click(f10);

		s.click(f11);

		s.click(f12);
		s.click(f12);
		s.click(f12);
		s.click(f12);
		s.click(f12);
		s.click(f12);
		s.click(f12);
		s.click(f12);
		s.click(f12);
		s.click(f12);
		s.click(f12);
		s.click(f12);
		s.click(f12);
		s.click(f12);
		s.click(f1);
		
		   
		while (true) {
				if (s.exists(fcheck2.exact()) != null) {

					break;
				}

			}
		s.doubleClick(fcheck2);
		Thread.sleep(1000);
		s.type(workplace);
		s.click(f14);

		s.click(f15);
		s.type("receptor");
		s.click(f16);
		s.click(f17);
		s.click(f18);
		//s.click(f19);
	
		
		discoverySession.findElementByName("Close").click();
	*/
		
		
		

	
		
				      
				      
  

			
				  
				}

	


