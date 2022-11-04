package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class dowork extends Service<String> {
	ProcessBuilder telnetProcessBuilder;
	Process telnetProcess;
	BufferedReader input;
	BufferedWriter output;
  
	@Override
	protected Task<String> createTask() {

		return new Task<String>() {

			String total = "";
			public boolean command(ArrayList<String> arr) throws IOException {
				String commandInput = "";
				String linee = "";
				
				
				//ProcessBuilder telnetProcessBuilder = new ProcessBuilder("ubuntu);
				ProcessBuilder telnetProcessBuilder = new ProcessBuilder("ubuntu2004");
				System.out.println("call3");
				try {
					telnetProcessBuilder.redirectErrorStream(true);
					telnetProcess = telnetProcessBuilder.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				System.out.println("call4");
				input = new BufferedReader(new InputStreamReader(telnetProcess.getInputStream()));
				output = new BufferedWriter(new OutputStreamWriter(telnetProcess.getOutputStream()));
				commandInput = "sudo -i \n";
				output.write(commandInput);
				output.flush();
				System.out.println("call5");
				commandInput = "cd cellbox \n";
				output.write(commandInput);
				output.flush();
				commandInput = "cd Gromacs_Workplace \n";
				output.write(commandInput);
				output.flush();

				commandInput = "cd " + index_controller.i + " \n";
				output.write(commandInput);
				System.out.println("call6");
				
				output.flush();
			//commandInput = "export PATH=$PATH:/root/test4/gromacs/gromacs-2021.4/build/bin \n";
			//	commandInput = "export PATH=$PATH:/home/cellbox/gromacs/gromacs-2021.4/build/bin \n";
			//	commandInput = "export PATH=$PATH:/root/gromacs/gromacs-2021.4/build/bin \n";
				output.write(commandInput);
				output.flush();
				System.out.println("call7");
				for (int i = 0; i < arr.size(); i++) {
					switch (arr.get(i)) {
					case "gmx pdb2gmx -f receptor.pdb -o receptor_processed.gro -ignh":
						updateTitle("gmx pdb2gmx -f receptor.pdb -o receptor_processed.gro -ignh");
						break;
					case "gmx editconf -f LIG.pdb -o LIG.gro":
						updateTitle("gmx editconf -f LIG.pdb -o LIG.gro");
						break;
					case "gmx editconf -f complex.gro -o newbox.gro -c -d 1.0":
						updateTitle("gmx editconf -f complex.gro -o newbox.gro -c -d 1.0");
						break;
					case "gmx solvate -cp newbox.gro -cs spc216.gro -p topol.top -o solv.gro":
						updateTitle("gmx solvate -cp newbox.gro -cs spc216.gro -p topol.top -o solv.gro");
						break;
					case "gmx grompp -f ions.mdp -c solv.gro -p topol.top -o ions.tpr":
						updateTitle("gmx grompp -f ions.mdp -c solv.gro -p topol.top -o ions.tpr");
						break;
					case "gmx genion -s ions.tpr -o solv_ions.gro -p topol.top -pname NA -nname CL -neutral":
						updateTitle("gmx genion -s ions.tpr -o solv_ions.gro -p topol.top -pname NA -nname CL -neutral");
						break;
					case "gmx grompp -f em.mdp -c solv_ions.gro -p topol.top -o em.tpr":
						updateTitle("gmx grompp -f em.mdp -c solv_ions.gro -p topol.top -o em.tpr");
						break;
					case "gmx mdrun -v -deffnm em":
						updateTitle("gmx mdrun -v -deffnm em");
						break;
					case "gmx make_ndx -f LIG.gro -o index_LIG.ndx":
						updateTitle("gmx make_ndx -f LIG.gro -o index_LIG.ndx");
						break;
					case "gmx genrestr -f LIG.gro -n index_LIG.ndx -o posre_LIG.itp -fc 1000 1000 1000":
						updateTitle("gmx genrestr -f LIG.gro -n index_LIG.ndx -o posre_LIG.itp -fc 1000 1000 1000");
						break;
					case "gmx make_ndx -f em.gro -o index.ndx":
						updateTitle("gmx make_ndx -f em.gro -o index.ndx");
						break;
					case "gmx grompp -f nvt.mdp -c em.gro -r em.gro -p topol.top -n index.ndx -o nvt.tpr":
						updateTitle("gmx grompp -f nvt.mdp -c em.gro -r em.gro -p topol.top -n index.ndx -o nvt.tpr");
						break;
					case "gmx mdrun -v -deffnm nvt":
						updateTitle("gmx mdrun -v -deffnm nvt");
						break;
					case "gmx grompp -f npt.mdp -c nvt.gro -t nvt.cpt -r nvt.gro -p topol.top -n index.ndx -o npt.tpr":
						updateTitle("gmx grompp -f npt.mdp -c nvt.gro -t nvt.cpt -r nvt.gro -p topol.top -n index.ndx -o npt.tpr");
						break;
					case "gmx mdrun -v -deffnm npt":
						updateTitle("gmx mdrun -v -deffnm npt");
						break;
					case "gmx grompp -f md.mdp -c npt.gro -t npt.cpt -p topol.top -n index.ndx -o md_0_10.tpr":
						updateTitle("gmx grompp -f md.mdp -c npt.gro -t npt.cpt -p topol.top -n index.ndx -o md_0_10.tpr");
						break;
					case "gmx mdrun -v -deffnm md_0_10":
						updateTitle("gmx mdrun -v -deffnm md_0_10");
						break;

					default:
						break;
					}
					output.write(arr.get(i) + " \n");
					output.flush();
					System.out.println("call8");

				}
				commandInput = "exit \n";
				output.write(commandInput);
				output.flush();
				commandInput = "exit \n";
				output.write(commandInput);
				output.flush();
				commandInput = "exit \n";
				output.write(commandInput);
				output.flush();
				output.close();
				int rr = 0;
				while ((linee = input.readLine()) != null) {

					total += linee + "\n";

					if (linee.contains("Fatal") || linee.contains("Error")) {

						while (rr < 10 && !linee.equals(":-) GROMACS - gmx, 2021.4 (-:")) {
							rr++;
							if ((linee = input.readLine()) != null) {

								total += linee + "\n";
								updateMessage(total);

							}

						}
						cancel();
						return false;

					}

					updateMessage(total);

				}
				input.close();

				return true;
			}

			@Override
			protected String call() throws Exception {

				// r.setUp();
				// r.doowork();
				// r.tearDown();
				System.out.println("call");
				String total = "";
				ArrayList<String> arr = new ArrayList<String>();
                
				arr.add("gmx pdb2gmx -f receptor.pdb -o receptor_processed.gro -ignh");
				arr.add(index_controller.force_selected + 1 + "");
				arr.add(index_controller.water_selected + 1 + 1 + "");
				
				System.out.println("call1");
				if (!command(arr)) {
					return "";
				}
				System.out.println("call2");
				updateProgress(1,16);
                updateTitle("Add LIG.tip to topol.top");
				add_lig_itp_to_toplo();
				arr.clear();
				arr.add("gmx editconf -f LIG.pdb -o LIG.gro");
				if (!command(arr)) {
					return "";
				}
				System.out.println("call9");
				updateProgress(2,16);
				arr.clear();
				
				updateTitle("Make complex file");
				arr.add("cp receptor_processed.gro complex.gro");
				if (!command(arr)) {
					return "";
				}
				updateProgress(3,16);
				File file = new File(path() + "\\" + index_controller.i + "\\" + "complex.gro");
				make_complex();
				updateTitle("Connect swissparam website");
				swiss();
				File file1 = new File(path() + "\\" + index_controller.i + "\\" + "LIG.mol2");
				file1.delete();

				File file2 = new File(path() + "\\" + index_controller.i + "\\" + "LIG.pdb");
				file2.delete();
				arr.clear();
				updateTitle("unzip LIG.zip");
				arr.add("unzip LIG.zip");
			
				if (!command(arr)) {
					return "";
				}
				updateProgress(4,16);
				arr.clear();
				arr.add("gmx editconf -f complex.gro -o newbox.gro -c -d 1.0");
				arr.add("gmx solvate -cp newbox.gro -cs spc216.gro -p topol.top -o solv.gro");
				arr.add("gmx grompp -f ions.mdp -c solv.gro -p topol.top -o ions.tpr");
				arr.add("gmx genion -s ions.tpr -o solv_ions.gro -p topol.top -pname NA -nname CL -neutral");
				arr.add(index_controller.solvet_selected + "");
				if (!command(arr)) {
					return "";
				}
				updateProgress(5,16);
				updateTitle("Fix toplo numbers");
				fix_toplo_numbers();
				arr.clear();
				arr.add("gmx grompp -f em.mdp -c solv_ions.gro -p topol.top -o em.tpr");
				if (!command(arr)) {
					return "";
				}
				updateProgress(6,16);
				arr.clear();
				arr.add("gmx mdrun -v -deffnm em");
				if (!command(arr)) {
					return "";
				}
				updateProgress(7,16);
				arr.clear();
				arr.add("gmx make_ndx -f LIG.gro -o index_LIG.ndx");
				arr.add("0 & ! a H*");
				arr.add("q");
				if (!command(arr)) {
					return "";
				}
				updateProgress(8,16);
				arr.clear();
				arr.add("gmx genrestr -f LIG.gro -n index_LIG.ndx -o posre_LIG.itp -fc 1000 1000 1000");
				arr.add(3 + "");
				if (!command(arr)) {
					return "";
				}
				updateProgress(9,16);
				updateTitle("Add posre_LIG.itp to topol.top");
				add_posres();
				arr.clear();
				arr.add("gmx make_ndx -f em.gro -o index.ndx");
				arr.add("1 | 13");
				arr.add("q");
				if (!command(arr)) {
					return "";
				}
				updateProgress(10,16);
				arr.clear();
				arr.add("gmx grompp -f nvt.mdp -c em.gro -r em.gro -p topol.top -n index.ndx -o nvt.tpr");
				if (!command(arr)) {
					return "";
				}
				updateProgress(11,16);
				arr.clear();
				arr.add("gmx mdrun -v -deffnm nvt");
				if (!command(arr)) {
					return "";
				}
				updateProgress(12,16);
				arr.clear();
				arr.add("gmx grompp -f npt.mdp -c nvt.gro -t nvt.cpt -r nvt.gro -p topol.top -n index.ndx -o npt.tpr");
				if (!command(arr)) {
					return "";
				}
				updateProgress(13,16);
				arr.clear();
				arr.add("gmx mdrun -v -deffnm npt");
				if (!command(arr)) {
					return "";
				}
				updateProgress(14,16);
				arr.clear();
				arr.add("gmx grompp -f md.mdp -c npt.gro -t npt.cpt -p topol.top -n index.ndx -o md_0_10.tpr");
				if (!command(arr)) {
					return "";
				}
				updateProgress(15,16);
				arr.clear();
				arr.add("gmx mdrun -v -deffnm md_0_10  -nb gpu");
				if (!command(arr)) {
					return "";
				}
				
				updateProgress(16,16);
				return total.toString();
			}

		};

	}

	public void add_lig_itp_to_toplo() throws IOException, InterruptedException {

		File file = new File(path() + "\\" + index_controller.i + "\\" + "topol.top");
		File file1 = new File(path() + "\\" + index_controller.i + "\\" + "topol.top");
		while (!file.exists()) {
			Thread.sleep(100);
		}
		try {
			Scanner scanner = new Scanner(file);

			int lineNum = 0;

			StringBuilder s = new StringBuilder();
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();

				lineNum++;
				s.append(line + "\n");

				if (line.equals("#include \"./charmm36-mar2019.ff/forcefield.itp\"")) {

					s.append("\n; Include ligand topology\r\n" + "#include \"LIG.itp\"\n");
				}
			}
			s.append("LIG                 1\n");
			file.delete();
			BufferedWriter f_writer = new BufferedWriter(new FileWriter(file1));
			f_writer.write(s.toString());

			f_writer.close();
		} catch (FileNotFoundException e) {

		}
	}
	
	public String path() {
		 String ubuntu = null;
			
		 String username=System.getProperty("user.name");
			File fin=new File("C:\\Users\\"+username+"\\AppData\\Local\\Microsoft\\WindowsApps");
			File[] files = fin.listFiles(new FilenameFilter() {
				@Override
				public boolean accept(File dir, String name) {
					return name.endsWith("exe");
				}
			}); 
			
			for (int i = 0; i < files.length; i++) {
				if (files[i].getName().equals("ubuntu.exe")  ) {
					ubuntu="$\\Ubuntu";
				}else if (files[i].getName().equals("ubuntu2004.exe")  ) {
					ubuntu=".localhost\\Ubuntu-20.04";
					
				}
			}
			return "\\\\wsl"+ubuntu+"\\root\\cellbox\\Gromacs_Workplace";
	}
	public void make_complex() throws IOException {
		int totalline = 0;

		File file1 = new File(path() + "\\" + index_controller.i + "\\" + "LIG.gro");

		StringBuilder s1 = new StringBuilder();
		try {
			Scanner scanner = new Scanner(file1);

			int lineNum = 0;

			s1 = new StringBuilder();
			while (scanner.hasNextLine()) {

				String tline = scanner.nextLine();
				lineNum++;

				if (lineNum == 2) {
					lineNum = 0;

					int i = Integer.valueOf(tline.replaceAll("\\s+", ""));
					while (lineNum < i) {
						String line = scanner.nextLine();

						lineNum++;
						s1.append(line + "\n");

					}
					break;
				}
			}
			scanner.close();

			totalline += lineNum;
		} catch (FileNotFoundException e) {

		}

		File file2 = new File(path() + "\\" + index_controller.i + "\\" + "complex.gro");

		StringBuilder s2 = new StringBuilder();
		try {
			Scanner scanner2 = new Scanner(file2);
			int lineNum = 0;

			while (scanner2.hasNextLine()) {

				String tline = scanner2.nextLine();
				lineNum++;

				if (lineNum == 2) {
					int y = Integer.valueOf(tline.replaceAll("\\s+", ""));
					s2.append(" " + String.valueOf(y + totalline) + "\n");
					lineNum = 0;

					int i = Integer.valueOf(tline.replaceAll("\\s+", ""));
					while (lineNum <= i) {
						String line = scanner2.nextLine();

						if (lineNum == i) {

							s2.append(s1.toString());
						}
						lineNum++;

						s2.append(line + "\n");
					}
					break;
				} else {
					s2.append(tline + "\n");
				}
			}
		} catch (Exception e) {

		}

		file2.delete();
		File file3 = new File(path() + "\\" + index_controller.i + "\\" + "complex.gro");
		BufferedWriter f_writer = new BufferedWriter(new FileWriter(file3));
		f_writer.write(s2.toString());

		f_writer.close();

	}

	public void swiss() throws InterruptedException {
		// WebDriver driver = null;
		// WebDriverManager.chromedriver().browserVersion("98.0.4758.48").setup();
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--disable-extensions");
		// options.addArguments("--headless");
		// driver = new ChromeDriver(options);
		
		 String username=System.getProperty("user.name");
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);

		driver.get("https://www.swissparam.ch/");
		
		WebElement fileInput = driver.findElement(By.name("mol2Files"));
		fileInput.sendKeys(path() + "\\" + index_controller.i + "\\" + "LIG.mol2");
		driver.findElement(By.id("sib_action")).submit();

		driver.findElement(By.className("sib_link")).click();

		while (true) {
			Thread.sleep(1000);
			try {
				if (driver.findElement(By.linkText("LIG.zip")).isDisplayed()) {
					WebElement f = driver.findElement(By.linkText("LIG.zip"));

					StringBuilder sb = new StringBuilder(f.getAttribute("href"));
					sb.insert(4, "s");
					URL furl = new URL(sb.toString());

					FileUtils.copyURLToFile(furl, new File(path() + "\\" + index_controller.i + "\\" + "LIG.zip"));

					break;
				}
			} catch (Exception e) {

			}

		}

		driver.close();

	}

	public void fix_toplo_numbers() throws IOException {
		File file = new File(path() + "\\" + index_controller.i + "\\" + "topol.top");
		File file1 = new File(path() + "\\" + index_controller.i + "\\" + "topol.top");

		try {

			Scanner scanner = new Scanner(file);

			StringBuilder s = new StringBuilder();
			boolean a = false;
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();

				if (line.equals("; Compound        #mols") || a) {
					a = true;
					if (line.contains("LIG")) {
						line = "LIG " + (index_controller.lig_number_s);

					}
					String num = line.replaceAll("[^0-9]+", " ");
					num = num.trim();
					StringBuilder sinside = new StringBuilder();
					line = line.replaceAll("[0-9]", "");
					sinside.append(line);
					for (int i = 1; i <= 21 - num.length() - line.length(); i++) {
						sinside.append(" ");
					}
					sinside.append(num + "\n");
					s.append(sinside.toString());
				} else {
					s.append(line + "\n");
				}

			}

			file.delete();
			BufferedWriter f_writer = new BufferedWriter(new FileWriter(file1));
			f_writer.write(s.toString());

			f_writer.close();

		} catch (FileNotFoundException e) {

		}

	}

	public void add_posres() throws InterruptedException, IOException {
		File file = new File(path() + "\\" + index_controller.i + "\\" + "topol.top");
		File file1 = new File(path() + "\\" + index_controller.i + "\\" + "topol.top");
		File file2 = new File(path() + "\\" + index_controller.i + "\\" + "posre_LIG.itp");
		while (!file2.exists()) {
			Thread.sleep(100);
		}
		try {
			Scanner scanner = new Scanner(file);

			int lineNum = 0;

			StringBuilder s = new StringBuilder();
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();

				lineNum++;
				s.append(line + "\n");

				if (line.equals("#include \"LIG.itp\"")) {

					s.append("\n; Ligand position restraints\r\n" + "#ifdef POSRES\r\n"
							+ "#include \"posre_LIG.itp\"\r\n" + "#endif\n");
				}
			}

			file.delete();
			BufferedWriter f_writer = new BufferedWriter(new FileWriter(file1));
			f_writer.write(s.toString());

			f_writer.close();
		} catch (FileNotFoundException e) {

		}
	}
}
