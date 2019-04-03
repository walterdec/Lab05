package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnagrammaDAO {
	
	public boolean isCorrect(String anagramma) {
		try {
			Connection conn = ConnectDB.getConnection();
				
				String query = "SELECT * FROM parola WHERE nome = ?";
				PreparedStatement st = conn.prepareStatement(query);
				st.setString(1, anagramma);
				ResultSet rs = st.executeQuery();
				
				
				while(rs.next()) {
					return true;
				}
					return false;
				
		}
		catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

}
