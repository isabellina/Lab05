package it.polito.tdp.lab05.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class AnagrammaDAO {

	public boolean isCorrect(String anagramma) {
	final String sql="SELECT 1 as ret "
				+ "FROM parola "
				+ "WHERE parola.nome= ? " ;
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, anagramma);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				return true;
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
