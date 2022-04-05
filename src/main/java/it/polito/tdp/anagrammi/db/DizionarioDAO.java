package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class DizionarioDAO {
	
	
	List<String> resultsbagliate = new LinkedList<String>();
	
	public List<String> getParolegiuste(List<String> parole)
	{
		final String sql = "SELECT nome FROM dizionario.parola WHERE nome = ? ";

		List<String> result = new LinkedList<String>();
		resultsbagliate = new LinkedList<String>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			for(String par:parole)
			{
				st.setString(1, par);
				ResultSet rs = st.executeQuery();
				
				if(rs.next())
				{
					result.add(par);
				}
				else
				{
					resultsbagliate.add(par);
				}
				
			}

			conn.close();
			
			return result;
			
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	}

	public List<String> getResultsbagliate() {
		return resultsbagliate;
	}
	
	
		
}
