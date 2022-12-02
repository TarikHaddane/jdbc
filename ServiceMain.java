package demo;

import entity.Personnel;
import service.PersonnelManager;

public class ServiceMain {

	public static void main(String[] args) {


		Personnel p=new Personnel();
		PersonnelManager manager=new PersonnelManager();
		p.setMat(5);
		p.setName("New Name");
		p.setSalary(5555);
		//manager.updatePersonnel(p);
		Personnel pSearch=manager.searchPersonnel(0);
		if(pSearch!=null) {
			System.out.println(pSearch.getMat()+"\t"+pSearch.getName()+"\t"+pSearch.getSalary());
		}else {
			System.out.println("Personne Inexiste");
		}
		manager.allPersonnel();

	}

}
