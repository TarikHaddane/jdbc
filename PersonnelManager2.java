package service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.Connexion2;
import entity.Personnel;

public class PersonnelManager2 {
	
	private static Connexion2 con;
	
	public PersonnelManager2() {

		con=new Connexion2();
		
	}
	//Ajouter une Personne
	
	public void addPersonnel(Personnel p)  {
		
		String sql="insert into Personnel values(?,?,?)";
		try {
			PreparedStatement statement=con.getCon().prepareStatement(sql);
			statement.setInt(1, p.getMat());
			statement.setString(2, p.getName());
			statement.setFloat(3, p.getSalary());
			statement.execute();
			
			System.out.println("Record Inserted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//Supprimer une Personne
	
		public void deletePersonnel(Personnel p) {
			
			String sql="delete from Personnel where mat=?";
			PreparedStatement statement;
			try {
				statement = con.getCon().prepareStatement(sql);
				statement.setInt(1, p.getMat());
				statement.execute();
				System.out.println("Record Deleted");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		//Modifier une Personne
		
		public void updatePersonnel(Personnel p) {
			
			String sql="update Personnel set nom=?,salary=? where mat=?";
			try {
				PreparedStatement statement=con.getCon().prepareStatement(sql);
				statement.setInt(3, p.getMat());
				statement.setString(1, p.getName());
				statement.setFloat(2, p.getSalary());
				statement.execute();
				System.out.println("Record Updated");
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		//La recherche
		public Personnel searchPersonnel(int mat) {
			Personnel p=null;
			String sql="select * from Personnel where mat=?";
			PreparedStatement statement;
			try {
				statement = con.getCon().prepareStatement(sql);
				statement.setInt(1, p.getMat());
				ResultSet rs=statement.executeQuery();
				if(rs.next()) {
					p=new Personnel();
					p.setMat(rs.getInt(1));
					p.setName(rs.getString(2));
					p.setSalary(rs.getFloat(3));
				}
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
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












