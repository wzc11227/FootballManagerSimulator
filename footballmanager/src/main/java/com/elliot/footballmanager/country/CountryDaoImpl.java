package com.elliot.footballmanager.country;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.elliot.footballmanager.database.SqliteDatabaseConnector;

/**
 * @author Elliot
 * 
 */
public class CountryDaoImpl implements CountryDao {
	
	public List<Country> getAllCountries() {
		List<Country> allCountries = new ArrayList<Country>();
		String query = "SELECT * FROM COUNTRY";
		
		try (Connection conn = SqliteDatabaseConnector.connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query)) {
			
			allCountries = new ArrayList<Country>();
			
			while (rs.next()) {
				allCountries.add(new Country(rs.getInt("COUNTRY_ID"), rs.getString("COUNTRY_NAME")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return allCountries;
	}

}