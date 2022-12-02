package dao;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class Connexion2 {
	
	//Pour établir la connexion
	private Connection con;
	//Pour exécuter les requêtes
	private Statement st;
	//Pour Récuperer le résultyat d'une requpete select
	private ResultSet rs=null;
	
	
	public Connection getCon() {
		return con;
	}

	public Connexion2() {
		
		
		try {
			Properties properties=new Properties();
			FileInputStream data=new FileInputStream("src/data.properties");
			properties.load(data);
			//CHargement de Driver
			Class.forName(properties.getProperty("driver"));
			//Etablissement de la connexion
			con=DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"), properties.getProperty("password"));
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














