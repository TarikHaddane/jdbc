package dao;

import java.sql.*;

public class Connexion {
	
	//Pour établir la connexion
	private Connection con;
	//Pour exécuter les requêtes
	private Statement st;
	//Pour Récuperer le résultyat d'une requpete select
	private ResultSet rs=null;
	
	
	public Connexion() {
		
		try {
			//CHargement de Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Etablissement de la connexion
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Employe", "root", "");
			st=con.createStatement();
			System.out.println("Connected");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	public void sqlAction(String sql) {
		
		try {
			//Permet l'exécution des requêtes d'action : Insert - Delete - Update
			st.executeUpdate(sql);
			System.out.println("Action Success");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ResultSet sqlSelect(String sql) {
		
		try {
			//Permet d'exécuter une reqête de séléction : Select
			rs=st.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}

}














