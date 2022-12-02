package service;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.Connexion2;
import entity.Personnel;

public class PersonnelManager {
	
	private static Connexion2 con;
	
	public PersonnelManager() {

		con=new Connexion2();
		
	}
	//Ajouter une Personne
	
	public void addPersonnel(Personnel p) {
		
		String sql="insert into Personnel values("+p.getMat()+",'"+p.getName()+"',"+p.getSalary()+")";
		con.sqlAction(sql);
		System.out.println("Record Inserted");
	}
	//Supprimer une Personne
	
		public void deletePersonnel(Personnel p) {
			
			String sql="delete from Personnel where mat="+p.getMat();
			con.sqlAction(sql);
			System.out.println("Record Deleted");
		}
		//Modifier une Personne
		
		public void updatePersonnel(Personnel p) {
			
			String sql="update Personnel set nom='"+p.getName()+"',salary="+p.getSalary()+"where mat="+p.getMat();
			con.sqlAction(sql);
			System.out.println("Record Updated");
		}
		//La recherche
		public Personnel searchPersonnel(int mat) {
			Personnel p=null;
			String sql="select * from Personnel where mat="+mat;
			ResultSet rs=con.sqlSelect(sql);
			try {
				if(rs.next()) {
					p=new Personnel();
					p.setMat(rs.getInt(1));
					p.setName(rs.getString(2));
					p.setSalary(rs.getFloat(3));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return p;
			
		}
		//L'affichage
				public void allPersonnel() {
					
					String sql="select * from Personnel ";
					ResultSet rs=con.sqlSelect(sql);
					try {
						while(rs.next()) {
							System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3));
							
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}

}












