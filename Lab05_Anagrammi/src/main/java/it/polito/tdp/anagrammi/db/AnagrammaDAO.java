package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnagrammaDAO {
	
	public boolean isCorrect(String anagramma) {
		
		boolean trovata=false;
		
		String sql="SELECT nome "
				 + "FROM parola "
				 + "WHERE nome=?";
		
		try {
			Connection conn=DBConnect.getConnection();
			PreparedStatement st=conn.prepareStatement(sql);
			st.setString(1, anagramma);
			ResultSet rs=st.executeQuery();
			
			if(rs.next()) {
				trovata=true;
			}
			
			rs.close();
			st.close();
			conn.close();
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		if(trovata)
			return true;
		
		return false;
	}
}
