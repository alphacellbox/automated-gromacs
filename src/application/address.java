package application;

public class address {
	String Receptor_name;
	String Receptor_path;
String ligands_path;
public address(String receptor_name, String receptor_path, String ligands_path) {
	super();
	Receptor_name = receptor_name;
	Receptor_path = receptor_path;
	this.ligands_path = ligands_path;
}
public String getReceptor_name() {
	return Receptor_name;
}
public void setReceptor_name(String receptor_name) {
	Receptor_name = receptor_name;
}
public String getReceptor_path() {
	return Receptor_path;
}
public void setReceptor_path(String receptor_path) {
	Receptor_path = receptor_path;
}
public String getLigands_path() {
	return ligands_path;
}
public void setLigands_path(String ligands_path) {
	this.ligands_path = ligands_path;
}




}
