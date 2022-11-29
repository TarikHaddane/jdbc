package demo;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.Connexion;

public class ConnexionMain {

	public static void main(String[] args) throws SQLException {


		Connexion con=new Connexion();
		
		String sql="select * from Personnel";
		//con.sqlAction(sql);
		ResultSet rs=con.sqlSelect(sql);
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3));
		}
		

	}

}
