package demo;

import entity.Personnel;
import service.PersonnelManager;
import service.PersonnelManager2;

public class Manager2Demo {

	public static void main(String[] args) {
		Personnel p=new Personnel();
		PersonnelManager2 manager=new PersonnelManager2();
		p.setMat(6);
		p.setName("P6");
		p.setSalary(4230);
		
		manager.addPersonnel(p);

	}

}
