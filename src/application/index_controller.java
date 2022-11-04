package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import java.util.ResourceBundle;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

import javafx.scene.control.ProgressIndicator;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import application.*;

public class index_controller {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;
	@FXML
	private Button but_load_config;
	@FXML
	private Button but_restart;
	@FXML
	private Label lig_mol2_address;

	@FXML
	private Label lig_pdb_address;

	@FXML
	private Label receptor_pdb_address;

	@FXML
	private Button but_delete_water_molcul;

	@FXML
	private Button but_hallal_box;

	@FXML
	private Button but_pdb_to_gro;

	@FXML
	private Button but_start;
	@FXML
	private Button but_temp_right;
	@FXML
	private Button but_chooser_Lig_mol2;

	@FXML
	private Button but_chooser_Lig_pdb;

	@FXML
	private Button but_chooser_receptor_pdb;
	@FXML
	private TextArea text_below_pane;
	@FXML
	private Button but_save;
	@FXML
	private TextField em_nstep;

	@FXML
	private CheckBox force_1;
	@FXML
	private Button but_resume;

	@FXML
	private CheckBox force_10;

	@FXML
	private CheckBox force_11;

	@FXML
	private CheckBox force_12;

	@FXML
	private CheckBox force_13;

	@FXML
	private CheckBox force_14;

	@FXML
	private CheckBox force_15;

	@FXML
	private CheckBox force_16;

	@FXML
	private CheckBox force_2;

	@FXML
	private CheckBox force_3;

	@FXML
	private CheckBox force_4;

	@FXML
	private CheckBox force_5;

	@FXML
	private CheckBox force_6;

	@FXML
	private CheckBox force_7;

	@FXML
	private CheckBox force_8;

	@FXML
	private CheckBox force_9;

	@FXML
	private TextField ions_nstep;

	@FXML
	private TextField ligand_number;

	@FXML
	private ProgressIndicator load;

	@FXML
	private TextField md_nstep;

	@FXML
	private TextField npt_nstep;

	@FXML
	private TextField nvt_nstep;
	@FXML
	private CheckBox solvent_0;

	@FXML
	private CheckBox solvent_1;

	@FXML
	private CheckBox solvent_10;

	@FXML
	private CheckBox solvent_11;

	@FXML
	private CheckBox solvent_12;

	@FXML
	private CheckBox solvent_13;

	@FXML
	private CheckBox solvent_14;

	@FXML
	private CheckBox solvent_15;

	@FXML
	private CheckBox solvent_16;

	@FXML
	private CheckBox solvent_2;

	@FXML
	private CheckBox solvent_3;

	@FXML
	private CheckBox solvent_4;

	@FXML
	private CheckBox solvent_5;

	@FXML
	private CheckBox solvent_6;

	@FXML
	private CheckBox solvent_7;

	@FXML
	private CheckBox solvent_8;

	@FXML
	private CheckBox solvent_9;
	@FXML
	private CheckBox water_1;

	@FXML
	private CheckBox water_2;

	@FXML
	private CheckBox water_3;

	@FXML
	private CheckBox water_4;

	@FXML
	private CheckBox water_5;

	@FXML
	private CheckBox water_6;

	@FXML
	private Button but_add;

	@FXML
	private Button but_ligand_folder;
	@FXML
	private Button but_receptor_file;
	@FXML
	private Label lig_folder_address;
	@FXML
	private TableColumn<address, String> ligand_column;
	@FXML
	private TableColumn<address, String> receptor_column;
	@FXML
	private TableView<address> table;
	@FXML
	private Label receptor_file_address;
	@FXML
	private TextField config_name;
	@FXML
	private Label notices;
	@FXML
	private CheckBox add_single;

	ArrayList<CheckBox> forces = new ArrayList<CheckBox>();
	ArrayList<CheckBox> waters = new ArrayList<CheckBox>();
	ArrayList<CheckBox> solvets = new ArrayList<CheckBox>();
	ArrayList<BufferedReader> inputs = new ArrayList<BufferedReader>();
	static int water_selected = -1;
	static int force_selected = -1;
	static int solvet_selected = -1;

	static int lig_number_s;

	static int i = 0;
	//////////////////////////////////////////

	String[] name_arr = new String[2];
	static String command_delete_water_molcul;
	static String command_pdb_to_gro;
	static String name_clean;
	static String name_process;
	static String lig_pdp_path;
	static String lig_mol2_path;
	static String receptor_pdp_path;
	dowork d = new dowork();
	ArrayList<address> addressses = new ArrayList<address>();

	boolean single = false;
	//////////////////////////////////////////

	@FXML
	void func_add_single(ActionEvent event) {
		if (!single) {
			but_chooser_Lig_mol2.setDisable(false);
			but_chooser_Lig_pdb.setDisable(false);
			but_chooser_receptor_pdb.setDisable(false);
			lig_mol2_address.setDisable(false);
			lig_pdb_address.setDisable(false);
			receptor_pdb_address.setDisable(false);
			single = true;
			but_ligand_folder.setDisable(true);
			but_receptor_file.setDisable(true);
			table.setDisable(true);
			but_add.setDisable(true);
			lig_folder_address.setDisable(true);
			receptor_file_address.setDisable(true);

		} else {
			but_chooser_Lig_mol2.setDisable(true);
			but_chooser_Lig_pdb.setDisable(true);
			but_chooser_receptor_pdb.setDisable(true);
			lig_mol2_address.setDisable(true);
			lig_pdb_address.setDisable(true);
			receptor_pdb_address.setDisable(true);
			single = false;
			but_ligand_folder.setDisable(false);
			but_receptor_file.setDisable(false);
			table.setDisable(false);
			but_add.setDisable(false);
			lig_folder_address.setDisable(false);
			receptor_file_address.setDisable(false);
		}

	}

	@FXML
	void func_add(ActionEvent event) {
		if (receptor_file_path != "" && ligand_folder_path != "") {

			addressses.add(new address(receptor_file.getName(), receptor_file.getPath(), ligand_folder_path));
			table.getItems().setAll(addressses);
			receptor_file_path = "";
			receptor_file = null;
			ligand_folder_path = "";
			lig_folder_address.setText("No Folder is selected");
			receptor_file_address.setText("No File is selected");
		}
	}

	@FXML
	void func_ligand_folder(ActionEvent event) {
		DirectoryChooser directoryChooser = new DirectoryChooser();
		directoryChooser.setTitle("Choose Folder of Ligands");
		File file = directoryChooser.showDialog(null);
		ligand_folder_path = file.getPath();
		lig_folder_address.setText(ligand_folder_path);
		if (ligand_folder_path == null) {

		} else {

		}

	}

	String receptor_file_path;
	File receptor_file;
	String ligand_folder_path;

	@FXML
	void func_receptor_file(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Choose Receptor");
		receptor_file = fileChooser.showOpenDialog(null);
		receptor_file_path = receptor_file.getPath();
		receptor_file_address.setText(receptor_file_path);
		System.out.println(lig_pdp_path);
	}

	@FXML
	void func_set_default(ActionEvent event) {
		solvent_15.setSelected(true);
		solvet_selected = 14;
		water_4.setSelected(true);
		water_selected = 3;
		force_1.setSelected(true);
		force_selected = 0;
		ions_nstep.setText("50");
		em_nstep.setText("50");
		md_nstep.setText("50");
		nvt_nstep.setText("50");
		npt_nstep.setText("50");
		ligand_number.setText("1");
		// receptor_file_address.setText("C:\\Users\\Cellbox\\Desktop\\receptor.pdb");
		// lig_folder_address.setText("C:\\Users\\Cellbox\\Desktop\\ligs");
		// ligand_folder_path = "C:\\Users\\Cellbox\\Desktop\\ligs";
		// receptor_file_path = "C:\\Users\\Cellbox\\Desktop\\receptor.pdb";
		// receptor_file = new File("C:\\Users\\Cellbox\\Desktop\\receptor.pdb");

	}

	@FXML
	void func_chooser_Lig_pdb(ActionEvent event) throws InterruptedException, IOException {

		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Choose Ligand with pdb Format");
		File file = fileChooser.showOpenDialog(null);
		lig_pdp_path = file.getPath();
		lig_pdb_address.setText(lig_pdp_path);
		System.out.println(lig_pdp_path);

	}

	@FXML
	void func_chooser_Lig_mol2(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Choose Ligand with Mol2 Format");
		File file = fileChooser.showOpenDialog(null);
		lig_mol2_path = file.getPath();
		lig_mol2_address.setText(lig_mol2_path);
	}

	@FXML
	void func_chooser_receptor_pdb(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Choose Receptor with pdb Format");
		File file = fileChooser.showOpenDialog(null);
		receptor_pdp_path = file.getPath();
		receptor_pdb_address.setText(receptor_pdp_path);
	}

	public String path() {
		String ubuntu = null;

		String username = System.getProperty("user.name");
		File fin = new File("C:\\Users\\" + username + "\\AppData\\Local\\Microsoft\\WindowsApps");
		File[] files = fin.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith("exe");
			}
		});

		for (int i = 0; i < files.length; i++) {
			if (files[i].getName().equals("ubuntu.exe")) {
				ubuntu = "$\\Ubuntu";
			} else if (files[i].getName().equals("ubuntu2004.exe")) {
				ubuntu = ".localhost\\Ubuntu-20.04";
			}
		}
		return "\\\\wsl" + ubuntu + "\\root\\cellbox\\Gromacs_Workplace";
	}
public void charms(String name ,File f) {
	 try { InputStream input = getClass().getResourceAsStream("charmm36-mar2019.ff/"+name);
     OutputStream out = new FileOutputStream(f);
     int read;
     byte[] bytes = new byte[1024];
     while ((read = input.read(bytes)) != -1) {
         out.write(bytes, 0, read);
     }
     out.close();
 } catch (IOException ex) {     }
}
	public void make_workplace() throws InterruptedException, IOException, URISyntaxException {
		//String path = this.getClass().getClassLoader().getResource("ions.mdp").toExternalForm();
	//	File ions_s = new File(path);
		
	/*URL em_url = Main.class.getResource("em.mdp");
		URL md_url = Main.class.getResource("md.mdp");
		URL npt_url = Main.class.getResource("npt.mdp");
		URL nvt_url = Main.class.getResource("nvt.mdp");
		URL charm_url = Main.class.getResource("charmm36-mar2019.ff");
		File ions_s = new File(ions_url.toURI());
		File em_s = new File(em_url.toURI());
		File md_s = new File(md_url.toURI());
		File npt_s = new File(npt_url.toURI());
		File nvt_s = new File(nvt_url.toURI());

		File charm_s = new File(charm_url.toURI());*/
		
		
		
	
		while (true) {
			i++;
			Path a = Paths.get(path() + "\\" + i);
			;

			if (!Files.exists(a)) {
				break;
			}

		}
		File selected_lig_pdb = new File(lig_pdp_path);
		File selected_lig_mol2 = new File(lig_mol2_path);
		File selected_receptor = new File(receptor_pdp_path);
		new File("\\" + path() + "\\" + i).mkdirs();
		File lig_pdb = new File(path() + "\\" + i + "\\" + "LIG.pdb");
		File lig_mol2 = new File(path() + "\\" + i + "\\" + "LIG.mol2");
		File recceptor_pdb = new File(path() + "\\" + i + "\\" + "receptor.pdb");
		File ions_d = new File(path() + "\\" + i + "\\" + "ions.mdp");
		File em_d = new File(path() + "\\" + i + "\\" + "em.mdp");
		File md_d = new File(path() + "\\" + i + "\\" + "md.mdp");
		File npt_d = new File(path() + "\\" + i + "\\" + "npt.mdp");
		File nvt_d = new File(path() + "\\" + i + "\\" + "nvt.mdp");
		boolean f=	new File("/"+path() + "\\" + i + "\\" + "charmm36-mar2019.ff").mkdirs();
		File atomtypes_atp = new File(path() + "\\" + i + "\\" + "charmm36-mar2019.ff/atomtypes.atp");
		File cmap_itp = new File(path() + "\\" + i + "\\" + "charmm36-mar2019.ff/cmap.itp");
		charms("cmap.itp", cmap_itp);
		File ffbonded_itp = new File(path() + "\\" + i + "\\" + "charmm36-mar2019.ff/ffbonded.itp");
		charms("ffbonded.itp", ffbonded_itp);
		File ffnonbonded_itp = new File(path() + "\\" + i + "\\" + "charmm36-mar2019.ff/ffnonbonded.itp");
		charms("ffnonbonded.itp", ffnonbonded_itp);
		File forcefield_doc = new File(path() + "\\" + i + "\\" + "charmm36-mar2019.ff/forcefield.doc");
		charms("forcefield.doc", forcefield_doc);
		File forcefield_itp = new File(path() + "\\" + i + "\\" + "charmm36-mar2019.ff/forcefield.itp");
		charms("forcefield.itp", forcefield_itp);
		File gb_itp = new File(path() + "\\" + i + "\\" + "charmm36-mar2019.ff/gb.itp");
		charms("gb.itp", gb_itp);
		File ions_itp = new File(path() + "\\" + i + "\\" + "charmm36-mar2019.ff/ions.itp");
		charms("ions.itp", ions_itp);
		File merged_arn = new File(path() + "\\" + i + "\\" + "charmm36-mar2019.ff/merged.arn");
		charms("merged.arn", merged_arn);
		File merged_c_tdb = new File(path() + "\\" + i + "\\" + "charmm36-mar2019.ff/merged.c.tdb");
		charms("merged.c.tdb", merged_c_tdb);
		File merged_hdb = new File(path() + "\\" + i + "\\" + "charmm36-mar2019.ff/merged.hdb");
		charms("merged.hdb", merged_hdb);
		File merged_n_tdb = new File(path() + "\\" + i + "\\" + "charmm36-mar2019.ff/merged.n.tdb");
		charms("merged.n.tdb", merged_n_tdb);
		File merged_r2b = new File(path() + "\\" + i + "\\" + "charmm36-mar2019.ff/merged.r2b");
		charms("merged.r2b", merged_r2b);
		File merged_rtp = new File(path() + "\\" + i + "\\" + "charmm36-mar2019.ff/merged.rtp");
		charms("merged.rtp",merged_rtp);
		File merged_vsd = new File(path() + "\\" + i + "\\" + "charmm36-mar2019.ff/merged.vsd");
		charms("merged.vsd", merged_vsd);
		File nbfix_itp = new File(path() + "\\" + i + "\\" + "charmm36-mar2019.ff/nbfix.itp");
		charms("nbfix.itp",nbfix_itp);
		File old_c36_cmap_itp = new File(path() + "\\" + i + "\\" + "charmm36-mar2019.ff/old_c36_cmap.itp");
		charms("old_c36_cmap.itp", old_c36_cmap_itp);
		File spc_itp = new File(path() + "\\" + i + "\\" + "charmm36-mar2019.ff/spc.itp");
		charms("spc.itp", spc_itp);
		File spce_itp = new File(path() + "\\" + i + "\\" + "charmm36-mar2019.ff/spce.itp");
		charms("spce.itp", spce_itp);
		File tip3p_itp = new File(path() + "\\" + i + "\\" + "charmm36-mar2019.ff/tip3p.itp");
		charms("tip3p.itp", tip3p_itp);
		File tip4p_itp = new File(path() + "\\" + i + "\\" + "charmm36-mar2019.ff/tip4p.itp");
		charms("tip4p.itp", tip4p_itp);
		File watermodels_dat = new File(path() + "\\" + i + "\\" + "charmm36-mar2019.ff/watermodels.dat");
		charms("watermodels.dat", watermodels_dat);
		FileUtils.copyFile(selected_lig_pdb, lig_pdb);
		FileUtils.copyFile(selected_lig_mol2, lig_mol2);
		FileUtils.copyFile(selected_receptor, recceptor_pdb);
		 try { InputStream input = getClass().getResourceAsStream("ions.mdp");
		        OutputStream out = new FileOutputStream(ions_d);
		        int read;
		        byte[] bytes = new byte[1024];
		        while ((read = input.read(bytes)) != -1) {
		            out.write(bytes, 0, read);
		        }
		        out.close();
		    } catch (IOException ex) {     }
		 try { InputStream input = getClass().getResourceAsStream("em.mdp");
	        OutputStream out = new FileOutputStream(em_d);
	        int read;
	        byte[] bytes = new byte[1024];
	        while ((read = input.read(bytes)) != -1) {
	            out.write(bytes, 0, read);
	        }
	        out.close();
	    } catch (IOException ex) {     }
		 try { InputStream input = getClass().getResourceAsStream("npt.mdp");
	        OutputStream out = new FileOutputStream(npt_d);
	        int read;
	        byte[] bytes = new byte[1024];
	        while ((read = input.read(bytes)) != -1) {
	            out.write(bytes, 0, read);
	        }
	        out.close();
	    } catch (IOException ex) {     }
		 try { InputStream input = getClass().getResourceAsStream("nvt.mdp");
	        OutputStream out = new FileOutputStream(nvt_d);
	        int read;
	        byte[] bytes = new byte[1024];
	        while ((read = input.read(bytes)) != -1) {
	            out.write(bytes, 0, read);
	        }
	        out.close();
	    } catch (IOException ex) {     }
		 try { InputStream input = getClass().getResourceAsStream("md.mdp");
	        OutputStream out = new FileOutputStream(md_d);
	        int read;
	        byte[] bytes = new byte[1024];
	        while ((read = input.read(bytes)) != -1) {
	            out.write(bytes, 0, read);
	        }
	        out.close();
	    } catch (IOException ex) {     }
		 try { InputStream input = getClass().getResourceAsStream("charmm36-mar2019.ff/atomtypes.atp");
	        OutputStream out = new FileOutputStream(atomtypes_atp);
	        int read;
	        byte[] bytes = new byte[1024];
	        while ((read = input.read(bytes)) != -1) {
	            out.write(bytes, 0, read);
	        }
	        out.close();
	    } catch (IOException ex) {     }
		
	/*	FileUtils.copyFile(ions_s, ions_d);
		FileUtils.copyFile(em_s, em_d);
		FileUtils.copyFile(md_s, md_d);
		FileUtils.copyFile(nvt_s, nvt_d);
		FileUtils.copyFile(npt_s, npt_d);
		FileUtils.copyDirectory(charm_s, charm_d);*/
		File files_info = new File(path() + "\\" + i + "\\" + "info.txt");
		BufferedWriter f_writer = new BufferedWriter(new FileWriter(files_info));
		String s = "pdb ligand from: " + selected_lig_pdb + "\n" + "mol2 ligand from: " + selected_lig_mol2 + "\n"
				+ "receptor from: " + selected_receptor + "\n";
		f_writer.write(s);

		f_writer.close();
	}

	Alert a = new Alert(AlertType.WARNING);

	public boolean check_congifs() {

		boolean c = true;
		String wars = null;

		if (ions_nstep.getText().trim().isEmpty()) {
			wars = "Pleas fill ions nstep field\n";
			c = false;

		}
		if (em_nstep.getText().trim().isEmpty()) {
			wars += "Pleas fill em nstep field\n";
			c = false;

		}
		if (nvt_nstep.getText().trim().isEmpty()) {
			wars += "Pleas fill nvt nstep field\n";
			c = false;

		}
		if (npt_nstep.getText().trim().isEmpty()) {
			wars += "Pleas fill npt nstep field\n";
			c = false;

		}
		if (md_nstep.getText().trim().isEmpty()) {
			wars += "Pleas fill md nstep field\n";
			c = false;

		}
		if (!c) {

			a.setHeaderText(wars);
			a.show();
			System.out.println("dddddd");
			return false;
		} else {
			System.out.println("vvvvvv");
			return true;
		}

	}

	@FXML
	void func_start(ActionEvent event) throws InterruptedException, IOException, URISyntaxException {
		boolean c = check_congifs();

		if (single) {

			if (lig_pdp_path != null && lig_mol2_path != null && receptor_pdp_path != null && c) {

				make_workplace();
				set_nstep_ions();
				set_nstep_em();
				set_nstep_md();
				set_nstep_nvt();
				set_nstep_npt();
				func_solvent(event);
				
				func_water(event);
				
				func_force(event);
				
				set_lig_number();
				
				notices.textProperty().bind(d.titleProperty());
				load.setPrefWidth(147);

				load.progressProperty().bind(d.progressProperty());
				text_below_pane.textProperty().bind(d.messageProperty());
				lig_number_s = Integer.valueOf(ligand_number.getText());
				
				d.setOnRunning(e -> {

					but_start.setStyle("-fx-background-color:#c2b513 ; ");
					but_start.setText("Processing");

				});
				d.setOnCancelled(e -> {

					but_start.setStyle("-fx-background-color: #e23a24 ; ");
					but_start.setText("Faild");
					but_start.styleProperty().unbind();
					but_start.textProperty().unbind();
					load.progressProperty().unbind();
					text_below_pane.textProperty().unbind();
					BufferedWriter f_writer;
					try {
						File logs = new File(path() + "\\" + i + "\\" + "logs.txt");
						f_writer = new BufferedWriter(new FileWriter(logs));
						f_writer.write(text_below_pane.getText());

						f_writer.close();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}

				});
				d.setOnFailed(e -> {

					but_start.setStyle("-fx-background-color: #e23a24 ; ");
					but_start.setText("Faild");
					but_start.styleProperty().unbind();
					but_start.textProperty().unbind();
					load.progressProperty().unbind();
					text_below_pane.textProperty().unbind();
					BufferedWriter f_writer;
					try {
						File logs = new File(path() + "\\" + i + "\\" + "logs.txt");
						f_writer = new BufferedWriter(new FileWriter(logs));
						f_writer.write(text_below_pane.getText());

						f_writer.close();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}

				});
				d.setOnSucceeded(e -> {

					but_start.setStyle("-fx-background-color: #16b85d  ; ");
					but_start.setText("");
					but_start.styleProperty().unbind();
					but_start.textProperty().unbind();
					load.progressProperty().unbind();
					text_below_pane.textProperty().unbind();
					BufferedWriter f_writer;
					try {
						File logs = new File(path() + "\\" + i + "\\" + "logs.txt");
						f_writer = new BufferedWriter(new FileWriter(logs));
						f_writer.write(text_below_pane.getText());

						f_writer.close();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}

				});

//   text_below_pane.scrollTopProperty().addListener((obs, oldVal, newVal) -> 
//System.out.println("Position from top: " + newVal));
				d.messageProperty().addListener((observable, oldValue, newValue) -> {

					text_below_pane.selectPositionCaret(text_below_pane.getLength());

					text_below_pane.deselect();

				});

				d.start();
			} else {
				but_start.setText("Faild");

				but_start.setStyle("-fx-background-color: #e23a24  ; ");
			}
		} else {

			if (g < addressses.size()) {

				File ligands = new File(addressses.get(g).getLigands_path());

				File[] mol2files = ligands.listFiles(new FilenameFilter() {
					@Override
					public boolean accept(File dir, String name) {
						return name.endsWith("mol2");
					}
				});
				File[] pdbfiles = ligands.listFiles(new FilenameFilter() {
					@Override
					public boolean accept(File dir, String name) {
						return name.endsWith("pdb");
					}
				});

				if (h < mol2files.length) {
					// try {
					lig_mol2_path = mol2files[h].getPath();
					lig_pdp_path = pdbfiles[h].getPath();
					receptor_pdp_path = addressses.get(g).getReceptor_path();
					System.out.println(lig_mol2_path);
					System.out.println("h= " + h);
					System.out.println(lig_pdp_path);
					System.out.println(receptor_pdp_path);

					if (lig_pdp_path != null || lig_mol2_path != null || receptor_pdp_path != null) {

						make_workplace();
						set_nstep_ions();
						set_nstep_em();
						set_nstep_md();
						set_nstep_nvt();
						set_nstep_npt();
						func_solvent(event);
						func_water(event);
						func_force(event);
						set_lig_number();
						notices.textProperty().bind(d.titleProperty());
						load.setPrefWidth(147);

						load.progressProperty().bind(d.progressProperty());
						text_below_pane.textProperty().bind(d.messageProperty());
						lig_number_s = Integer.valueOf(ligand_number.getText());

						d.setOnRunning(e -> {

							but_start.setStyle("-fx-background-color:#c2b513 ; ");
							but_start.setText("Processing");

						});
						d.setOnCancelled(e -> {

							but_start.setStyle("-fx-background-color: #e23a24 ; ");
							but_start.setText("Faild");
							but_start.styleProperty().unbind();
							but_start.textProperty().unbind();
							load.progressProperty().unbind();
							text_below_pane.textProperty().unbind();
							lig_mol2_path = "";
							lig_pdp_path = "";
							receptor_pdp_path = "";
							BufferedWriter f_writer;
							try {
								File logs = new File(path() + "\\" + i + "\\" + "logs.txt");
								f_writer = new BufferedWriter(new FileWriter(logs));
								f_writer.write(text_below_pane.getText());

								f_writer.close();
							} catch (IOException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							try {
								h++;

								func_restart(event);
								func_start(event);

							} catch (InterruptedException | IOException e1) {

							} catch (URISyntaxException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

						});
						d.setOnFailed(e -> {

							but_start.setStyle("-fx-background-color: #e23a24 ; ");
							but_start.setText("Faild");
							but_start.styleProperty().unbind();
							but_start.textProperty().unbind();
							load.progressProperty().unbind();
							text_below_pane.textProperty().unbind();
							lig_mol2_path = "";
							lig_pdp_path = "";
							receptor_pdp_path = "";
							BufferedWriter f_writer;
							try {
								File logs = new File(path() + "\\" + i + "\\" + "logs.txt");
								f_writer = new BufferedWriter(new FileWriter(logs));
								f_writer.write(text_below_pane.getText());

								f_writer.close();
							} catch (IOException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							try {
								h++;

								func_restart(event);
								func_start(event);

							} catch (InterruptedException | IOException e1) {

							} catch (URISyntaxException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

						});
						d.setOnSucceeded(e -> {

							but_start.setStyle("-fx-background-color: #16b85d  ; ");
							but_start.setText("");
							but_start.styleProperty().unbind();
							but_start.textProperty().unbind();
							load.progressProperty().unbind();
							text_below_pane.textProperty().unbind();
							lig_mol2_path = "";
							lig_pdp_path = "";
							receptor_pdp_path = "";
							System.out.println(i);
							BufferedWriter f_writer;
							try {

								File logs = new File(path() + "\\" + i + "\\" + "logs.txt");
								f_writer = new BufferedWriter(new FileWriter(logs));
								f_writer.write(text_below_pane.getText());
								f_writer.close();

							} catch (IOException e2) {

								e2.printStackTrace();
							}

							try {
								h++;

								func_restart(event);
								func_start(event);

							} catch (InterruptedException | IOException e1) {

							} catch (URISyntaxException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

						});

						// text_below_pane.scrollTopProperty().addListener((obs, oldVal, newVal) ->
						// System.out.println("Position from top: " + newVal));
						d.messageProperty().addListener((observable, oldValue, newValue) -> {

							text_below_pane.selectPositionCaret(text_below_pane.getLength());

							text_below_pane.deselect();

						});

						d.start();

					}

				} else {
					try {
						g++;
						h = 0;
						// func_restart(event);
						func_start(event);

					} catch (InterruptedException | IOException e1) {

					}

				}

			} else {
				if (addressses.size() == 0) {
					but_start.setText("Faild");

					but_start.setStyle("-fx-background-color: #e23a24  ; ");
				} else {

					but_start.setStyle("-fx-background-color: #16b85d  ; ");
					but_start.setText("Finished");
					but_start.styleProperty().unbind();
					but_start.textProperty().unbind();
					load.progressProperty().unbind();
					text_below_pane.textProperty().unbind();
					lig_mol2_path = "";
					lig_pdp_path = "";
					receptor_pdp_path = "";
					h = 0;
					g = 0;
				}
			}
		}
		// }
		// }

	}

	int h = 0;
	int g = 0;

	private void set_lig_number() {
		lig_number_s = Integer.valueOf(ligand_number.getText());

	}

	@FXML
	void func_save(ActionEvent event) throws InterruptedException, IOException {
		if (config_name.getText().equals("")) {
			a.setContentText("First enter a name for configuration file");
			a.show();
		} else {

			String username = System.getProperty("user.name");
			new File("/" + "C:\\Users\\" + username + "\\Documents\\Gromacs_configuration").mkdirs();

			File file = new File(
					"C:\\Users\\" + username + "\\Documents\\Gromacs_configuration\\" + config_name.getText() + ".txt");

			try {

				StringBuilder s = new StringBuilder();

				s.append("ions_nstep: " + ions_nstep.getText() + " \n");
				s.append("em_nstep: " + em_nstep.getText() + " \n");
				s.append("nvt_nstep: " + nvt_nstep.getText() + " \n");
				s.append("npt_nstep: " + npt_nstep.getText() + " \n");
				s.append("md_nstep: " + md_nstep.getText() + " \n");
				s.append("ligand_number: " + ligand_number.getText() + " \n");
				s.append("force: " + force_selected + " ; this field must plus one in real terminal \n");
				s.append("water: " + water_selected + " ; this field must plus one in real terminal \n");
				s.append("solvent: " + solvet_selected + " ; this field must plus one in real terminal \n");

				BufferedWriter f_writer = new BufferedWriter(new FileWriter(file));
				f_writer.write(s.toString());

				f_writer.close();
				while (!file.exists()) {
					Thread.sleep(100);
				}
			} catch (FileNotFoundException e) {

			}
		}
	}

	@FXML
	void func_load_config(ActionEvent event) throws FileNotFoundException {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Choose Load configuration");
		File file = fileChooser.showOpenDialog(null);
		Scanner scanner = new Scanner(file);
		int r = 0;
		String[] arr = new String[9];
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();

			String num = line.replaceAll("[^0-9]+", " ");
			num = num.trim();
			arr[r] = num;
			r++;
		}
		ions_nstep.setText(arr[0]);
		em_nstep.setText(arr[1]);
		nvt_nstep.setText(arr[2]);
		npt_nstep.setText(arr[3]);
		md_nstep.setText(arr[4]);
		ligand_number.setText(arr[5]);
		forces.get(Integer.valueOf(arr[6])).setSelected(true);
		waters.get(Integer.valueOf(arr[7])).setSelected(true);
		solvets.get(Integer.valueOf(arr[8])).setSelected(true);
		func_force(event);
		func_water(event);
		func_solvent(event);

	}

	@FXML
	void func_restart(ActionEvent event) throws IOException {

		try {
			d.input.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			d.cancel();

		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			d.reset();
		} catch (Exception e) {
			// TODO: handle exception
		}

		text_below_pane.textProperty().unbind();
		but_start.styleProperty().unbind();
		but_start.textProperty().unbind();
		load.progressProperty().unbind();
		load.setProgress(0);
		load.setPrefWidth(0);
		but_start.setText("Start");
		but_start.setStyle("-fx-background-color:  #121c8e ; ");
		text_below_pane.setText("");
		// notices.setText("Program Not started yet");

		System.out.println("Restarting app!");

	}

	private void set_nstep_npt() throws IOException, InterruptedException {
		File file = new File(path() + "\\" + i + "\\" + "npt.mdp");
		File file1 = new File(path() + "\\" + i + "\\" + "npt.mdp");
		while (!file.exists()) {
			Thread.sleep(100);
		}
		try {
			Scanner scanner = new Scanner(file);

			StringBuilder s = new StringBuilder();
			boolean a = false;
			int i = 0;
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();

				if (line.contains("nsteps")) {

					s.append("nsteps                  = " + npt_nstep.getText()
							+ "       ; 2 * 5000000 = 10000 ps (10 ns)\n");
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

	@FXML
	void func_force(ActionEvent event) {
		int i = 0;
		if (force_selected == -1) {

			for (int j = 0; j < forces.size(); j++) {
				if (forces.get(j).isSelected()) {
					force_selected = j;
					System.out.println("f0000000");
				}
			}
		} else {

			for (int j = 0; j < forces.size(); j++) {
				if (forces.get(j).isSelected() && j != force_selected) {
					forces.get(force_selected).setSelected(false);
					force_selected = j;

					System.out.println("f11111111111");
				}
			}
		}

	}

	@FXML
	void func_water(ActionEvent event) {
		int i = 0;
	
		if (water_selected == -1) {
			
			for (int j = 0; j < waters.size(); j++) {
				if (waters.get(j).isSelected()) {
					water_selected = j;
					System.out.println("w0000000");
				}
			}
		} else {
		
			
			for (int j = 0; j < waters.size(); j++) {
				System.out.println(waters.get(j).isSelected()+" j="+j+" waterselected="+water_selected);
				if (waters.get(j).isSelected() && j != water_selected) {
					waters.get(water_selected).setSelected(false);
					water_selected = j;

					System.out.println("w11111111111");
				}
			}
		}

	}

	@FXML
	void func_solvent(ActionEvent event) {
		int i = 0;
		if (solvet_selected == -1) {

			for (int j = 0; j < solvets.size(); j++) {
				if (solvets.get(j).isSelected()) {
					solvet_selected = j;
					System.out.println("s0000000");
				}
			}
		} else {

			for (int j = 0; j < solvets.size(); j++) {
				if (solvets.get(j).isSelected() && j != solvet_selected) {
					solvets.get(solvet_selected).setSelected(false);
					solvet_selected = j;

					System.out.println("s11111111111");
				}
			}
		}

	}

	private void set_nstep_nvt() throws IOException, InterruptedException {
		File file = new File(path() + "\\" + i + "\\" + "nvt.mdp");
		File file1 = new File(path() + "\\" + i + "\\" + "nvt.mdp");
		while (!file.exists()) {
			Thread.sleep(100);
		}
		try {
			Scanner scanner = new Scanner(file);

			StringBuilder s = new StringBuilder();
			boolean a = false;
			int i = 0;
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();

				if (line.contains("nsteps")) {

					s.append("nsteps                  = " + nvt_nstep.getText()
							+ "       ; 2 * 5000000 = 10000 ps (10 ns)\n");
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

	private void set_nstep_md() throws IOException, InterruptedException {
		File file = new File(path() + "\\" + i + "\\" + "md.mdp");
		File file1 = new File(path() + "\\" + i + "\\" + "md.mdp");
		while (!file.exists()) {
			Thread.sleep(100);
		}
		try {
			Scanner scanner = new Scanner(file);

			StringBuilder s = new StringBuilder();
			boolean a = false;
			int i = 0;
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();

				if (line.contains("nsteps")) {

					s.append("nsteps                  = " + md_nstep.getText()
							+ "       ; 2 * 5000000 = 10000 ps (10 ns)\n");
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

	private void set_nstep_em() throws IOException, InterruptedException {

		File file = new File(path() + "\\" + i + "\\" + "em.mdp");
		File file1 = new File(path() + "\\" + i + "\\" + "em.mdp");
		while (!file.exists()) {
			Thread.sleep(100);
		}
		try {
			Scanner scanner = new Scanner(file);

			StringBuilder s = new StringBuilder();
			boolean a = false;
			int i = 0;
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();

				if (line.contains("nsteps")) {

					s.append("nsteps		    = " + em_nstep.getText()
							+ "	  	; Maximum number of (minimization) steps to perform\n");
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

	public void set_nstep_ions() throws InterruptedException, IOException {

		File file = new File(path() + "\\" + i + "\\" + "ions.mdp");
		File file1 = new File(path() + "\\" + i + "\\" + "ions.mdp");
		while (!file.exists()) {
			Thread.sleep(100);
		}
		try {
			Scanner scanner = new Scanner(file);

			StringBuilder s = new StringBuilder();
			boolean a = false;
			int i = 0;
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();

				if (line.contains("nsteps")) {

					s.append("nsteps		    = " + ions_nstep.getText()
							+ "	  	; Maximum number of (minimization) steps to perform\n");
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

	@FXML
	void initialize() {
		load.setPrefWidth(0);
		forces.add(force_1);
		forces.add(force_2);
		forces.add(force_3);
		forces.add(force_4);
		forces.add(force_5);
		forces.add(force_6);
		forces.add(force_7);
		forces.add(force_8);
		forces.add(force_9);
		forces.add(force_10);
		forces.add(force_11);
		forces.add(force_12);
		forces.add(force_13);
		forces.add(force_14);
		forces.add(force_15);
		forces.add(force_16);
		waters.add(water_1);
		waters.add(water_2);
		waters.add(water_3);
		waters.add(water_4);
		waters.add(water_5);
		waters.add(water_6);
		solvets.add(solvent_0);
		solvets.add(solvent_1);
		solvets.add(solvent_2);
		solvets.add(solvent_3);
		solvets.add(solvent_4);
		solvets.add(solvent_5);
		solvets.add(solvent_6);
		solvets.add(solvent_7);
		solvets.add(solvent_8);
		solvets.add(solvent_9);
		solvets.add(solvent_10);
		solvets.add(solvent_11);
		solvets.add(solvent_12);
		solvets.add(solvent_13);
		solvets.add(solvent_14);
		solvets.add(solvent_15);
		solvets.add(solvent_16);

		ions_nstep.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*")) {
					ions_nstep.setText(newValue.replaceAll("[^\\d]", ""));
				}
			}
		});
		em_nstep.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*")) {
					em_nstep.setText(newValue.replaceAll("[^\\d]", ""));
				}
			}
		});
		nvt_nstep.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*")) {
					nvt_nstep.setText(newValue.replaceAll("[^\\d]", ""));
				}
			}
		});
		npt_nstep.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*")) {
					npt_nstep.setText(newValue.replaceAll("[^\\d]", ""));
				}
			}
		});
		md_nstep.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*")) {
					md_nstep.setText(newValue.replaceAll("[^\\d]", ""));
				}
			}
		});
		ligand_column.setCellValueFactory(new PropertyValueFactory<address, String>("ligands_path"));
		receptor_column.setCellValueFactory(new PropertyValueFactory<address, String>("Receptor_name"));

	}

}
